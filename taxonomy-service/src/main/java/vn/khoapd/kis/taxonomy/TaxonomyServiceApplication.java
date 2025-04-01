package vn.khoapd.kis.taxonomy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import vn.khoapd.kis.shared.config.ModelMapperConfig;
import vn.khoapd.kis.shared.exception.GlobalExceptionHandler;

@SpringBootApplication
@Import({GlobalExceptionHandler.class, ModelMapperConfig.class})
public class TaxonomyServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(TaxonomyServiceApplication.class, args);
    }

}
