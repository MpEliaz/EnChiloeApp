package elias.app.adaptadores;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
public class CategoriasAdaptador extends RecyclerView.Adapter<CategoriasAdaptador.CategoriaViewHolder> implements View.OnClickListener {

    private ArrayList<Categoria> datos;
    private View.OnClickListener listener;

    public CategoriasAdaptador(ArrayList<Categoria> datos) {
        this.datos = datos;
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.categoria_list_item, viewGroup, false);

        itemView.setOnClickListener(this);
        CategoriaViewHolder tvh = new CategoriaViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(CategoriaViewHolder viewHolder, int pos) {
        Categoria item = datos.get(pos);
        viewHolder.bindCategoria(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    public static class CategoriaViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNombre;
        private TextView txtDescripcion;
        private ImageView cat_imagen;

        public CategoriaViewHolder(View itemView) {
            super(itemView);

            txtNombre = (TextView)itemView.findViewById(R.id.cat_nombre);
            cat_imagen = (ImageView)itemView.findViewById(R.id.cat_color);
            //txtDescripcion = (TextView)itemView.findViewById(R.id.txtEventoDescripcion);
        }

        public void bindCategoria(Categoria c) {
            txtNombre.setText(c.getNombre());
            cat_imagen.setBackgroundColor(c.getColor());
            //txtDescripcion.setText(t.getDescripcion());
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

}