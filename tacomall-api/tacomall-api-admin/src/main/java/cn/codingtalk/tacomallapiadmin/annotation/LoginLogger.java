/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 17:12:55
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-admin\src\main\java\cn\codingtalk\tacomallapiadmin\annotation\LoginLogger.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiadmin.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginLogger {
    String value() default "登录日志";
}
