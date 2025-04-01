package vn.khoapd.kis.shared.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khoapd.kis.shared.dto.ApiResponseDto;

public interface IBaseController<D, ID> {

    ResponseEntity<ApiResponseDto<D>> create(D dto);

    ResponseEntity<ApiResponseDto<D>> update(ID id,  D dto);

    ResponseEntity<ApiResponseDto<Boolean>> delete( ID id);

    ResponseEntity<ApiResponseDto<D>> findById( ID id);
}
