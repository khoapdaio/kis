package vn.khoapd.kis.taxonomy.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Entity(name = "categories")
public class CategoryEo extends AbstractBaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "description", nullable = false, length = 1000)
    private String description;
    @Column(name = "parent_id")
    private Long parentId;

}
