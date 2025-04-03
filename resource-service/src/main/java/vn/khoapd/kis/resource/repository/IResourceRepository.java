package vn.khoapd.kis.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.khoapd.kis.resource.entity.ResourceEo;
import vn.khoapd.kis.shared.enums.EEntityStatus;

import java.time.LocalDateTime;

public interface IResourceRepository extends JpaRepository<ResourceEo, Long> {

    @Modifying
    @Query("update resources r " +
            "set r.deletedBy=:deletedBy," +
            "r.deletedAt= :deletedAt, " +
            "r.isDeleted= :isDeleted, " +
            "r.status= :status " +
            "where  r.id=:id ")
    void softDelete(@Param("id") Long id, @Param("deleteBy") String deleteBy, @Param("deleteAt") LocalDateTime deleteAt,
                    @Param("deleted") boolean deleted, @Param("status") EEntityStatus status);

    void updateNameById(Long id, String name);

}
