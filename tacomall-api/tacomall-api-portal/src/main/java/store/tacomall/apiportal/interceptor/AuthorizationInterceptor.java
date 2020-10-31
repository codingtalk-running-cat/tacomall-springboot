/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-30 18:00:53
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-portal/src/main/java/store/tacomall/apiportal/interceptor/AuthorizationInterceptor.java
 * @Just do what I think it is right
 */
package store.tacomall.apiportal.interceptor;

import java.util.Map;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.tacomall.apiportal.annotation.LoginUser;
import store.tacomall.common.util.ExceptionUtil;
import store.tacomall.common.util.JwtUtil;
import store.tacomall.common.util.StringUtil;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.method.HandlerMethod;

public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String TOKEN_KEY = "x-access-token";
    public static final String USER_KEY = "LOGIN_USER_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(LoginUser.class)) {
            LoginUser loginUser = method.getAnnotation(LoginUser.class);
            String token = request.getHeader(TOKEN_KEY);
            if (loginUser.required() && StringUtil.isBlank(token)) {
                ExceptionUtil.throwUnauthorizedException("token不能为空");
            }
            if (!StringUtil.isBlank(token)) {
                JwtUtil jwtUtil = new JwtUtil();
                jwtUtil.setISSUER("api-portal");
                Map<String, String> res = jwtUtil.verify(token);
                request.setAttribute(USER_KEY, res);
            }
        }
        return true;
    }
}
