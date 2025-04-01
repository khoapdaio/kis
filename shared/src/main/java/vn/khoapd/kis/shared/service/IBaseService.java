package vn.khoapd.kis.shared.service;

public interface IBaseService<D, ID> {
    D create(D createDto);

    D update(ID id, D updateDto);

    boolean deleteById(ID id);

    D findById(ID id);
}