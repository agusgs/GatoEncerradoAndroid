package ar.edu.unq.ciu.gato_encerrado_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "ar.edu.unq.ciu.gato_encerrado_android.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new LaberintosFragment())
                    .commit();
        }
    }
}
