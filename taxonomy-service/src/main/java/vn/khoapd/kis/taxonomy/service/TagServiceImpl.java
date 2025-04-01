package vn.khoapd.kis.taxonomy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.shared.enums.ECommonErrorCode;
import vn.khoapd.kis.shared.enums.EEntityName;
import vn.khoapd.kis.shared.exception.CustomRuntimeException;
import vn.khoapd.kis.shared.service.AbstractBaseServiceImpl;
import vn.khoapd.kis.shared.service.IBaseService;
import vn.khoapd.kis.taxonomy.dto.TagDto;
import vn.khoapd.kis.taxonomy.entity.TagEo;
import vn.khoapd.kis.taxonomy.mapper.ITagMapper;
import vn.khoapd.kis.taxonomy.repository.ITagRepository;

@Service
@RequiredArgsConstructor
public class TagServiceImpl extends AbstractBaseServiceImpl<TagEo, TagDto, Long, ITagRepository, ITagMapper> implements IBaseService<TagDto, Long> {


    @Override
    protected String getEntityName() {
        return EEntityName.TAG.getName();
    }

    @Override
    protected void beforeCreate(TagDto dto) {
        if (getRepository().existsByName(dto.getName())) {
            throw new CustomRuntimeException(ECommonErrorCode.TAG_NAME_DUPLICATED);
        }
    }

    @Override
    protected void beforeUpdate(TagEo entity, TagEo newEntity) {
        if (!entity.getName().equals(newEntity.getName()) && getRepository().existsByName(newEntity.getName())) {
            throw new CustomRuntimeException(ECommonErrorCode.TAG_NAME_DUPLICATED);
        }
    }
}
