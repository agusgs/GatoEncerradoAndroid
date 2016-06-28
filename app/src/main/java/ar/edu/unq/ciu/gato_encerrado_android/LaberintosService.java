package ar.edu.unq.ciu.gato_encerrado_android;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface LaberintosService {
    @GET("/laberintos/{UsuarioId}")
    void getLaberintos(@Path("UsuarioId") String id, Callback<List<Laberinto>> callback);

    @GET("/detalleLaberinto/{UsuarioId}/{LaberintoId}")
    void getDetalleLaberinto(
            @Path("UsuarioId") String id,
            @Path("LaberintoId") String laberintoId,
            Callback<DetalleLaberinto> callback
    );

    @GET("/inventario/{UsuarioId}")
    void getInventario(@Path("UsuarioId") String usuarioConocido, Callback<List<Item>> callback);
}
