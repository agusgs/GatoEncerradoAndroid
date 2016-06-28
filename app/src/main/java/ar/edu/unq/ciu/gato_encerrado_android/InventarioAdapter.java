package ar.edu.unq.ciu.gato_encerrado_android;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

public class InventarioAdapter extends BaseAdapter {
    private final Context context;
    private final List<Item> items;

    public InventarioAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.inventario_item, parent, false);

        TextView itemNombre = (TextView) rowView.findViewById(R.id.itemNombre);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.itemImagen);

        itemNombre.setText(items.get(position).getNombre());

        new CargarImagen(imageView).execute(items.get(position).getPathImagen());

        return rowView;
    }
}