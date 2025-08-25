package co.com.bancolombia.model.ex;

public class ValidationException extends BusinessException {
    public ValidationException(final String message) {
        super("VALIDATION_ERROR", 400, message);
    }
}
