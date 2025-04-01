package vn.khoapd.kis.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBaseRepository<T, ID> extends JpaRepository<T, ID> {

    boolean create(T entity);

    boolean update(T entity);


}
