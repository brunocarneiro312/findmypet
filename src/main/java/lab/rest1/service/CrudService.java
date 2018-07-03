package lab.rest1.service;

import java.util.List;

public interface CrudService<T> {

    void save(T t);

    void delete(T t);

    List<T> list();

    T find(T t);

    T findById(Long id);

}
