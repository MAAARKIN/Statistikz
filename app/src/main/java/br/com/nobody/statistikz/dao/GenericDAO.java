package br.com.nobody.statistikz.dao;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import br.com.nobody.statistikz.repository.Repository;

/**
 * Created by Marquinhos on 07/09/15.
 */
public abstract class GenericDAO<T extends ParseObject> implements Repository<T> {

    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(T entity) {
        entity.saveEventually();
    }

    @Override
    public void update(T entity) {
        T objFromParse = findById(entity.getObjectId());
        populateEntity(objFromParse, entity);
        objFromParse.saveInBackground();
    }

    private void populateEntity(T objFromParse, T entity) {
        for(String key : entity.keySet()) {
            objFromParse.put(key, entity.get(key));
        }
    }

    @Override
    public void delete(T entity) {
        entity.deleteEventually();
    }

    @Override
    public T findById(String objectId) {
        T obj = null;
        ParseQuery<T> query = getQuery();
        query.whereEqualTo("objectId", objectId);
        try {
            obj = query.getFirst();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public List<T> listAll() {
        List<T> list = new ArrayList<>();
        ParseQuery<T> query = getQuery();
        try {
            list = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ParseQuery<T> getQuery() {
        return ParseQuery.getQuery(entityClass);
    }
}
