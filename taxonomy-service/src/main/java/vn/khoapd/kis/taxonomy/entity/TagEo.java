package vn.khoapd.kis.taxonomy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;

@Getter
@Setter
@Entity(name = "tags")
@NoArgsConstructor
@AllArgsConstructor
public class TagEo extends AbstractBaseEntity {

    @Column(nullable = false, length = 50, unique = true)
    private String name;

    private String description;
}
