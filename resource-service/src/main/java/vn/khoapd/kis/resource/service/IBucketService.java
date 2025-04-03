package vn.khoapd.kis.resource.service;

import vn.khoapd.kis.resource.dto.BucketDto;
import vn.khoapd.kis.shared.service.IBaseService;

public interface IBucketService extends IBaseService<BucketDto, Long> {


    boolean updateBucketName(Long bucketId, String bucketName);
}
