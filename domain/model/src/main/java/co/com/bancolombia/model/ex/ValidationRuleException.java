package co.com.bancolombia.model.ex;

public class ValidationRuleException extends BusinessRuleException {
    public ValidationRuleException(final String message) {
        super("VALIDATION_ERROR", 400, message);
    }
}
