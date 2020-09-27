/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-09-27 15:23:26
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-api/tacomall-api-merchant/src/main/java/cn/codingtalk/tacomallapimerchant/aspect/LoginLoggerAspect.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapimerchant.aspect;

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

import cn.codingtalk.tacomallcommon.utils.JsonUtil;
import cn.codingtalk.tacomallcommon.utils.IpUtil;
import cn.codingtalk.tacomallentity.merchant.MerchantUserLoginLogger;
import cn.codingtalk.tacomallmapper.merchant.MerchantUserLoginLoggerMapper;

@Aspect
@Component
public class LoginLoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MerchantUserLoginLoggerMapper merchantUserLoginLoggerMapper;

    @Pointcut("@annotation(cn.codingtalk.tacomallapimerchant.annotation.LoginLogger)")
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

        MerchantUserLoginLogger merchantUserLoginLogger = new MerchantUserLoginLogger();

        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        this.logger.info(className + "." + methodName + "()");
        Object[] args = joinPoint.getArgs();
        try {
            String params = JsonUtil.toJson(args);
            this.logger.info(params);
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();
            merchantUserLoginLogger.setIp(IpUtil.getIpAddr(request));
            merchantUserLoginLogger.setCreateTime(new Date());
            merchantUserLoginLoggerMapper.insert(merchantUserLoginLogger);
        } catch (Exception ignored) {

        }
    }
}
