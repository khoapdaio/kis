package vn.khoapd.kis.taxonomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.khoapd.kis.taxonomy.entity.TagEo;

public interface ITagRepository extends JpaRepository<TagEo, Long> {
    boolean existsByName(String name);
}
