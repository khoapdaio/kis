package vn.khoapd.kis.product.mapper.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.product.dto.ProductDto;
import vn.khoapd.kis.product.entity.ProductEo;
import vn.khoapd.kis.product.mapper.IProductMapper;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductMapperImpl implements IProductMapper {
    private final ModelMapper modelMapper;


    @Override
    public ProductDto toDto(ProductEo entity) {
        return modelMapper.map(entity, ProductDto.class);
    }

    @Override
    public ProductEo toEntity(ProductDto dto) {
        return modelMapper.map(dto, ProductEo.class);
    }

    @Override
    public Collection<ProductEo> toEntityCollection(Collection<ProductDto> dtoCollection) {
        return List.of(modelMapper.map(dtoCollection, ProductEo.class));
    }

    @Override
    public Collection<ProductDto> toDtoCollection(Collection<ProductEo> entityCollection) {
        return List.of(modelMapper.map(entityCollection, ProductDto.class));
    }
}
