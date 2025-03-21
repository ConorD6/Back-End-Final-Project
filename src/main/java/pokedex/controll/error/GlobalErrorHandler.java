package pokedex.controll.error;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

	 @ExceptionHandler(NoSuchElementException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public Map<String, String> handleNoSuchElementException(NoSuchElementException ex) {
	        log.error("Trainer Not Found: {}", ex.toString());
	        return Map.of("message", ex.toString());
	    }
}
