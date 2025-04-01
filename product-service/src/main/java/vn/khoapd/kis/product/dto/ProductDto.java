package vn.khoapd.kis.product.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.hibernate.validator.constraints.Length;
import vn.khoapd.kis.product.entity.ProductEo;
import vn.khoapd.kis.shared.dto.BaseConditionDto;

import java.io.Serializable;

/**
 * DTO for {@link ProductEo}
 */
@EqualsAndHashCode(callSuper = true)
@Value
public class ProductDto extends BaseConditionDto implements Serializable {
    @NotBlank
    @Length(min = 10, max = 255)
    String name;
    @NotBlank
    @Length(max = 1000)
    String description;
    @NotNull
    @Digits(integer = 10, fraction = 1)
    Double price;
    @NotBlank
    String image_url;
    @NotNull
    Integer idCategory;

    String nameCategory;
    @NotBlank
    @Length(max = 1000)
    String detail;
    int reviewCount;
    int quantity_sold;
}