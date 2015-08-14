package br.com.nobody.statistikz.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

import br.com.nobody.statistikz.R;
import br.com.nobody.statistikz.app.App;
import br.com.nobody.statistikz.model.Despesa;
import br.com.nobody.statistikz.util.Extra;

/**
 * Será responsável pelo fragmento que terá a possibilidade de cadastrar/editar uma nova despesa
 */
public class DespesaFragment extends Fragment {

    public static final String TAG_ADD_DESPESA = "tagAddDespesa";

    private EditText edtValor;
    private EditText edtDescricao;
    private Button btnActionDespesa;
    private Despesa mDespesa;

//    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static DespesaFragment newInstance(Despesa despesa) {
        DespesaFragment fragment = new DespesaFragment();
        //i won't pass parameters now.
        Bundle params = new Bundle();
        params.putSerializable(Extra.DESPESA, despesa);
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public DespesaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDespesa = (Despesa) getArguments().getSerializable(Extra.DESPESA);
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle(R.string.novaDespesa);
        return inflater.inflate(R.layout.fragment_despesa, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        edtValor = (EditText) getView().findViewById(R.id.edtValor);
        edtDescricao = (EditText) getView().findViewById(R.id.edtDescricao);
        btnActionDespesa = (Button) getView().findViewById(R.id.btnActionDespesa);

        if(mDespesa != null) {
            //provavelmente um processo de edição de despesa.
            //preencher os EditText's com os campos de despesa
            btnActionDespesa.setOnClickListener(new EditDespesa());
        } else {
            btnActionDespesa.setOnClickListener(new AddDespesa());
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        try {
//            mListener = (OnFragmentInteractionListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    private class AddDespesa implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mDespesa = new Despesa(); //provavelmente a instancia estará nula
            mDespesa.setValor(new BigDecimal(edtValor.getText().toString()));
            mDespesa.setDescricao(edtDescricao.getText().toString());
            Log.i(App.LOG_STATISTIKZ, "Salvando a nova Despesa: "+mDespesa.getDescricao()+" e "+mDespesa.getValor());
        }

    }

    private class EditDespesa implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //instancia não deve estar nula no momento da edição
            mDespesa.setValor(new BigDecimal(edtValor.getText().toString()));
            mDespesa.setDescricao(edtDescricao.getText().toString());
            Log.i(App.LOG_STATISTIKZ, "Editando a Despesa: "+mDespesa.getDescricao()+" e "+mDespesa.getValor());
        }

    }

}
