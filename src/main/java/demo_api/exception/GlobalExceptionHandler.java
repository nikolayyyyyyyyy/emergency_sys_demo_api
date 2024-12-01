package demo_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException entityNotFoundException){
        return new ResponseEntity<>(entityNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyAddedInDatabase.class)
    public ResponseEntity<String> handlerRegionNotFoundException(EntityAlreadyAddedInDatabase entityAlreadyAddedInDatabase){
        return new ResponseEntity<>(entityAlreadyAddedInDatabase.getMessage(), HttpStatus.NOT_FOUND);
    }
}
