package vn.khoapd.kis.resource.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import vn.khoapd.kis.shared.entity.AbstractBaseEntity;
import vn.khoapd.kis.shared.enums.EResourceType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "resources")
public class ResourceEo extends AbstractBaseEntity {
    @Column(columnDefinition = "name", nullable = false, unique = true, length = 64)
    private String name;
    @Column(columnDefinition = "name_display", nullable = false, length = 64)
    private String nameDisplay;
    @Column(columnDefinition = "type", nullable = false)
    private EResourceType type;
    @Column(columnDefinition = "size", nullable = false)
    private Long size;
    @Column(columnDefinition = "path", nullable = false)
    private String path;
    @Column(columnDefinition = "bucket_id", nullable = false)
    private Long bucketId;
    @Column(columnDefinition = "meta_data")
    private String metaData;
}
