package vn.khoapd.kis.shared.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.khoapd.kis.shared.dto.ApiResponseDto;
import vn.khoapd.kis.shared.dto.BaseConditionDto;
import vn.khoapd.kis.shared.dto.ResponseBuilder;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;
import vn.khoapd.kis.shared.mapper.IBaseMapper;
import vn.khoapd.kis.shared.service.AbstractBaseServiceImpl;

@Slf4j
@Validated
@Scope(
        value = "request",
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
@Getter
public abstract class AbstractBaseController<
        E extends AbstractBaseEntity,
        D extends BaseConditionDto, ID,
        R extends JpaRepository<E, ID>,
        M extends IBaseMapper<E, D>,
        S extends AbstractBaseServiceImpl<E, D, ID, R, M>
        > implements IBaseController<D, ID> {
    @Autowired
    private S service;


    protected abstract String getEntityName();

    @PostMapping
    @Override
    public ResponseEntity<ApiResponseDto<D>> create(@RequestBody @Valid D dto) {
        log.debug("REST request to save {}: {}", getEntityName(), dto);
        return ResponseBuilder.created(getService().create(dto));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ApiResponseDto<D>> findById(@PathVariable ID id) {
        log.debug("REST request to get {} by id: {}", getEntityName(), id);
        return ResponseBuilder.success(getService().findById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ApiResponseDto<D>> update(@PathVariable ID id, @RequestBody D dto) {
        log.debug("REST request to update {} with id: {}", getEntityName(), id);
        return ResponseBuilder.success(getService().update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ApiResponseDto<Boolean>> delete(@PathVariable ID id) {
        log.debug("REST request to delete {} with id: {}", getEntityName(), id);
        return ResponseBuilder.success(getService().deleteById(id));
    }
}
