package ar.edu.unq.ciu.gato_encerrado_android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OtroFragment extends Fragment{
    public static final String ARG_POSITION = "lala";

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return layoutInflater.inflate(R.layout.otro_fragment_view, viewGroup, false);
    }
}
