package br.com.nobody.statistikz.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Marquinhos.
 */
@ParseClassName("Despesa")
public class Despesa extends ParseObject implements Serializable {

    public Despesa() {

    }

    public String getDescricao() {
        return getString("descricao");
    }

    public void setDescricao(String descricao) {
        this.put("descricao", descricao);
    }

    public BigDecimal getValor() {
        return new BigDecimal(getDouble("valor"));
    }

    public void setValor(BigDecimal valor) {
        this.put("valor", valor.doubleValue());
    }

    public void setDataCadastro(Date dataCadastro) {
        this.put("dataCadastro", dataCadastro);
    }

    public Date getDataCadastro() {
        return getDate("dataCadastro");
    }

    public void setCategoria(Categoria categoria) {
        put("categoria", categoria);
    }

    public Categoria getCategoria() {
        return (Categoria) get("categoria");
    }

    @Override
    public String toString() {
        return getDescricao();
    }
}
