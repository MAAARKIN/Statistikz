package br.com.nobody.statistikz.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Marquinhos on 07/09/15.
 */
@ParseClassName("Conta")
public class Conta extends ParseObject implements Serializable {

    public void setDescricao(String descricao) {
        put("descricao", descricao);
    }

    public String getDescricao() {
        return getString("descricao");
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        put("saldoInicial", saldoInicial.doubleValue());
    }

    public BigDecimal getSaldoInicial() {
        return new BigDecimal(getDouble("saldoInicial"));
    }
}
