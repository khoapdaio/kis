package vn.khoapd.kis.resource.service;

import io.minio.Result;
import io.minio.messages.Bucket;
import io.minio.messages.Item;

import java.io.InputStream;
import java.util.List;

/**
 * Interface for MinIO operations.
 * Provides methods for common object storage operations.
 */
public interface IMinioService {
    //Bucket method
    List<Bucket> getListBuckets();

    List<String> getListBucketNames();

    boolean isBucketExist(String bucketName);

    boolean deleteBucket(String bucketName);

    boolean createBucket(String bucketName);


    //file method
    Iterable<Result<Item>> getListObjects(String bucketName);

    InputStream downloadFile(String objectName, String bucketName);

    String uploadFile(String objectName, String bucketName, InputStream stream, String contentType);

    boolean deleteFile(String objectName, String bucketName);

    boolean isObjectExist(String objectName, String bucketName);

    String getObjectUrl(String objectName, String buketName);
}