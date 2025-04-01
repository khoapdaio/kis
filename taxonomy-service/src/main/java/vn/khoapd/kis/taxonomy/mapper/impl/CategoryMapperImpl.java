package vn.khoapd.kis.taxonomy.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.taxonomy.dto.CategoryDto;
import vn.khoapd.kis.taxonomy.entity.CategoryEo;
import vn.khoapd.kis.taxonomy.mapper.ICategoryMapper;

import java.util.Collection;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryMapperImpl implements ICategoryMapper {
    private final ModelMapper modelMapper;


    @Override
    public CategoryDto toDto(CategoryEo entity) {
        return modelMapper.map(entity, CategoryDto.class);
    }

    @Override
    public CategoryEo toEntity(CategoryDto dto) {
        return modelMapper.map(dto, CategoryEo.class);
    }

    @Override
    public Collection<CategoryEo> toEntityCollection(Collection<CategoryDto> dtoCollection) {
        return List.of(modelMapper.map(dtoCollection, CategoryEo.class));
    }

    @Override
    public Collection<CategoryDto> toDtoCollection(Collection<CategoryEo> entityCollection) {
        return List.of(modelMapper.map(entityCollection, CategoryDto.class));
    }
}
