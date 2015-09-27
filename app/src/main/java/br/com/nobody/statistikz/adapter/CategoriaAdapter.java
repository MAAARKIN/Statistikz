package br.com.nobody.statistikz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.nobody.statistikz.R;
import br.com.nobody.statistikz.model.Categoria;

/**
 * Created by Marquinhos on 13/09/15.
 */
public class CategoriaAdapter<T extends Categoria> extends BaseAdapter {

    private Context context;
    private List<Categoria> categorias;

    public CategoriaAdapter(Context context, List<Categoria> categorias) {
        this.context = context;
        this.categorias = categorias;
    }

    @Override
    public int getCount() {
        if(categorias != null) {
            return categorias.size();
        }
        return 0;
    }

    @Override
    public Categoria getItem(int position) {
        if(categorias != null) {
            return categorias.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //1 passo, pegar a categoria
        Categoria categoria = categorias.get(position);

        //2 passo
        View linha = LayoutInflater.from(context).inflate(R.layout.item_categoria, null);

        //3 passo
        TextView descricao = (TextView) linha.findViewById(R.id.txtItemDescDespesa);

        //4 passo
        descricao.setText(categoria.getDescricao());

        return linha;
    }
}
