package vn.khoapd.kis.shared.service;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.shared.dto.BaseConditionDto;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;
import vn.khoapd.kis.shared.exception.NotFoundException;
import vn.khoapd.kis.shared.mapper.IBaseMapper;

import java.util.Optional;

@Getter
@EqualsAndHashCode
public abstract class AbstractBaseServiceImpl<
        E extends AbstractBaseEntity,
        D extends BaseConditionDto, ID,
        R extends JpaRepository<E, ID>,
        M extends IBaseMapper<E, D>
        > implements IBaseService<D, ID> {
    @Autowired
    private R repository;
    @Autowired
    private M mapper;

    protected abstract String getEntityName();

    protected abstract void beforeCreate(D dto);

    protected abstract void beforeUpdate(E entity, E newEntity);


    @Override
    public D create(D createDto) {
        beforeCreate(createDto);
        E entity = this.getMapper().toEntity(createDto);
        Optional<E> newEntity = Optional.of(this.getRepository().save(entity));
        return getMapper().toDto(newEntity.get());
    }

    @Override
    public D update(ID id, D updateDto) {
        E dbEntity = this.getRepository().findById(id).orElseThrow(
                () -> new NotFoundException(String.format("%s not found by id: %s", getEntityName(), id))
        );
        E obEntity = this.getMapper().toEntity(updateDto);
        beforeUpdate(dbEntity, obEntity);
        Optional<E> newEntity = Optional.of(this.getRepository().save(obEntity));
        return getMapper().toDto(newEntity.get());
    }

    @Override
    public boolean deleteById(ID id) {
        getRepository().deleteById(id);
        return true;
    }

    @Override
    public D findById(ID id) {
        E dbEntity = this.getRepository().findById(id).orElseThrow(
                () -> new NotFoundException(String.format("%s not found by id: %s", getEntityName(), id))
        );
        return getMapper().toDto(dbEntity);
    }
}
