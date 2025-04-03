package vn.khoapd.kis.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.khoapd.kis.resource.entity.BucketEo;

public interface IBucketRepository extends JpaRepository<BucketEo, Long> {
    void updateDisplayNameById(Long id, String name);
}
