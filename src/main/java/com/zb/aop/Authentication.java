package com.zb.aop;

import com.zb.common.Constant;
import com.zb.common.utils.CommonUtil;
import com.zb.exception.UnauthenticatedException;
import com.zb.service.LoginService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
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
}
