package vn.khoapd.kis.resource.dto;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

@Builder
public record ResourceUploadDto(
        MultipartFile file,
        String bucketName
) {
}
