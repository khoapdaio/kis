package vn.khoapd.kis.shared.mapper;

import vn.khoapd.kis.shared.dto.BaseConditionDto;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;

import java.util.Collection;

public interface IBaseModelMapper<E extends AbstractBaseEntity, D extends BaseConditionDto> {

    E toEntity(D dto, Class<E> clazz);

    D toDto(E entity, Class<D> clazz);

    Collection<E> toEntityCollection(Collection<D> dtos, Class<E> clazz);

    Collection<D> toDtoCollection(Collection<E> entities, Class<D> clazz);

}
