package vn.khoapd.kis.resource.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.khoapd.kis.resource.dto.ResourceDto;
import vn.khoapd.kis.resource.dto.ResourceUploadDto;
import vn.khoapd.kis.resource.service.IResourceService;
import vn.khoapd.kis.shared.dto.ApiResponseDto;
import vn.khoapd.kis.shared.dto.ResponseBuilder;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/resource/")
public class ResourceController {

    private final IResourceService resourceService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getResource(@PathVariable Long id) {

        ResourceDto resourceDto = resourceService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resourceDto.fileName() + "\"")
                .body(resourceDto.data());

    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ApiResponseDto<String>> uploadFile(@ModelAttribute ResourceUploadDto dto) {
        return ResponseBuilder.success(resourceService.upload(dto.file(), dto.bucketName()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Boolean>> deleteFile(@PathVariable Long id) {
        resourceService.deleteFile(id);
        return ResponseBuilder.success(resourceService.deleteFile(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ApiResponseDto<Boolean>> renameFile(@PathVariable Long id, String newName) {
        return ResponseBuilder.success(resourceService.rename(id, newName));
    }
}
