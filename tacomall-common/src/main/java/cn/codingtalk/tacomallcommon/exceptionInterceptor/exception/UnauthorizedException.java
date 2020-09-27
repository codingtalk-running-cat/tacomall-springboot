package cn.codingtalk.tacomallcommon.exceptionInterceptor.exception;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
