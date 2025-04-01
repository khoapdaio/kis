package vn.khoapd.kis.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.product.dto.ProductDto;
import vn.khoapd.kis.product.entity.ProductEo;
import vn.khoapd.kis.product.mapper.IProductMapper;
import vn.khoapd.kis.product.repository.IProductRepository;
import vn.khoapd.kis.shared.enums.EEntityName;
import vn.khoapd.kis.shared.service.AbstractBaseServiceImpl;

@Service
@Slf4j
public class ProductServiceImpl extends AbstractBaseServiceImpl<
        ProductEo, ProductDto, Long, IProductRepository, IProductMapper> {


    @Override
    protected String getEntityName() {
        return EEntityName.PRODUCT.getName();
    }

    @Override
    public ProductDto findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    protected void beforeCreate(ProductDto dto) {

    }

    @Override
    protected void beforeUpdate(ProductEo entity, ProductEo newEntity) {

    }
}
