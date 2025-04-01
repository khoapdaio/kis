package vn.khoapd.kis.product.dto;

import lombok.Builder;

@Builder
public record CategoryDto(
        Long id,
        String name,
        String description,
        Long parentId
) {

}
