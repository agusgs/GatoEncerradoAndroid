package ar.edu.unq.ciu.gato_encerrado_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LaberintosAdapter extends BaseAdapter{

    private final List<Laberinto> laberintos;
    private final Context context;

    public LaberintosAdapter(Context context, List<Laberinto> laberintos) {
        this.laberintos = laberintos;
        this.context = context;
    }


    @Override
    public int getCount() {
        return laberintos.size();
    }

    @Override
    public Object getItem(int i) {
        return laberintos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.laberinto_item, parent, false);

        TextView laberintoNombre = (TextView) rowView.findViewById(R.id.laberintoNombre);
        TextView laberintoId = (TextView) rowView.findViewById(R.id.laberintoId);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        laberintoNombre.setText(laberintos.get(position).getNombre());
        laberintoId.setText(laberintos.get(position).getId());

        new CargarImagen(imageView).execute(laberintos.get(position).getPathImagen());

        return rowView;
    }

}
