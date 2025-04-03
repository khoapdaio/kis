package vn.khoapd.kis.resource.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.resource.dto.BucketDto;
import vn.khoapd.kis.resource.entity.BucketEo;
import vn.khoapd.kis.resource.mapper.IBucketMapper;
import vn.khoapd.kis.resource.repository.IBucketRepository;
import vn.khoapd.kis.resource.service.IBucketService;
import vn.khoapd.kis.resource.service.IMinioService;
import vn.khoapd.kis.shared.enums.EEntityName;
import vn.khoapd.kis.shared.service.AbstractBaseServiceImpl;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BucketServiceImpl extends AbstractBaseServiceImpl
        <BucketEo, BucketDto, Long, IBucketRepository, IBucketMapper> implements IBucketService {
    private final IMinioService minioService;


    @Override
    protected String getEntityName() {
        return EEntityName.BUCKET.name();
    }

    @Override
    protected void beforeCreate(BucketDto dto) {
        UUID uuid = UUID.randomUUID();
        minioService.createBucket(uuid.toString());
        dto.setName(uuid.toString());
    }

    @Override
    protected void beforeUpdate(BucketEo entity, BucketEo newEntity) {

    }

    public boolean updateBucketName(Long id, String name) {
        this.getRepository().updateDisplayNameById(id, name);
        return true;
    }
}
