package vn.khoapd.kis.resource.service;

import org.springframework.web.multipart.MultipartFile;
import vn.khoapd.kis.resource.dto.ResourceDto;

public interface IResourceService {
    String upload(MultipartFile file, String bucketName);

    ResourceDto getFile(Long id);

    boolean deleteFile(Long id);

    boolean rename(Long id, String newName);
}
