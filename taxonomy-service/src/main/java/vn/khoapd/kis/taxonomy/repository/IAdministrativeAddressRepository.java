package vn.khoapd.kis.taxonomy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.khoapd.kis.taxonomy.entity.AdministrativeAddressEo;
@Repository
public interface IAdministrativeAddressRepository extends JpaRepository<AdministrativeAddressEo, Long> {

    boolean existsByName(String name);
    boolean existsById(Long id);

}
