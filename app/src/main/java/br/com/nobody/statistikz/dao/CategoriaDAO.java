package br.com.nobody.statistikz.dao;

import br.com.nobody.statistikz.model.Categoria;
import br.com.nobody.statistikz.repository.CategoriaRepository;

/**
 * Created by Marquinhos on 27/09/15.
 */
public class CategoriaDAO extends GenericDAO<Categoria> implements CategoriaRepository {

    public CategoriaDAO() {
        super(Categoria.class);
    }
}
