/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-07-02 09:28:19
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-admin/src/main/java/store/tacomall/apiadmin/aspect/LoginLoggerAspect.java
 * @Just do what I think it is right
 */
package store.tacomall.apiadmin.aspect;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import store.tacomall.common.util.IpUtil;
import store.tacomall.common.util.JsonUtil;
import store.tacomall.common.entity.admin.AdminUserLoginLogger;
import store.tacomall.common.mapper.admin.AdminUserLoginLoggerMapper;

@Aspect
@Component
public class LoginLoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminUserLoginLoggerMapper adminUserLoginLoggerMapper;

    @Pointcut("@annotation(store.tacomall.apiadmin.annotation.LoginLogger)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        AdminUserLoginLogger adminUserLoginLogger = new AdminUserLoginLogger();

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        this.logger.info(className + "." + methodName + "()");
        Object[] args = joinPoint.getArgs();
        try {
            String params = JsonUtil.toJson(args);
            this.logger.info(params);
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            adminUserLoginLogger.setIp(IpUtil.getIpAddr(request));
            adminUserLoginLogger.setCreateTime(new Date());
            adminUserLoginLoggerMapper.insert(adminUserLoginLogger);
        } catch (Exception ignored) {

        }
    }
}
