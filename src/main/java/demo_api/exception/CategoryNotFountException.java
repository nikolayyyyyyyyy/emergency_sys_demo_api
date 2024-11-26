package demo_api.exception;

public class CategoryNotFountException extends RuntimeException {

    public CategoryNotFountException(String message) {
        super(message);
    }
}
