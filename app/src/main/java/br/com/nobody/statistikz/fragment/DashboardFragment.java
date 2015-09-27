package br.com.nobody.statistikz.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import br.com.nobody.statistikz.R;
import br.com.nobody.statistikz.activity.DespesaActivity;
import br.com.nobody.statistikz.dao.DespesaDAO;
import br.com.nobody.statistikz.repository.DespesaRepository;
import br.com.nobody.statistikz.util.Extra;
import br.com.nobody.statistikz.util.Option;

/**
 * Created by Marquinhos on 07/09/15.
 */
public class DashboardFragment extends Fragment {

    private DespesaRepository repository;

    public static final String TAG_PRINCIPAL_DASHBOARD = "tagPrincipalDashboard";

    private FloatingActionButton btnNovaDespesa;
    private FloatingActionButton btnNovaCategoria;
    private FloatingActionButton btnNovaReceita;
    private FloatingActionMenu menu;
    private LinearLayout viewDespesas;
    private LinearLayout viewReceitas;

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
        btnNovaCategoria = (FloatingActionButton) getView().findViewById(R.id.btnNovaCategoria);
        menu = (FloatingActionMenu) getView().findViewById(R.id.menu);
        btnNovaDespesa.setOnClickListener(clickListener);
        btnNovaCategoria.setOnClickListener(clickListener);
        viewDespesas = (LinearLayout) getView().findViewById(R.id.cardDespesas);
        viewReceitas = (LinearLayout) getView().findViewById(R.id.cardReceitas);
        viewDespesas.setOnClickListener(clickListener);
        viewReceitas.setOnClickListener(clickListener);
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
                case R.id.btnNovaCategoria:
                    menu.close(false);
                    FragmentManager fm = getFragmentManager();
                    CategoriaFragment fragment = CategoriaFragment.newInstance(null, Option.NEW);
                    fragment.show(fm, CategoriaFragment.TAG_CATEGORIA_MANAGER);
                    break;
                case R.id.cardDespesas:
                    menu.close(false);
                    it = new Intent(getActivity(), DespesaActivity.class);
                    it.putExtra(Extra.OPTION_FRAGMENT, DespesaListFragment.TAG_LIST_DESPESA);
                    startActivity(it);
                    break;
                case R.id.cardReceitas:
                    Toast.makeText(getActivity(), "Button pressed LinearView" , Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
