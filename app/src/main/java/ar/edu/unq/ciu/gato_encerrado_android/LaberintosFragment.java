package ar.edu.unq.ciu.gato_encerrado_android;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.transition.Fade;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LaberintosFragment extends ListFragment implements OnItemClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.laberintos_fragment, container, false);
    }

    private void getLaberintos() {

        LaberintosService laberintosService = createLaberintosService();
        laberintosService.getLaberintos(Usuario.USUARIO_CONOCIDO, new Callback<List<Laberinto>>() {

            @Override
            public void success(List<Laberinto> laberintosRecibidos, Response response) {
                mostrarLaberintos(laberintosRecibidos);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });
    }

    private void mostrarLaberintos(List<Laberinto> laberintosRecibidos) {
        setListAdapter(new LaberintosAdapter(getActivity(), laberintosRecibidos));
        getListView().setOnItemClickListener(this);
    }

    private LaberintosService createLaberintosService() {
        return LaberintosServiceBuilder.buildService();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        getLaberintos();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        Laberinto laberinto = (Laberinto) adapterView.getAdapter().getItem(position);
        LaberintoDetalleFragment detalleLaberinto = new LaberintoDetalleFragment();
        detalleLaberinto.setLaberintoId(laberinto.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            detalleLaberinto.setEnterTransition(new Fade());
            setExitTransition(new Fade());
        }

        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, detalleLaberinto)
                .addToBackStack(null)
                .commit();
    }
}
