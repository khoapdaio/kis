package vn.khoapd.kis.product.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import vn.khoapd.kis.product.dto.CategoryDto;

@FeignClient(
        name = "category-service",
        url = "${application.config.category-url}"
)
public interface ICategoryClient {
    @GetMapping
    CategoryDto findById(long id);
}
