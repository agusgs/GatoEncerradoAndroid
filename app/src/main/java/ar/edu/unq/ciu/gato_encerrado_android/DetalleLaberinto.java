package ar.edu.unq.ciu.gato_encerrado_android;

public class DetalleLaberinto {

    private final String id;
    private final String nombre;
    private final String pathImagen;
    private final String descripcion;

    public DetalleLaberinto(String id, String nombre, String pathImagen, String descripcion){

        this.id = id;
        this.nombre = nombre;
        this.pathImagen = pathImagen;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }
}
