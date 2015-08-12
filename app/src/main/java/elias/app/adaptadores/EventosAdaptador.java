package elias.app.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import elias.app.enchiloe.R;
import elias.app.modelos.Evento;

/**
 * Created by elias on 26-07-15.
 */
public class EventosAdaptador extends RecyclerView.Adapter<EventosAdaptador.EventosViewHolder> implements View.OnClickListener {

    private ArrayList<Evento> datos;
    private View.OnClickListener listener;

    public EventosAdaptador(ArrayList<Evento> datos) {
        this.datos = datos;
    }

    @Override
    public EventosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.eventos_list_item2, viewGroup, false);

        itemView.setOnClickListener(this);
        EventosViewHolder tvh = new EventosViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(EventosViewHolder viewHolder, int pos) {
        Evento item = datos.get(pos);

        viewHolder.bindEvento(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class EventosViewHolder extends RecyclerView.ViewHolder {

        private TextView txtNombre;
        private TextView txtDescripcion;

        public EventosViewHolder(View itemView) {
            super(itemView);

            txtNombre = (TextView)itemView.findViewById(R.id.txtEventoNombre);
            txtDescripcion = (TextView)itemView.findViewById(R.id.txtEventoDescripcion);
        }

        public void bindEvento(Evento t) {
            txtNombre.setText(t.getNombre());
            txtDescripcion.setText(t.getDescripcion());
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

}
