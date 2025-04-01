package vn.khoapd.kis.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.khoapd.kis.product.entity.ProductEo;

public interface IProductRepository extends JpaRepository<ProductEo, Long> {


}
