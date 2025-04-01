package vn.khoapd.kis.taxonomy.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import vn.khoapd.kis.shared.dto.BaseConditionDto;
import vn.khoapd.kis.taxonomy.enums.EAdministrative;

@Getter
@Setter
@Schema(name = "AdministrativeAddress",description = "Địa danh hành chính")
public class AdministrativeAddressDto extends BaseConditionDto {
    @NotEmpty
    @Size(max=10)
    @Schema(name="code",description = "Mã địa danh hành chính", maxLength = 10)
    private String code;

    @Schema(name="level_administrative", description = "Cấp địa danh hành chính")
    private EAdministrative levelAdministrative;
    @NotEmpty
    @Size(max=255)
    @Schema(name = "name",description = "Tên địa danh hành chính",maxLength = 255)
    private String name;
    @NotEmpty
    @Size(max=255)
    @Schema(name= "name_en",description = "Tên tiếng anh địa danh hành chính",maxLength = 255)
    private String nameEn;
    @NotEmpty
    @Size(max=255)
    @Schema(name="full_name", description = "Tên đầy đủ địa danh hành chính", maxLength = 255)
    private String fullName;
    @NotEmpty
    @Size(max=255)
    @Schema(name = "full_name_en", description = "Tên tiếng anh đầy đủ địa danh hành chính", maxLength = 255)
    private String fullNameEn;

    @NotEmpty
    @Size(max=255)
    @Schema(name = "code_name", description = "Mã tên địa danh hành chính", maxLength = 255)
    private String codeName;

    @Schema(name="idParent",description = "Id địa danh hành chính cha")
    private Long idParent;
}
