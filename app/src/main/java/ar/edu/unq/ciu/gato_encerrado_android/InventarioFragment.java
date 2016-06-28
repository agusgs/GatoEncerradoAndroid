package ar.edu.unq.ciu.gato_encerrado_android;


import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v4.media.TransportPerformer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class InventarioFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.inventario_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        getInventario();
    }

    public void getInventario() {
        LaberintosService service = LaberintosServiceBuilder.buildService();

        Callback<List<Item>> callback = new Callback<List<Item>>() {
            @Override
            public void success(List<Item> items, Response response) {
                mostrarInventario(items);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error obtener detalle", error.getMessage());
                error.printStackTrace();
            }
        };

        service.getInventario(Usuario.USUARIO_CONOCIDO, callback);
    }

    private void mostrarInventario(List<Item> items) {
        if(items.isEmpty()){
            Toast.makeText(getActivity(), "No hay Items en el inventario", Toast.LENGTH_LONG).show();
        }
        setListAdapter(new InventarioAdapter(getActivity(), items));
    }

}
