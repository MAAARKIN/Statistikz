package br.com.nobody.statistikz.app;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;

import br.com.nobody.statistikz.R;
import br.com.nobody.statistikz.model.Despesa;

/**
 * Created by Marquinhos.
 */
public class App extends Application {

    public static final String LOG_STATISTIKZ = "Statistikz";

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Despesa.class);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.applicationId), getString(R.string.clientKey));
        Log.i(LOG_STATISTIKZ, "Teste de log Statistikz");
    }
}
