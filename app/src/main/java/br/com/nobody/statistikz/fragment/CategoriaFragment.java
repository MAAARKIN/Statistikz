package br.com.nobody.statistikz.fragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import br.com.nobody.statistikz.R;
import br.com.nobody.statistikz.dao.CategoriaDAO;
import br.com.nobody.statistikz.model.Categoria;
import br.com.nobody.statistikz.repository.CategoriaRepository;
import br.com.nobody.statistikz.util.Extra;
import br.com.nobody.statistikz.util.Option;

public class CategoriaFragment extends DialogFragment {

    public static final String TAG_CATEGORIA_MANAGER = "tagCategoriaManager";

    private EditText mEdtDescricao;
    private Categoria mCategoria;
    private CategoriaRepository repository;

    public static CategoriaFragment newInstance(Categoria categoria, String option) {
        CategoriaFragment fragment = new CategoriaFragment();
        Bundle args = new Bundle();
        args.putString(Extra.OPTION, option);
        if(categoria != null) {
            args.putSerializable(Extra.CATEGORIA, categoria);
        }
        fragment.setArguments(args);
        return fragment;
    }

    public CategoriaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repository = new CategoriaDAO();
        if (getArguments() != null && getArguments().getSerializable(Extra.CATEGORIA) != null) {
            mCategoria = (Categoria) getArguments().getSerializable(Extra.CATEGORIA);
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_categoria, null);
        mEdtDescricao = (EditText) view.findViewById(R.id.edtCategoriaDescricao);

        if (getArguments() != null) {

            if (mCategoria != null) {
                mEdtDescricao.setText(mCategoria.getDescricao());
            }

            if (getArguments().getString(Extra.OPTION).equals(Option.NEW)) {
                builder.setView(view)
                        .setTitle("Nova Categoria")
                        .setNeutralButton("Cancel", neutralAction)
                        .setPositiveButton("Salvar", positiveAction);
            } else {
                builder.setView(view)
                        .setTitle("Editar Categoria")
                        .setNeutralButton("Cancel", neutralAction)
                        .setPositiveButton("Salvar", positiveAction)
                        .setNegativeButton("Excluir", negativeAction);
            }
        }

        return builder.create();
    }

    private DialogInterface.OnClickListener positiveAction = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //do something here
            Categoria categoria = new Categoria();
            String descricao = mEdtDescricao.getText().toString();
            categoria.setDescricao(descricao);
            repository.save(categoria);
            dialog.dismiss();
            Log.i("FragmentAlertDialog", "Positive click!");
        }
    };

    private DialogInterface.OnClickListener negativeAction = new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.i("FragmentAlertDialog", "Negative click!");
            dialog.dismiss();
        }
    };

    private DialogInterface.OnClickListener neutralAction = new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.i("FragmentAlertDialog", "Neutral click!");
            dialog.dismiss();
        }
    };

}
