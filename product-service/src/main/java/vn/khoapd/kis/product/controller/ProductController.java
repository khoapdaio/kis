package vn.khoapd.kis.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.khoapd.kis.product.dto.ProductDto;
import vn.khoapd.kis.product.entity.ProductEo;
import vn.khoapd.kis.product.mapper.IProductMapper;
import vn.khoapd.kis.product.repository.IProductRepository;
import vn.khoapd.kis.product.service.ProductServiceImpl;
import vn.khoapd.kis.shared.controller.AbstractBaseController;
import vn.khoapd.kis.shared.enums.EEntityName;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController extends AbstractBaseController<
        ProductEo, ProductDto, Long, IProductRepository, IProductMapper, ProductServiceImpl> {

    @Override
    protected String getEntityName() {
        return EEntityName.PRODUCT.getName();
    }


}
