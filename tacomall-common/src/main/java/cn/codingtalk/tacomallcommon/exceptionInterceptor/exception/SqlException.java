package cn.codingtalk.tacomallcommon.exceptionInterceptor.exception;

public class SqlException extends RuntimeException {
    public SqlException(String message) {
        super(message);
    }
}
