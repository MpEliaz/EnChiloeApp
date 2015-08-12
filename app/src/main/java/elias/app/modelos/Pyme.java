package elias.app.modelos;

import com.google.gson.annotations.SerializedName;
/**
 * Created by elias on 26-07-15.
 */
public class Pyme {
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("direccion")
    private String direccion;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("comuna")
    private String comuna;
    @SerializedName("estado")
    private int estado;
    @SerializedName("email")
    private String email;
    @SerializedName("url_imagen")
    private String url_imagen;
    @SerializedName("descripcion_corta")
    private String descripcion_corta;
    @SerializedName("descripcion_larga")
    private String descripcion_larga;

    public Pyme(){}

    public Pyme(int id, String nombre, String descripcion_corta, String comuna) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion_corta = descripcion_corta;
        this.comuna = comuna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public String getDescripcion_corta() {
        return descripcion_corta;
    }

    public void setDescripcion_corta(String descripcion_corta) {
        this.descripcion_corta = descripcion_corta;
    }

    public String getDescripcion_larga() {
        return descripcion_larga;
    }

    public void setDescripcion_larga(String descripcion_larga) {
        this.descripcion_larga = descripcion_larga;
    }
}
