package vn.khoapd.kis.taxonomy.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import vn.khoapd.kis.shared.dto.BaseConditionDto;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TagDto extends BaseConditionDto {
    @NotBlank
    @Length(max = 50)
    private String name;

    @Length(max = 255)
    private String description;
}
