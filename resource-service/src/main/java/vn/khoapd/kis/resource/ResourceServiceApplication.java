package vn.khoapd.kis.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import vn.khoapd.kis.shared.config.ModelMapperConfig;
import vn.khoapd.kis.shared.exception.GlobalExceptionHandler;

@SpringBootApplication
@Import({GlobalExceptionHandler.class, ModelMapperConfig.class})
public class ResourceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServiceApplication.class, args);
    }

}
