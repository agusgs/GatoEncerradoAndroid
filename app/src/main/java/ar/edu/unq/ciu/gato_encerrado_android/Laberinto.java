package ar.edu.unq.ciu.gato_encerrado_android;

public class Laberinto {
    private final String id;
    private final String nombre;
    private final String pathImagen;

    public Laberinto(String id, String nombre, String pathImagen) {

        this.id = id;
        this.nombre = nombre;
        this.pathImagen = pathImagen;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPathImagen() {
        return pathImagen;
    }
}
