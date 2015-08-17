package elias.app.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;

import java.util.ArrayList;

import elias.app.enchiloe.R;
import elias.app.modelos.Pyme;

/**
 * Created by elias on 08-08-15.
 */
public class InicioAdaptador extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private ArrayList<Pyme> datos;
    private OnItemClickListener onItemClickListener;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public InicioAdaptador(ArrayList<Pyme> datos) {
        this.datos = datos;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, Pyme pyme, int position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_ITEM){
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inicio_card_item, parent, false);

            final ViewHolderItem vh = new ViewHolderItem(itemView);

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
        else if(viewType == TYPE_HEADER) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inicio_slider, parent, false);
            final ViewHolderHeader vh = new ViewHolderHeader(v);

        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ViewHolderItem){

        Pyme p = datos.get(position);
            ((ViewHolderItem)holder).txtNombre.setText(p.getNombre());
        }else if (holder instanceof ViewHolderHeader){

        }

    }

    @Override
    public int getItemCount() {
        return datos.size()+1;
    }
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }



    public static class ViewHolderItem extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView txtNombre;



        public ViewHolderItem(View itemView) {
            super(itemView);

            txtNombre = (TextView)itemView.findViewById(R.id.txtCardInicio);

        }
    }

    public static class ViewHolderHeader extends RecyclerView.ViewHolder{

        private SliderLayout slider;

        public ViewHolderHeader(View itemView) {
            super(itemView);

            slider = (SliderLayout)itemView.findViewById(R.id.slider);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
