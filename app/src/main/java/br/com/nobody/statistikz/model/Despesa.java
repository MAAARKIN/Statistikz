package br.com.nobody.statistikz.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.math.BigDecimal;

/**
 * Created by Marquinhos.
 */
@ParseClassName("Despesa")
public class Despesa extends ParseObject {

    private String descricao;
    private BigDecimal valor;

    public Despesa() {

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
