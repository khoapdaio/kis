package vn.khoapd.kis.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.grpc.client.EnableGrpcClients;
import vn.khoapd.kis.shared.config.ModelMapperConfig;
import vn.khoapd.kis.shared.exception.GlobalExceptionHandler;

@SpringBootApplication
@Import({GlobalExceptionHandler.class, ModelMapperConfig.class})
@EnableFeignClients
@EnableGrpcClients
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
