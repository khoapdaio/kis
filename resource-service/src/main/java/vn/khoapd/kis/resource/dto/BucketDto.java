package vn.khoapd.kis.resource.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import vn.khoapd.kis.shared.dto.BaseConditionDto;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BucketDto extends BaseConditionDto {
    private String name;
    private String description;
    @NotBlank
    private String displayName;
}
