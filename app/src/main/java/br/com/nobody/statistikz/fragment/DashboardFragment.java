package br.com.nobody.statistikz.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.math.BigDecimal;
import java.util.List;

import br.com.nobody.statistikz.R;
import br.com.nobody.statistikz.activity.DespesaActivity;
import br.com.nobody.statistikz.app.App;
import br.com.nobody.statistikz.dao.DespesaDAO;
import br.com.nobody.statistikz.model.Despesa;
import br.com.nobody.statistikz.repository.DespesaRepository;
import br.com.nobody.statistikz.util.Extra;

/**
 * Created by Marquinhos on 07/09/15.
 */
public class DashboardFragment extends Fragment {

    private DespesaRepository repository;

    public static final String TAG_PRINCIPAL_DASHBOARD = "tagPrincipalDashboard";

    private FloatingActionButton btnNovaDespesa;
    private FloatingActionButton btnNovaReceita;
    private FloatingActionMenu menu;
    private CardView cardViewDespesas;

    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        return fragment;
    }

    public DashboardFragment() {
        repository = new DespesaDAO();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle("Principal");
        initViews();
//        showQuery();
    }

//    private void showQuery() {
//        ParseQuery<Despesa> query = ParseQuery.getQuery(Despesa.class);
//        query.findInBackground(new FindCallback<Despesa>() {
//            @Override
//            public void done(List<Despesa> results, ParseException e) {
//                if(e == null) {
//                    for (Despesa a : results) {
//                        Log.i(App.LOG_STATISTIKZ, a.getDescricao());
//                        a.setValor(new BigDecimal("90"));
//                        repository.update(a);
//                    }
//                } else {
//                    Log.e(App.LOG_STATISTIKZ, e.getMessage());
//                }
//            }
//        });
//    }

    private void initViews() {
        btnNovaDespesa = (FloatingActionButton) getView().findViewById(R.id.btnNovaDespesa);
        btnNovaReceita = (FloatingActionButton) getView().findViewById(R.id.btnNovaReceita);
        menu = (FloatingActionMenu) getView().findViewById(R.id.menu);
        btnNovaDespesa.setOnClickListener(clickListener);
        cardViewDespesas = (CardView) getView().findViewById(R.id.cardDespesas);
        cardViewDespesas.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent it;
            switch (v.getId()) {
                case R.id.btnNovaDespesa:
                    menu.close(false);
                    it = new Intent(getActivity(), DespesaActivity.class);
                    it.putExtra(Extra.OPTION_FRAGMENT, DespesaFragment.TAG_ADD_DESPESA);
                    startActivity(it);
                    break;
                case R.id.cardDespesas:
                    Toast.makeText(getActivity(), "Button pressed Cardview" , Toast.LENGTH_SHORT).show();
                    break;
            }

//            Toast.makeText(DashboardActivity.this, "Button pressed "+txtBtnPressed, Toast.LENGTH_SHORT).show();
        }
    };
}
