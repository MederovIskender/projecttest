package kg.megacom.eventcalendar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExceptions extends RuntimeException{
    public UserNotFoundExceptions() {
    }

    public UserNotFoundExceptions(String message) {
        super(message);
    }

    public UserNotFoundExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundExceptions(Throwable cause) {
        super(cause);
    }

    public UserNotFoundExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
