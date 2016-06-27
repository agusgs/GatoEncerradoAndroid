package ar.edu.unq.ciu.gato_encerrado_android;

import retrofit.RestAdapter;

public class LaberintosServiceBuilder {
    static String SERVER_IP = "192.168.1.39"; //esta ip se usa para comunicarse con mi localhost en el emulador de Android Studio
    static String SERVER_IP_GENY = "192.168.1.39";//esta ip se usa para comunicarse con mi localhost en el emulador de Genymotion
    static String API_URL = "http://"+ SERVER_IP_GENY +":9000";


    public static LaberintosService buildService(){
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();

        return restAdapter.create(LaberintosService.class);
    }

}
