package kg.megacom.eventcalendar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    // Exception handling of data's validation
    @ExceptionHandler
    protected ResponseEntity<?> handleMethodArgumentNotValid(BindException ex) {
        var bindResultFieldErrors = ex.getFieldErrors().stream()
                .map(fieldError -> String.format( "%s -> %s",
                        fieldError.getField(),
                        fieldError.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(bindResultFieldErrors, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<?> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex){
        String requiredType;
        try {
            requiredType = ex.getRequiredType().getName();
        }catch (NullPointerException nullPointerException){
            requiredType = "(требуемый тип не определен)";
        }
        return new ResponseEntity<>(String.format("Значение '%s' параметра '%s' должно быть типа '%s'.",
                                                    ex.getValue(), ex.getName(), requiredType), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingParams(MissingServletRequestParameterException ex) {
        return new ResponseEntity<>(String.format("Параметр '%s' отсутствует.", ex.getParameterName()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
