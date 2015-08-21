package elias.app.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import elias.app.enchiloe.R;
import elias.app.modelos.Categoria;
import elias.app.modelos.Pyme;

/**
 * Created by elias on 26-07-15.
 */
public class CategoriasAdaptador extends RecyclerView.Adapter<CategoriasAdaptador.CategoriaViewHolder> {

    private ArrayList<Categoria> datos;
    private OnItemClickListener onItemClickListener;

    public CategoriasAdaptador(ArrayList<Categoria> datos) {
        this.datos = datos;
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.categoria_list_item, viewGroup, false);

        final CategoriaViewHolder tvh = new CategoriaViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, datos.get(tvh.getAdapterPosition()), tvh.getAdapterPosition());
                }
            }
        });

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

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Categoria cat, int position);
    }
}