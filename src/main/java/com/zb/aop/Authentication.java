package com.zb.aop;

import com.zb.common.Constant;
import com.zb.common.utils.CommonUtil;
import com.zb.dao.BaseDao;
import com.zb.entity.BaseEntity;
import com.zb.exception.UnauthenticatedException;
import com.zb.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * Created by bzheng on 2019/1/27.
 * 登录验证
 */
@Aspect
@Component
public class Authentication {

    @Autowired
    LoginService loginService;

    // 配置切入点
   @Pointcut("execution(* com.zb.controller.*.*(..))")
    public void pointcut() {

   }

    // 配置切入点
    /*@Pointcut("execution(* com.zb.dao.*.update*(..))")
    public void pointcutDao() {

    }*/

   @Around("pointcut()")
   public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
       HttpServletRequest request = CommonUtil.getRequest();
       String token = request.getHeader(Constant.X_Auth_Token);
       String requestURI = request.getRequestURI();
       if ("/api/plat/login".equals(requestURI)) {
           //登录方法，放行
           return pjp.proceed();
       }
       if (Objects.isNull(token)) {
           throw new UnauthenticatedException("请先登录");
       }
       // 验证token
       if (loginService.verifyToken(token)) {
           return pjp.proceed();
       }
       throw new UnauthenticatedException("登录信息过期，请从新登录");
   }

//   @Around("pointcutDao()")
    public Object doAround_Dao(ProceedingJoinPoint point) throws Throwable {
       // 获取目标对象
       Object target = point.getTarget();
       BaseDao baseDao = null;
       BaseEntity baseEntity = null;
       Integer id = null;
       // 向上转型
       if (target instanceof BaseDao) {
           baseDao = (BaseDao)target;
       }
       // 获取参数
       Object[] args = point.getArgs();
       Object arg = args[0];
       if (arg instanceof BaseEntity) {
           baseEntity =  (BaseEntity)arg;
           id = baseEntity.getId();
       }
       // 获取旧值
       BaseEntity entity = baseDao.selectById(id);
       // 找到修改方法
       MethodSignature signature = (MethodSignature) point.getSignature();
       Method method = signature.getMethod();
       // 获取方法返回值 update的返回值为int
       Object proceed = point.proceed();
       // 根据返回值判断是否有修改数据
       Integer count = Integer.valueOf(proceed.toString());
       if (count > 0) {
           // 比较两个值
           contrastObj(entity, baseEntity);

       }
       System.out.println("方法名称：" + method.getName());

       return proceed;
   }

    /**
     * 比较两个对象的值
     * @param oldEntity
     * @param newEntity
     */
    private void contrastObj(Object oldEntity, Object newEntity) {
        Class<?> oldEntityClass = oldEntity.getClass();
        // 获取对象的所有属性
        Field[] declaredFields = oldEntity.getClass().getDeclaredFields();
        try {
            for (Field field : declaredFields) {
                if("serialVersionUID".equals(field.getName())){
                    continue;
                }
                // 调用对象的get方法，比较值
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), oldEntityClass);
                Method getMethod = propertyDescriptor.getReadMethod();
                Object oldValue = getMethod.invoke(oldEntity);
                Object newValue = getMethod.invoke(newEntity);
                // 比较两个属性的值
                if (Objects.isNull(oldEntity) || Objects.isNull(newValue)) {
                    continue;
                }
                // 记录修改的值
                if (!StringUtils.equals(oldValue.toString(), newValue.toString())) {
                    System.out.println("字段名称：" + field.getName() + "，旧值：" + oldValue + "，新值：" + newValue);
                }
            }
        } catch (Exception e) {

        }

    }
}
