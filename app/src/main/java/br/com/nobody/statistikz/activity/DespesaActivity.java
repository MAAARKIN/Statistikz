package br.com.nobody.statistikz.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import br.com.nobody.statistikz.R;
import br.com.nobody.statistikz.fragment.DespesaFragment;
import br.com.nobody.statistikz.util.Extra;

public class DespesaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despesa);

        initFragment();
    }

    private void initFragment() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String optionFragment = extras.getString(Extra.OPTION_FRAGMENT);
            if (optionFragment.equals(DespesaFragment.TAG_ADD_DESPESA)) {
                DespesaFragment frag = DespesaFragment.newInstance(null);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentDespesaContent, frag, DespesaFragment.TAG_ADD_DESPESA);
                ft.commit();
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_despesa, menu);
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
