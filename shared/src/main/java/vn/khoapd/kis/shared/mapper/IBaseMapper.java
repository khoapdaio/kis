package vn.khoapd.kis.shared.mapper;

import vn.khoapd.kis.shared.dto.BaseConditionDto;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;

import java.util.Collection;

public interface IBaseMapper<E extends AbstractBaseEntity, D extends BaseConditionDto> {
    D toDto(E entity);

    E toEntity(D dto);

    Collection<E> toEntityCollection(Collection<D> dtoCollection);

    Collection<D> toDtoCollection(Collection<E> entityCollection);

}
