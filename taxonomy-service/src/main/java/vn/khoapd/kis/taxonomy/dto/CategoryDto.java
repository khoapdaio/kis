package vn.khoapd.kis.taxonomy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import vn.khoapd.kis.shared.dto.BaseConditionDto;

@Getter
@Setter
@Schema(name = "Category",title = "Danh mục" )
public class CategoryDto extends BaseConditionDto {

    @NotEmpty
    @Size(max=255)
    @Schema(name = "name",description = "Tên danh mục", maxLength = 255,type = "String", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
    @Schema(name = "parentId",description = "Id danh mục cha")
    private Long parentId;
    @Size(max=1000)
    @Schema(name="description",description = "Mô tả danh mục",maxLength = 1000)
    private String description;
}
