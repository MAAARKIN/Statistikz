package br.com.nobody.statistikz.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import br.com.nobody.statistikz.R;
import br.com.nobody.statistikz.app.App;
import br.com.nobody.statistikz.fragment.DespesaFragment;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Despesa despesa = new Despesa();
//        despesa.setDescricao("testeMarcos");
//        despesa.setValor(new BigDecimal("70.57"));
//        despesa.saveEventually();
        Log.i(App.LOG_STATISTIKZ, "enviou para o parse.com!");

        setContentView(R.layout.activity_main);
        DespesaFragment frag = DespesaFragment.newInstance(null);

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragmentContent, frag, DespesaFragment.TAG_ADD_DESPESA);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
