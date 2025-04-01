package vn.khoapd.kis.shared.dto;

import lombok.Builder;

@Builder
public record ErrorResponseDto(
        String id,
        String code,
        String cause,
        String message,
        Object details
) {
}
