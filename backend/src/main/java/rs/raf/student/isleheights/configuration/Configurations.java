package rs.raf.student.isleheights.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Configurations {

    @NoArgsConstructor
    @Accessors(fluent = true)
    @Configuration(Application.BEEN_NAME)
    public static class Application {

        public static final String BEEN_NAME = "configurations.application";

        @Getter
        private static String name;
        @Getter
        private static String contextPath;
        @Getter
        private static Integer port;

        @Value("${spring.application.name}")
        private void setName(String value) {
            name = value;
        }

        @Value("${server.port}")
        private void setPort(Integer value) {
            port = value;
        }

        @Value("${server.servlet.context-path}")
        private void setContextPath(String value) {
            contextPath = value;
        }

    }

    @NoArgsConstructor
    @Accessors(fluent = true)
    @Configuration(Jwt.BEEN_NAME)
    public static class Jwt {

        public static final String BEEN_NAME = "configurations.jwt";

        @Getter
        private static String secret;
        @Getter
        private static Integer expirationInHours;

        @Value("${isle_heights.jwt.secret}")
        private void setSecret(String value) {
            secret = value;
        }

        @Value("${isle_heights.jwt.expiration_time_hours}")
        private void setExpiration(Integer value) {
            expirationInHours = value;
        }

    }

    @NoArgsConstructor
    @Accessors(fluent = true)
    @Configuration(Cors.BEEN_NAME)
    public static class Cors {

        public static final String BEEN_NAME = "configurations.cors";

        @Getter
        private static String[] allowedOrigins;
        @Getter
        private static String[] allowedMethods;
        @Getter
        private static String[] allowedHeaders;
        @Getter
        private static Boolean allowCredentials;
        @Getter
        private static String mappingPath;

        @Value("${isle_heights.cors.allowed-origins}")
        public void setAllowedOrigins(String value) {
            allowedOrigins = value.split(",");
        }

        @Value("${isle_heights.cors.allowed-methods}")
        public void setAllowedMethods(String value) {
            allowedMethods = value.split(",");
        }

        @Value("${isle_heights.cors.allowed-headers}")
        public void setAllowedHeaders(String value) {
            allowedHeaders = value.split(",");
        }

        @Value("${isle_heights.cors.allow-credentials}")
        public void setAllowCredentials(Boolean value) {
            allowCredentials = value;
        }

        @Value("${isle_heights.cors.mapping-path}")
        public void setMappingPath(String value) {
            mappingPath = value;
        }

    }

}
