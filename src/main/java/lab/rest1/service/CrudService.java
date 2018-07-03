package lab.rest1.service;

import java.util.List;

/**
 * ===================================================
 * Interface que definem métodos CRUD para os serviços
 * ===================================================
 * @author bruno.carneiro
 * @param <T>
 */
public interface CrudService<T> {

    /** Persiste */
    void save(T t);

    /** Remove */
    void delete(T t);

    /** Lista */
    List<T> list();

    /** Busca */
    T find(T t);

    /** Busca pelo ID */
    T findById(Long id);

}
