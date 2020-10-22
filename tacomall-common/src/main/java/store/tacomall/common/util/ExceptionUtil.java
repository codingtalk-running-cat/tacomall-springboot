/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-10-19 16:56:59
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: /tacomall-springboot/tacomall-common/src/main/java/store/tacomall/common/utils/ExceptionUtil.java
 * @微信:  13680065830
 * @邮箱:  3189482282@qq.com
 * @oops: Just do what I think it is right
 */
package store.tacomall.common.util;

import store.tacomall.common.exceptionInterceptor.exception.*;

public class ExceptionUtil {
    public static void throwBizException(String message) throws BizException {
        throw new BizException(message);
    }

    public static void throwClientException(String message) throws ClientException {
        throw new ClientException(message);
    }

    public static void throwServerException(String message) throws ServerException {
        throw new ServerException(message);
    }

    public static void throwSqlException(String message) throws SqlException {
        throw new SqlException(message);
    }

    public static void throwUnauthorizedException(String message) throws UnauthorizedException {
        throw new UnauthorizedException(message);
    }
}
