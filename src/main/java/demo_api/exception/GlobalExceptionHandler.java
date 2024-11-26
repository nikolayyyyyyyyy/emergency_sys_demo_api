package demo_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFountException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFountException categoryNotFountException){
        return new ResponseEntity<>(categoryNotFountException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RegionNotFoundException.class)
    public ResponseEntity<String> handlerRegionNotFoundException(RegionNotFoundException regionNotFoundException){
        return new ResponseEntity<>(regionNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<String> handlerMessageNotFoundException(MessageNotFoundException messageNotFoundException){
        return new ResponseEntity<>(messageNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
