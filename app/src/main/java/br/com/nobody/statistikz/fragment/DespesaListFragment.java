package br.com.nobody.statistikz.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

import br.com.nobody.statistikz.model.Despesa;

/**
 * Created by Marquinhos on 07/09/15.
 */
public class DespesaListFragment extends ListFragment {

    private List<Despesa> mDespesas;
    private ArrayAdapter<Despesa> mAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ParseQuery<Despesa> query = ParseQuery.getQuery(Despesa.class);
        query.findInBackground(new FindCallback<Despesa>() {
            @Override
            public void done(List<Despesa> results, ParseException e) {
                for (Despesa a : results) {
                    // ...
                }
            }
        });
    }
}
