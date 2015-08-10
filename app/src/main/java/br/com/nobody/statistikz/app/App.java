package br.com.nobody.statistikz.app;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Marquinhos.
 */
public class App extends Application {

    public static final String LOG_STATISTIKZ = "Statistikz";

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "YOUR_APP_ID", "YOUR_CLIENT_KEY");

        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }
}
