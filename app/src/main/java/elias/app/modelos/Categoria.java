package elias.app.modelos;

import android.graphics.Color;

/**
 * Created by elias on 26-07-15.
 */
public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Categoria(int id, String nombre, int color) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
