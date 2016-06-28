package ar.edu.unq.ciu.gato_encerrado_android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class LaberintoDetalleFragment extends Fragment{

    private String laberintoId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.detalle_laberinto_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        getDetalleLaberinto();

    }

    public void getDetalleLaberinto() {
        LaberintosService service = LaberintosServiceBuilder.buildService();

        Callback<DetalleLaberinto> callback = new Callback<DetalleLaberinto>() {
            @Override
            public void success(DetalleLaberinto detalleLaberintoRecibido, Response response) {
                mostrarDetalles(detalleLaberintoRecibido);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error obtener detalle", error.getMessage());
                error.printStackTrace();
            }
        };

        service.getDetalleLaberinto(Usuario.USUARIO_CONOCIDO, this.laberintoId, callback);
    }

    public void setLaberintoId(String laberintoId) {
        this.laberintoId = laberintoId;
    }

    public void mostrarDetalles(DetalleLaberinto detalleLaberinto){
        TextView laberintoNombre = new TextView(getActivity());
        laberintoNombre.setTextSize(40);
        laberintoNombre.setText(detalleLaberinto.getNombre());

        TextView laberintoDescripcion = new TextView(getActivity());
        laberintoDescripcion.setTextSize(40);
        laberintoDescripcion.setText(detalleLaberinto.getDescripcion());

        ImageView laberintoImagen= new ImageView(getActivity());
        new CargarImagen(laberintoImagen).execute(detalleLaberinto.getPathImagen());

        LinearLayout layout = (LinearLayout) getView();
        layout.addView(laberintoNombre);
        layout.addView(laberintoDescripcion);
        layout.addView(laberintoImagen);
    }

}