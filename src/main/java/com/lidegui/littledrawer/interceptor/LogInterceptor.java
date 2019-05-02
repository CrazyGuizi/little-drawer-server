package com.lidegui.littledrawer.interceptor;

import com.alibaba.fastjson.JSON;
import com.lidegui.littledrawer.util.Util;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @Author: lidegui
 * @Date:Created in 10:33 2019/4/19
 */
public class LogInterceptor implements HandlerInterceptor {


    public static final String LOG_RETURN = "logReturn";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {


        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        long t1 = System.currentTimeMillis();
        Util.log("处理来自请求" + request.getRequestURL().toString());
        Map<String, String[]> map = request.getParameterMap();
        Util.log("请求体");
        map.forEach((key, val) -> {
            Util.log(String.format("key:%s\tvalues:%s", key, val));
        });

        long t2 = System.currentTimeMillis();
        Util.log("响应请求" + request.getRequestURL().toString() + "\t" + (t2 - t1) + "ms");
        Util.log("响应体:");
        String res = (String) request.getAttribute(LOG_RETURN);
        if (!Util.isEmpty(res))
            Util.log(res);
    }
}
