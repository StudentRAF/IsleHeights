package rs.raf.student.isleheights.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import rs.raf.student.isleheights.configuration.Configurations;

import java.util.List;

@Configuration
@DependsOn(Configurations.Cors.BEEN_NAME)
public class WebConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of(Configurations.Cors.allowedOrigins()));
        configuration.setAllowedMethods(List.of(Configurations.Cors.allowedMethods()));
        configuration.setAllowedHeaders(List.of(Configurations.Cors.allowedHeaders()));
        configuration.setAllowCredentials(Configurations.Cors.allowCredentials());

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(Configurations.Cors.mappingPath(), configuration);

        return new CorsFilter(source);
    }
}
