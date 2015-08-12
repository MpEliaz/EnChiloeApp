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
public class PymeListaAdaptador extends RecyclerView.Adapter<PymeListaAdaptador.PymeListViewHolder> implements View.OnClickListener {

    private ArrayList<Pyme> datos;
    private View.OnClickListener listener;

    public PymeListaAdaptador(ArrayList<Pyme> datos) {
        this.datos = datos;
    }

    @Override
    public PymeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pymes_list_item, parent, false);

        itemView.setOnClickListener(this);
        PymeListViewHolder vh = new PymeListViewHolder(itemView);

        return vh;
    }

    @Override
    public void onBindViewHolder(PymeListViewHolder Viewholder, int position) {

        Pyme item = datos.get(position);
        Viewholder.bindPyme(item);
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

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }


    public static class PymeListViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPymeList;
        private TextView txtNombre;
        private TextView txtComuna;
        private TextView txtDescripcion_corta;


        public PymeListViewHolder(View itemView) {
            super(itemView);

            imgPymeList = (ImageView)itemView.findViewById(R.id.img_pyme_list);
            txtNombre = (TextView)itemView.findViewById(R.id.txt_pyme_nombre_list);
            txtComuna = (TextView)itemView.findViewById(R.id.txt_pyme_comuna_list);
            txtDescripcion_corta = (TextView)itemView.findViewById(R.id.txt_pyme_desc_list);

        }

        public void bindPyme(Pyme p) {

            txtNombre.setText(p.getNombre());
            txtComuna.setText(p.getComuna());
            txtDescripcion_corta.setText(p.getDescripcion_corta());

        }
    }
}
