/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-18 20:50:48
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-common/src/main/java/cn/codingtalk/tacomallcommon/exceptionInterceptor/ExceptionInterceptor.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallcommon.exceptionInterceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallcommon.enumeration.BizEnum;
import cn.codingtalk.tacomallcommon.enumeration.ExceptionEnum;
import cn.codingtalk.tacomallcommon.exceptionInterceptor.exception.*;

@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseVo<String> bizErrorHandler(HttpServletRequest req, BizException e) throws Exception {
        ResponseVo<String> bizError = new ResponseVo<>();
        bizError.setStatus(false);
        bizError.setCode(BizEnum.FALSE.getCode());
        bizError.setMessage(e.getMessage());
        return bizError;
    }

    @ExceptionHandler(value = SqlException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseVo<String> sqlErrorHandler(HttpServletRequest req, SqlException e) throws Exception {
        ResponseVo<String> sqlError = new ResponseVo<>();
        sqlError.setStatus(false);
        sqlError.setCode(ExceptionEnum.SERVER_ERROR.getCode());
        sqlError.setMessage(e.getMessage());
        return sqlError;
    }
}
