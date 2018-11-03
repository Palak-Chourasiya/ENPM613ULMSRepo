package prototype.entityexceptions;

public class EntityNotFoundException extends RuntimeException {
	public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}
