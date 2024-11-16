package rs.raf.student.isleheights.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
public enum ExceptionType implements IException {

    GET_BYTES_FILE_FAILED_STORE("""
                                Could get bytes from file. The temporary store for file "{0}" has failed.\
                                """, Severity.DEBUG, HttpStatus.NOT_FOUND),

    FIND_IMAGE_NOT_FOUND_ID("""
                            Could not find image. Image with id "{0}" does not exist.\
                            """, Severity.DEBUG, HttpStatus.NOT_FOUND),

    FIND_LEVEL_NOT_FOUND_NAME("""
                              Could not find level. Level with name "{0}" does not exist.\
                              """, Severity.DEBUG, HttpStatus.NOT_FOUND),
    ;

    private final String     pattern;
    private final Severity   severity;
    private final HttpStatus httpStatus;

    @Override
    public String pattern() {
        return pattern;
    }

    @Override
    public HttpStatusCode httpStatus() {
        return httpStatus;
    }

    @Override
    public Severity severity() {
        return severity;
    }

}
