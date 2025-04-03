package vn.khoapd.kis.resource.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khoapd.kis.resource.dto.BucketDto;
import vn.khoapd.kis.resource.entity.BucketEo;
import vn.khoapd.kis.resource.mapper.IBucketMapper;
import vn.khoapd.kis.resource.repository.IBucketRepository;
import vn.khoapd.kis.resource.service.impl.BucketServiceImpl;
import vn.khoapd.kis.shared.controller.AbstractBaseController;
import vn.khoapd.kis.shared.dto.ApiResponseDto;
import vn.khoapd.kis.shared.dto.ResponseBuilder;
import vn.khoapd.kis.shared.enums.EEntityName;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/bucket")
public class BucketController extends AbstractBaseController<BucketEo, BucketDto, Long, IBucketRepository, IBucketMapper, BucketServiceImpl> {


    @Override
    protected String getEntityName() {
        return EEntityName.BUCKET.getName();
    }

    @PutMapping("/update-name/{id}")
    public ResponseEntity<ApiResponseDto<Boolean>> updateBuketName(@PathVariable Long id, @RequestBody String newName) {
        return ResponseBuilder.success(getService().updateBucketName(id, newName));
    }
}
