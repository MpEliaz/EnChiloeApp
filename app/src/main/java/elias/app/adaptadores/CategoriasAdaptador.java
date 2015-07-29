package elias.app.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import elias.app.enchiloe.R;
import elias.app.modelos.Categoria;
import elias.app.modelos.Evento;

/**
 * Created by elias on 26-07-15.
 */
public class CategoriasAdaptador extends RecyclerView.Adapter<CategoriasAdaptador.CategoriaViewHolder> {

    private ArrayList<Categoria> datos;
    private int[] colores;

    public CategoriasAdaptador(ArrayList<Categoria> datos) {
        this.datos = datos;
        colores = new int[]{R.color.cat_1, R.color.cat_2, R.color.cat_3, R.color.cat_4};
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.categoria_list_item, viewGroup, false);

        CategoriaViewHolder tvh = new CategoriaViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(CategoriaViewHolder viewHolder, int pos) {
        Categoria item = datos.get(pos);
        viewHolder.bindTitular(item, colores[pos]);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNombre;
        private TextView txtDescripcion;
        private ImageView cat_imagen;

        public CategoriaViewHolder(View itemView) {
            super(itemView);

            txtNombre = (TextView)itemView.findViewById(R.id.cat_nombre);
            cat_imagen = (ImageView)itemView.findViewById(R.id.cat_imagen);
            //txtDescripcion = (TextView)itemView.findViewById(R.id.txtEventoDescripcion);
        }

        public void bindTitular(Categoria t, int color) {
            txtNombre.setText(t.getNombre());
            cat_imagen.setBackgroundColor(color);
            //txtDescripcion.setText(t.getDescripcion());
        }
    }

}