package vn.khoapd.kis.resource.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.resource.dto.BucketDto;
import vn.khoapd.kis.resource.entity.BucketEo;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BucketMapperImpl implements IBucketMapper {
    private final ModelMapper modelMapper;

    @Override
    public BucketDto toDto(BucketEo entity) {
        return modelMapper.map(entity, BucketDto.class);
    }

    @Override
    public BucketEo toEntity(BucketDto dto) {
        return modelMapper.map(dto, BucketEo.class);
    }

    @Override
    public Collection<BucketEo> toEntityCollection(Collection<BucketDto> dtoCollection) {
        return List.of(modelMapper.map(dtoCollection, BucketEo.class));
    }

    @Override
    public Collection<BucketDto> toDtoCollection(Collection<BucketEo> entityCollection) {
        return List.of(modelMapper.map(entityCollection, BucketDto.class));
    }
}
