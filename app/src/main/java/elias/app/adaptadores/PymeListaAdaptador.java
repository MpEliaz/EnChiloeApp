package elias.app.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import elias.app.enchiloe.R;
import elias.app.modelos.Evento;
import elias.app.modelos.Pyme;

/**
 * Created by elias on 08-08-15.
 */
public class PymeListaAdaptador extends RecyclerView.Adapter<PymeListaAdaptador.ViewHolder>  {

    private ArrayList<Pyme> datos;
    private OnItemClickListener onItemClickListener;

    public PymeListaAdaptador(ArrayList<Pyme> datos) {
        this.datos = datos;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, Pyme pyme, int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pymes_list_item, parent, false);

        final ViewHolder vh = new ViewHolder(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null)
                {
                    onItemClickListener.onItemClick(v,datos.get(vh.getAdapterPosition()),vh.getAdapterPosition());
                }
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Pyme p = datos.get(position);
        holder.txtNombre.setText(p.getNombre());
        holder.txtComuna.setText(p.getComuna());
        holder.txtDescripcion_corta.setText(p.getDescripcion_corta());
        holder.setDesc_larga(p.getDescripcion_larga());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPymeList;
        private TextView txtNombre;
        private TextView txtComuna;
        private TextView txtDescripcion_corta;
        private String desc_larga;


        public ViewHolder(View itemView) {
            super(itemView);

            imgPymeList = (ImageView)itemView.findViewById(R.id.img_pyme_list);
            txtNombre = (TextView)itemView.findViewById(R.id.txt_pyme_nombre_list);
            txtComuna = (TextView)itemView.findViewById(R.id.txt_pyme_comuna_list);
            txtDescripcion_corta = (TextView)itemView.findViewById(R.id.txt_pyme_desc_list);

        }

        public void setDesc_larga(String desc_larga) {
            this.desc_larga = desc_larga;
        }

        public String getDesc_larga() {
            return desc_larga;
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
