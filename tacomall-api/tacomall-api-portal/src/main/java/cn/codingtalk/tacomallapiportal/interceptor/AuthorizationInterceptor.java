/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 14:46:25
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/cn/codingtalk/tacomallapiportal/interceptor/AuthorizationInterceptor.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.interceptor;

import java.util.Map;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.codingtalk.tacomallapiportal.annotation.IgnoreAuth;
import cn.codingtalk.tacomallapiportal.annotation.RequireAuth;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import cn.codingtalk.tacomallcommon.utils.JwtUtil;
import cn.codingtalk.tacomallcommon.utils.StringUtil;
import cn.codingtalk.tacomallcommon.utils.ExceptionUtil;
import cn.codingtalk.tacomallapiportal.annotation.*;

public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String TOKEN_KEY = "x-access-token";
    public static final String USER_KEY = "LOGIN_USER_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(IgnoreAuth.class)) {
            IgnoreAuth ignoreAuth = method.getAnnotation(IgnoreAuth.class);
            if (ignoreAuth.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(RequireAuth.class)) {
            RequireAuth requireAuth = method.getAnnotation(RequireAuth.class);
            if (requireAuth.required()) {
                String token = request.getHeader(TOKEN_KEY);
                if (StringUtil.isBlank(token)) {
                    ExceptionUtil.throwUnauthorizedException("token不能为空");
                }
                JwtUtil jwtUtil = new JwtUtil();
                jwtUtil.setISSUER("api-portal");
                Map<String, String> res = jwtUtil.verify(token);
                request.setAttribute(USER_KEY, res);
            }
        }
        return true;
    }
}
