package rs.raf.student.isleheights.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;
import rs.raf.student.isleheights.logger.Logger;

@Getter
public class IsleHeightsException extends RuntimeException {

    private final HttpStatusCode httpStatus;

    public IsleHeightsException(IException exception, String... args) {
        Logger.log(exception.severity(), exception.pattern(), args);

        httpStatus = exception.httpStatus();
    }

}
