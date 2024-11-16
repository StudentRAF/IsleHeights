package rs.raf.student.isleheights;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rs.raf.student.isleheights.logger.Logger;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Logger.setLogger(LoggerFactory.getLogger(Application.class));

        SpringApplication.run(Application.class, args);
    }

}
