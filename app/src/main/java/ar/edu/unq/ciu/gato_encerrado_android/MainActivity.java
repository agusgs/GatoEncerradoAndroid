package ar.edu.unq.ciu.gato_encerrado_android;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

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

    public void verInventario(View view) {
        InventarioFragment inventarioFragment = new InventarioFragment();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            inventarioFragment.setEnterTransition(new Fade());
            inventarioFragment.setExitTransition(new Fade());
        }

        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, inventarioFragment)
                .addToBackStack(null)
                .commit();
    }
}
