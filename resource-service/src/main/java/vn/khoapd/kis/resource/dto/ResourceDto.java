package vn.khoapd.kis.resource.dto;

import lombok.Builder;

@Builder
public record ResourceDto(
        byte[] data,
        String fileName,
        String type
) {
}
