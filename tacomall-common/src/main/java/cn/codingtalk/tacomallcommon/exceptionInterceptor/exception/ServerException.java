package cn.codingtalk.tacomallcommon.exceptionInterceptor.exception;

public class ServerException extends RuntimeException {
    public ServerException(String message) {
        super(message);
    }
}
