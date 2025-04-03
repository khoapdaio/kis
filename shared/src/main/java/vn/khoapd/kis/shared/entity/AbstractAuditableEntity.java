package vn.khoapd.kis.shared.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import vn.khoapd.kis.shared.enums.EEntityStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditableEntity implements Serializable {

    @ColumnDefault(value = "1")
    @Column(columnDefinition = "status", nullable = false, length = 1)
    @Min(0)
    @Max(4)
    private EEntityStatus status;

    @CreatedDate
    @Column(columnDefinition = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedBy
    @Column(columnDefinition = "created_by", updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(columnDefinition = "updated_by")
    private String updatedBy;

    @Column(columnDefinition = "deleted", nullable = false)
    private Boolean isDeleted = false;

    @Column(columnDefinition = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(columnDefinition = "deleted_by")
    private String deletedBy;

} 