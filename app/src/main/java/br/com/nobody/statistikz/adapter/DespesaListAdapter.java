package br.com.nobody.statistikz.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import br.com.nobody.statistikz.model.Despesa;

/**
 * Created by Marquinhos on 07/09/15.
 */
public class DespesaListAdapter extends BaseAdapter {

    private Context context;
    private List<Despesa> despesas;

    public DespesaListAdapter(Context context, List<Despesa> despesas) {
        this.context = context;
        this.despesas = despesas;
    }

    @Override
    public int getCount() {
        return despesas.size();
    }

    @Override
    public Object getItem(int position) {
        if(despesas != null) {
            return despesas.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
