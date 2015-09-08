package br.com.nobody.statistikz.dao;

import android.util.Log;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import br.com.nobody.statistikz.app.App;
import br.com.nobody.statistikz.model.Despesa;
import br.com.nobody.statistikz.repository.DespesaRepository;

/**
 * Created by Marquinhos.
 */
public class DespesaDAO implements DespesaRepository {

    private Despesa currentDespesa;

    public DespesaDAO() {

    }

    @Override
    public void save(Despesa entity) {
        entity.saveEventually();
    }

    @Override
    public void update(Despesa entity) {
        // Retrieve the object by id
        Despesa despesa = findById(entity.getObjectId());
        despesa.setDescricao(entity.getDescricao());
        despesa.setValor(entity.getValor());
        despesa.setDataCadastro(entity.getDataCadastro());
        despesa.saveInBackground();
    }

    @Override
    public void delete(Despesa entity) {
        entity.deleteEventually();
    }

    @Override
    public Despesa findById(String objectId) {
        Despesa obj = null;
        ParseQuery<Despesa> query = getQuery();
        query.whereEqualTo("objectId", objectId);
        try {
            obj = query.getFirst();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public List<Despesa> listAll() {
        List<Despesa> despesas = new ArrayList<>();
        ParseQuery<Despesa> query = getQuery();
        try {
            despesas = query.find();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return despesas;
    }

    @Override
    public ParseQuery<Despesa> getQuery() {
        return ParseQuery.getQuery(Despesa.class);
    }
}
