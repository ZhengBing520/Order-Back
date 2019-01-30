package com.zb.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bzheng on 2019/1/27.
 */
public class CommonUtil {

    private static ServletRequestAttributes getServletRequestAttributes() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes;
    }

    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = getServletRequestAttributes().getRequest();
        return request;
    }

    /**
     * 获取response
     * @return
     */
    public static HttpServletResponse getResponse() {
        HttpServletResponse response = getServletRequestAttributes().getResponse();
        return response;
    }

}
