package vn.khoapd.kis.resource.service.impl;

import io.minio.*;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.khoapd.kis.resource.config.MinioConfig;
import vn.khoapd.kis.resource.service.IMinioService;
import vn.khoapd.kis.shared.enums.ECommonErrorCode;
import vn.khoapd.kis.shared.exception.CustomRuntimeException;
import vn.khoapd.kis.shared.util.KhoapdCustomUtil;

import java.io.InputStream;
import java.util.List;

/**
 * Implementation of MinioService interface.
 * Provides methods for interacting with MinIO object storage.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class MinioServiceImpl implements IMinioService {


    private final MinioClient minioClient;
    private final MinioConfig minioConfig;

    @SneakyThrows
    @Override
    public List<Bucket> getListBuckets() {
        return minioClient.listBuckets();
    }

    @SneakyThrows
    @Override
    public List<String> getListBucketNames() {
        return getListBuckets().stream().map(Bucket::name).toList();
    }

    @SneakyThrows
    @Override
    public boolean isBucketExist(String bucketName) {
        KhoapdCustomUtil.validateValueString(bucketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);
        return minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    }

    @SneakyThrows
    @Override
    public boolean deleteBucket(String bucketName) {
        KhoapdCustomUtil.validateValueString(bucketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);
        if (isBucketExist(bucketName)) {
            Iterable<Result<Item>> objects = getListObjects(bucketName);
            for (Result<Item> object : objects) {
                Item item = object.get();
                if (item.size() > 0) {
                    throw new CustomRuntimeException(ECommonErrorCode.OBJECT_SIZE_MUST_ZERO);
                }
            }
            minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
            return isBucketExist(bucketName);
        }
        return false;
    }

    @SneakyThrows
    @Override
    public boolean createBucket(String bucketName) {
        KhoapdCustomUtil.validateValueString(bucketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);
        if (isBucketExist(bucketName)) {
            throw new CustomRuntimeException(ECommonErrorCode.BUCKET_NAME_DUPLICATED);
        }
        minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        return isBucketExist(bucketName);
    }

    @Override
    public Iterable<Result<Item>> getListObjects(String bucketName) {
        KhoapdCustomUtil.validateValueString(bucketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);
        return minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
    }

    @SneakyThrows
    @Override
    public InputStream downloadFile(String objectName, String bucketName) {
        KhoapdCustomUtil.validateValueString(objectName, ECommonErrorCode.OBJECT_NAME_NOT_VALID);
        KhoapdCustomUtil.validateValueString(bucketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);
        return minioClient.getObject(GetObjectArgs.builder().object(objectName).bucket(bucketName).build());
    }

    @SneakyThrows
    @Override
    public String uploadFile(String objectName, String bucketName, InputStream stream, String contentType) {
        KhoapdCustomUtil.validateValueString(objectName, ECommonErrorCode.OBJECT_NAME_NOT_VALID);
        KhoapdCustomUtil.validateValueString(bucketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);

        minioClient.putObject(PutObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .contentType(contentType)
                .stream(stream, -1, 10485760)
                .build());
        return this.getObjectUrl(objectName, bucketName);
    }

    @SneakyThrows
    @Override
    public boolean deleteFile(String objectName, String bucketName) {
        KhoapdCustomUtil.validateValueString(objectName, ECommonErrorCode.OBJECT_NAME_NOT_VALID);
        KhoapdCustomUtil.validateValueString(bucketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
        return !isObjectExist(objectName, bucketName);
    }

    @SneakyThrows
    @Override
    public boolean isObjectExist(String objectName, String bucketName) {
        KhoapdCustomUtil.validateValueString(objectName, ECommonErrorCode.OBJECT_NAME_NOT_VALID);
        KhoapdCustomUtil.validateValueString(bucketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);
        minioClient.statObject(StatObjectArgs.builder().object(objectName).bucket(bucketName).build());
        return true;
    }

    @Override
    public String getObjectUrl(String objectName, String buketName) {
        KhoapdCustomUtil.validateValueString(objectName, ECommonErrorCode.OBJECT_NAME_NOT_VALID);
        KhoapdCustomUtil.validateValueString(buketName, ECommonErrorCode.BUCKET_NAME_NOT_VALID);
        return String.format("%s/%s/%s", minioConfig.getEndpoint(),
                minioConfig.getBucketName(), objectName);
    }

} 