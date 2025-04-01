package vn.khoapd.kis.taxonomy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.shared.enums.ECommonErrorCode;
import vn.khoapd.kis.shared.enums.EEntityName;
import vn.khoapd.kis.shared.exception.CustomRuntimeException;
import vn.khoapd.kis.shared.service.AbstractBaseServiceImpl;
import vn.khoapd.kis.taxonomy.dto.CategoryDto;
import vn.khoapd.kis.taxonomy.entity.CategoryEo;
import vn.khoapd.kis.taxonomy.mapper.ICategoryMapper;
import vn.khoapd.kis.taxonomy.repository.ICategoryRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl extends AbstractBaseServiceImpl<
        CategoryEo, CategoryDto, Long, ICategoryRepository, ICategoryMapper> {


    @Override
    protected String getEntityName() {
        return EEntityName.CATEGORY.getName();
    }

    @Override
    protected void beforeCreate(CategoryDto dto) {
        if (getRepository().existsByName(dto.getName())) {
            throw new CustomRuntimeException(ECommonErrorCode.CATEGORY_NAME_DUPLICATED);
        }
        if (dto.getParentId() != null && !getRepository().existsById(dto.getParentId())) {
            throw new CustomRuntimeException(ECommonErrorCode.CATEGORY_ID_PARENT_NOT_FOUND);
        }
    }

    @Override
    protected void beforeUpdate(CategoryEo entity, CategoryEo newEntity) {
        if (entity.getName().equals(newEntity.getName()) && getRepository().existsByName(newEntity.getName())) {
            throw new CustomRuntimeException(ECommonErrorCode.CATEGORY_NAME_DUPLICATED);
        }
        if (newEntity.getParentId() != null && !getRepository().existsById(newEntity.getParentId())) {
            throw new CustomRuntimeException(ECommonErrorCode.CATEGORY_ID_PARENT_NOT_FOUND);
        }
    }
}
