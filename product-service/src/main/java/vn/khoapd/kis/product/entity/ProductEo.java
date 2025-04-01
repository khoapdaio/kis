package vn.khoapd.kis.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class ProductEo extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", length = 500)
    private String description;
    @Column(name = "price", nullable = false, length = 50)
    private Double price;
    @Column(name = "image_url")
    private String image_url;
    @Column(name = "id_category", nullable = false)
    private Integer idCategory;
    @Column(name = "name_category", nullable = false)
    private String nameCategory;
    @Column(name = "detail", nullable = false, length = 1000)
    private String detail;
    @Column(name = "review_count")
    private int reviewCount;
    @Column(name = "quantity_sold")
    private int quantity_sold;
}
