package vn.khoapd.kis.taxonomy.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.taxonomy.dto.TagDto;
import vn.khoapd.kis.taxonomy.entity.TagEo;
import vn.khoapd.kis.taxonomy.mapper.ITagMapper;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagMapperImpl implements ITagMapper {
    private final ModelMapper modelMapper;

    @Override
    public TagDto toDto(TagEo entity) {
        return modelMapper.map(entity, TagDto.class);
    }

    @Override
    public TagEo toEntity(TagDto dto) {
        return modelMapper.map(dto, TagEo.class);
    }

    @Override
    public Collection<TagEo> toEntityCollection(Collection<TagDto> dtoCollection) {
        return List.of(modelMapper.map(dtoCollection, TagEo.class));
    }

    @Override
    public Collection<TagDto> toDtoCollection(Collection<TagEo> entityCollection) {
        return List.of(modelMapper.map(entityCollection, TagDto.class));
    }
}
