package br.com.nobody.statistikz.repository;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by Marquinhos.
 */
public interface Repository<T extends ParseObject> {
    public void save(T entity);
    public void update(T entity);
    public void delete(T entity);
    public T findById(String objectId);
    public List<T> listAll();
    public ParseQuery<T> getQuery();
}
