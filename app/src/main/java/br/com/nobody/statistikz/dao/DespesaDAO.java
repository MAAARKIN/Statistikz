package br.com.nobody.statistikz.dao;

import br.com.nobody.statistikz.model.Despesa;
import br.com.nobody.statistikz.repository.DespesaRepository;

/**
 * Created by Marquinhos.
 */
public class DespesaDAO extends GenericDAO<Despesa> implements DespesaRepository {

    public DespesaDAO() {
        super(Despesa.class);
    }
}
