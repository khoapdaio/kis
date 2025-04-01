package vn.khoapd.kis.taxonomy.mapper.impl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.taxonomy.dto.AdministrativeAddressDto;
import vn.khoapd.kis.taxonomy.entity.AdministrativeAddressEo;
import vn.khoapd.kis.taxonomy.mapper.IAdministrativeAddressMapper;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class AdministrativeAddressMapperImpl implements IAdministrativeAddressMapper {
    private final ModelMapper modelMapper;

    @Override
    public AdministrativeAddressDto toDto(AdministrativeAddressEo entity) {
        return modelMapper.map(entity, AdministrativeAddressDto.class);
    }

    @Override
    public AdministrativeAddressEo toEntity(AdministrativeAddressDto dto) {
        return modelMapper.map(dto, AdministrativeAddressEo.class);
    }

    @Override
    public Collection<AdministrativeAddressEo> toEntityCollection(Collection<AdministrativeAddressDto> dtoCollection) {
        return List.of(modelMapper.map(dtoCollection, AdministrativeAddressEo.class));
    }

    @Override
    public Collection<AdministrativeAddressDto> toDtoCollection(Collection<AdministrativeAddressEo> entityCollection) {
        return List.of(modelMapper.map(entityCollection, AdministrativeAddressDto.class));
    }
}
