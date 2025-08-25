package co.com.bancolombia.model.ex;

public class EntityNotFoundException extends BusinessException {
    public EntityNotFoundException(String message) {
        super("ENTITY_NOT_FOUND", 400, message);
    }
}
