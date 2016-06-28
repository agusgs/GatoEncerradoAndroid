package ar.edu.unq.ciu.gato_encerrado_android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class CargarImagen extends AsyncTask<String, String, Bitmap> {

    private Bitmap bitmap;
    private ImageView imageView;

    public CargarImagen(ImageView imageView){
        super();
        this.imageView = imageView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected Bitmap doInBackground(String... args) {
        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(args[0]).getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap image) {

        if(image != null){
            imageView.setImageBitmap(image);
        }else{
            imageView.setImageResource(R.drawable.gato_encerrado);
        }
    }
}
