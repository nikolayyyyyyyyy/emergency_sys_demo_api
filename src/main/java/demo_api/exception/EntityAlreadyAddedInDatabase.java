package demo_api.exception;

public class EntityAlreadyAddedInDatabase extends RuntimeException {
    public EntityAlreadyAddedInDatabase(String message) {
        super(message);
    }
}
