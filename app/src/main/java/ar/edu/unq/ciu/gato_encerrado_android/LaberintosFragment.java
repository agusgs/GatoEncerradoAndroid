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

    private ArrayList<Laberinto> getLaberintos() {
        final ArrayList<Laberinto> laberintos = new ArrayList<Laberinto>();

        LaberintosService laberintosService = createLaberintosService();
        laberintosService.getLaberintos(Usuario.USUARIO_CONOCIDO, new Callback<List<Laberinto>>() {

            @Override
            public void success(List<Laberinto> laberintosRecibidos, Response response) {
                laberintos.addAll(laberintosRecibidos);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });

        return laberintos;
    }

    private LaberintosService createLaberintosService() {
        return LaberintosServiceBuilder.buildService();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        setListAdapter(new LaberintosAdapter(getActivity(), getLaberintos()));
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//        Toast.makeText(getActivity(), "Item seleccionado " + position, Toast.LENGTH_SHORT).show();

        String laberintoId = "1";
        LaberintoDetalleFragment detalleLaberinto = new LaberintoDetalleFragment();
        detalleLaberinto.setLaberintoId(laberintoId);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            detalleLaberinto.setSharedElementEnterTransition(new DetailsTransition());
            detalleLaberinto.setEnterTransition(new Fade());
            setExitTransition(new Fade());
//            detalleLaberinto.setSharedElementReturnTransition(new DetailsTransition());
        }

        getActivity().getSupportFragmentManager()
                .beginTransaction()
//                .addSharedElement(holder.image, "kittenImage")
                .replace(R.id.container, detalleLaberinto)
                .addToBackStack(null)
                .commit();
    }
}
