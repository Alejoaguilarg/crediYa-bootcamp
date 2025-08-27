package co.com.bancolombia.model.ex;

public class EntityNotFoundRuleException extends BusinessRuleException {
    public EntityNotFoundRuleException(String message) {
        super("ENTITY_NOT_FOUND", 400, message);
    }
}
