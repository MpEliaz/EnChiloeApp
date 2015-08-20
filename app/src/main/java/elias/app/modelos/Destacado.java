package elias.app.modelos;

import android.widget.ImageView;

/**
 * Created by elias on 19-08-15.
 */
public class Destacado {
    private int id;
    private String nombre;
    private ImageView imagen;

    public Destacado(int id, String nombre, ImageView imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }
}
