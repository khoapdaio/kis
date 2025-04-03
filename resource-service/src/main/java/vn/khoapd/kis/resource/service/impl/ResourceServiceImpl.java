package vn.khoapd.kis.resource.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.khoapd.kis.resource.dto.ResourceDto;
import vn.khoapd.kis.resource.entity.ResourceEo;
import vn.khoapd.kis.resource.repository.IResourceRepository;
import vn.khoapd.kis.resource.service.IMinioService;
import vn.khoapd.kis.resource.service.IResourceService;
import vn.khoapd.kis.shared.enums.ECommonErrorCode;
import vn.khoapd.kis.shared.enums.EEntityStatus;
import vn.khoapd.kis.shared.enums.EResourceType;
import vn.khoapd.kis.shared.exception.CustomRuntimeException;
import vn.khoapd.kis.shared.util.KhoapdCustomUtil;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements IResourceService {
    private final IResourceRepository repository;
    private final IMinioService minioService;


    @Override
    @SneakyThrows
    public String upload(MultipartFile file, String bucketName) {

        UUID uuid = UUID.randomUUID();
        String path = minioService.uploadFile(uuid.toString(), bucketName, file.getInputStream(), file.getContentType());

        ResourceEo resourceEo = ResourceEo.builder()
                .name(uuid.toString())
                .nameDisplay(file.getOriginalFilename())
                .size(file.getSize())
                .path(path)
                .type(EResourceType.getByName(KhoapdCustomUtil.getFileExtension(file)))
                .build();

        resourceEo = repository.save(resourceEo);

        return resourceEo.getPath();
    }

    @Override
    @SneakyThrows
    public ResourceDto getFile(Long id) {
        ResourceEo resourceEo = repository.findById(id).orElseThrow(
                () -> new CustomRuntimeException(ECommonErrorCode.RESOURCE_ID_NOT_FOUND)
        );

        return ResourceDto.builder()
                .data(minioService.downloadFile(resourceEo.getName(), resourceEo.getPath()).readAllBytes())
                .fileName(resourceEo.getNameDisplay())
                .type(resourceEo.getType().name())
                .build();
    }

    @Override
    @SneakyThrows
    public boolean deleteFile(Long id) {
        if (repository.existsById(id)) {
            throw new CustomRuntimeException(ECommonErrorCode.RESOURCE_ID_NOT_FOUND);
        }
        repository.softDelete(id, "khoapd", LocalDateTime.now(), true, EEntityStatus.DELETED);
        return true;
    }

    @Override
    @SneakyThrows
    public boolean rename(Long id, String newName) {
        repository.updateNameById(id, newName);
        return true;
    }
}
