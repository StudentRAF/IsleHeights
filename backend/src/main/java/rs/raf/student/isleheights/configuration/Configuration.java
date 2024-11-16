package rs.raf.student.isleheights.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Configuration {

    @Component
    @Accessors(fluent = true)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Application {

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

    @Component
    @Accessors(fluent = true)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Jwt {

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

    @Component
    @Accessors(fluent = true)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Cors {

        @Getter
        private static String allowedOrigins;
        @Getter
        private static String allowedMethods;
        @Getter
        private static String allowedHeaders;
        @Getter
        private static Boolean allowCredentials;
        @Getter
        private static String mappingPath;

        @Value("${isle_heights.cors.allowed-origins}")
        public void setAllowedOrigins(String value) {
            allowedOrigins = value;
        }

        @Value("${isle_heights.cors.allowed-methods}")
        public void setAllowedMethods(String value) {
            allowedMethods = value;
        }

        @Value("${isle_heights.cors.allowed-headers}")
        public void setAllowedHeaders(String value) {
            allowedHeaders = value;
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
