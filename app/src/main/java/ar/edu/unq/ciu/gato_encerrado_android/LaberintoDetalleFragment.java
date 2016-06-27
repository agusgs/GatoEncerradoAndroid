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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

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

        DetalleLaberinto detalleLaberinto = getDetalleLaberinto();

        TextView laberintoNombre = new TextView(getActivity());
        laberintoNombre.setTextSize(40);
        laberintoNombre.setText(detalleLaberinto.getNombre());

        TextView laberintoDetalle = new TextView(getActivity());
        laberintoDetalle.setTextSize(40);
        laberintoDetalle.setText(detalleLaberinto.getNombre());

        ImageView laberintoImagen= new ImageView(getActivity());
        laberintoImagen.setImageResource(R.drawable.gato_encerrado);

        LinearLayout layout = (LinearLayout) getView();
        layout.addView(laberintoNombre);
        layout.addView(laberintoDetalle);
        layout.addView(laberintoImagen);

    }

    public DetalleLaberinto getDetalleLaberinto() {
        LaberintosService service = LaberintosServiceBuilder.buildService();
        final ArrayList<DetalleLaberinto> detalleLaberinto = new ArrayList<DetalleLaberinto>();

        service.getDetalleLaberinto(Usuario.USUARIO_CONOCIDO, this.laberintoId, new Callback<DetalleLaberinto>() {

            @Override
            public void success(DetalleLaberinto detalleLaberintoRecibido, Response response) {
                detalleLaberinto.add(detalleLaberintoRecibido);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("", error.getMessage());
                error.printStackTrace();
            }
        });

        return detalleLaberinto.get(0);
    }

    public void setLaberintoId(String laberintoId) {
        this.laberintoId = laberintoId;
    }
}
