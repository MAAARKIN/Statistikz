package br.com.nobody.statistikz.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Marquinhos on 13/09/15.
 */
public class ColorAdapter extends BaseAdapter {

    private Context context;
    private List<String> cores;

    public ColorAdapter(Context context, List<String> cores) {
        this.context = context;
        this.cores = cores;
//        this.categorias = categorias;
    }

    @Override
    public int getCount() {
        return cores.size();
    }

    @Override
    public String getItem(int position) {
        return cores.get(position);
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
