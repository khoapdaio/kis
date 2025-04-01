package vn.khoapd.kis.taxonomy.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.shared.enums.ECommonErrorCode;
import vn.khoapd.kis.shared.enums.EEntityName;
import vn.khoapd.kis.shared.exception.CustomRuntimeException;
import vn.khoapd.kis.shared.service.AbstractBaseServiceImpl;
import vn.khoapd.kis.taxonomy.dto.AdministrativeAddressDto;
import vn.khoapd.kis.taxonomy.entity.AdministrativeAddressEo;
import vn.khoapd.kis.taxonomy.mapper.IAdministrativeAddressMapper;
import vn.khoapd.kis.taxonomy.repository.IAdministrativeAddressRepository;

@Service
@AllArgsConstructor
public class AdministrativeAddressServiceImpl extends AbstractBaseServiceImpl<
        AdministrativeAddressEo, AdministrativeAddressDto, Long,
        IAdministrativeAddressRepository, IAdministrativeAddressMapper> {

    @Override
    protected String getEntityName() {
        return EEntityName.ADMINISTRATIVE_ADDRESS.getName();
    }

    @Override
    protected void beforeCreate(AdministrativeAddressDto dto) {
        if (getRepository().existsByName(dto.getName())) {
            throw new CustomRuntimeException(ECommonErrorCode.ADMINISTRATIVE_NAME_DUPLICATED);
        }

        if (dto.getIdParent() != null && getRepository().existsById(dto.getIdParent())) {
            throw new CustomRuntimeException(ECommonErrorCode.ADMINISTRATIVE_ID_PARENT_NOT_FOUND);
        }
    }

    @Override
    protected void beforeUpdate(AdministrativeAddressEo entity, AdministrativeAddressEo newEntity) {
        if (!entity.getName().equals(newEntity.getName()) && getRepository().existsByName(newEntity.getName())) {
            throw new CustomRuntimeException(ECommonErrorCode.ADMINISTRATIVE_NAME_DUPLICATED);
        }

        if (newEntity.getIdParent() != null && getRepository().existsById(newEntity.getIdParent())) {
            throw new CustomRuntimeException(ECommonErrorCode.ADMINISTRATIVE_ID_PARENT_NOT_FOUND);
        }
    }
}
