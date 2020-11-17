package cesi.fr.dao;

import java.util.List;

public interface DAO<T> {

    List<T> getAll();
    void update(T t);
    void delete(int t);
    T insert(T t);
}
