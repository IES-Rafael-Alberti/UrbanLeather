package backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // RUTA ABSOLUTA SEGURA
    private static final String UPLOAD_PATH =
            Paths.get("uploads").toAbsolutePath().toString();

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        System.out.println("Sirviendo archivos desde: " + UPLOAD_PATH);

        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:" + UPLOAD_PATH + "/");
    }
}