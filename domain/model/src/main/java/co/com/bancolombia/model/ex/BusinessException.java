package co.com.bancolombia.model.ex;

public class BusinessException extends RuntimeException {

    private final String errorCode;
    private final int httpStatus;

    public BusinessException(final String errorCode, final String message) {
        this(errorCode, 400, message);
    }

    public BusinessException(final String errorCode, final int httpStatus,final String message) {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public BusinessException(final String errorCode, final int httpStatus,final String message, final Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
