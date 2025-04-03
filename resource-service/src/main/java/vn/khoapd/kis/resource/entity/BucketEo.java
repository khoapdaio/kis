package vn.khoapd.kis.resource.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "buckets")
public class BucketEo extends AbstractBaseEntity {

    @Column(columnDefinition = "name", nullable = false, updatable = false)
    private String name;
    @Column(columnDefinition = "description")
    private String description;
    @Column(columnDefinition = "display_name", nullable = false)
    private String displayName;
    @OneToMany
    private List<ResourceEo> resources;
}
