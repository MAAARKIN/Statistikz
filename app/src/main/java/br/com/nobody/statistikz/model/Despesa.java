package br.com.nobody.statistikz.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Marquinhos.
 */
@ParseClassName("Despesa")
public class Despesa extends ParseObject implements Serializable {

    private BigDecimal valor;

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
}
