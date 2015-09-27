package br.com.nobody.statistikz.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.io.Serializable;

/**
 * Created by Marquinhos on 13/09/15.
 */
@ParseClassName("Categoria")
public class Categoria extends ParseObject implements Serializable {

    public void setDescricao(String descricao) {
        put("descricao", descricao);
    }

    public String getDescricao() {
        return getString("descricao");
    }

    public void setCor(int cor) {
        put("cor", cor);
    }

    public int getCor() {
        return getInt("cor");
    }
}
