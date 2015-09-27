package br.com.nobody.statistikz.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.List;

import br.com.nobody.statistikz.dao.DespesaDAO;
import br.com.nobody.statistikz.model.Despesa;
import br.com.nobody.statistikz.repository.DespesaRepository;

/**
 * Created by Marquinhos on 07/09/15.
 */
public class DespesaListFragment extends ListFragment {

    public static final String TAG_LIST_DESPESA = "tagListDespesa";

    private List<Despesa> mDespesas;
    private ArrayAdapter<Despesa> mAdapter;
    private DespesaRepository repository;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        repository = new DespesaDAO();

        mDespesas = repository.listAll();

        mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mDespesas);

        getActivity().setTitle("Lista de Despesas");
        setListAdapter(mAdapter);
    }

    public static DespesaListFragment newInstance() {
        DespesaListFragment fragment = new DespesaListFragment();
        //i won't pass parameters now.
//        Bundle params = new Bundle();
//        params.putSerializable(Extra.DESPESA, despesa);
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    public DespesaListFragment() {
    }
}
