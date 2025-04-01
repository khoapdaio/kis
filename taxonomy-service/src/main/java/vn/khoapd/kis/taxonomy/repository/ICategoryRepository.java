package vn.khoapd.kis.taxonomy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.khoapd.kis.taxonomy.entity.CategoryEo;
@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEo, Long> {

    boolean existsByName(String name);

    boolean existsById(Long id);

    Page<CategoryEo> findByNameContaining(String name, Pageable pageable);


}
