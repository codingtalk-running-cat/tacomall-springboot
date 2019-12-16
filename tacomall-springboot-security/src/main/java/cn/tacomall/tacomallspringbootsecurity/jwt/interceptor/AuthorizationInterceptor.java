package cn.tacomall.tacomallspringbootsecurity.jwt.interceptor;

import java.util.Map;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;

import cn.tacomall.tacomallspringbootcommon.utils.JwtUtil;
import cn.tacomall.tacomallspringbootutils.StringUtil;
import cn.tacomall.tacomallspringbootcommon.utils.ExceptionUtil;
import cn.tacomall.tacomallspringbootsecurity.jwt.annotation.*;

public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String TOKEN_KEY = "x-access-token";
    public static final String USER_KEY = "LOGIN_USER_KEY";

    @Autowired(required = false)
    private JwtUtil jwtUtil;

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
                Map<String, String> res = JwtUtil.verify(token);
                request.setAttribute(USER_KEY, res);
            }
        }
        return true;
    }
}
