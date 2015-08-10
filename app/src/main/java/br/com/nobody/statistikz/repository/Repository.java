package br.com.nobody.statistikz.repository;

import java.util.List;

/**
 * Created by Marquinhos.
 */
public interface Repository<T> {
    public void create(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T findById(int id);
    public List<T> listAll();
    public void closeDatabase();
}
