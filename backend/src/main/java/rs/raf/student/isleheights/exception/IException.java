package rs.raf.student.isleheights.exception;

import org.springframework.http.HttpStatusCode;

public interface IException {

    String pattern();

    HttpStatusCode httpStatus();

    Severity severity();

}
