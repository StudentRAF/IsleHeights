package rs.raf.student.isleheights.logger;

import org.springframework.http.ResponseEntity;
import rs.raf.student.isleheights.exception.IsleHeightsException;

import java.util.function.Supplier;

public class LoggerUtils {

    public static <Type> ResponseEntity<Type> handleResponse(Supplier<ResponseEntity<Type>> supplier) {
        try {
            return supplier.get();
        }
        catch (IsleHeightsException exception) {
            return ResponseEntity.status(exception.getHttpStatus()).build();
        }
    }

}
