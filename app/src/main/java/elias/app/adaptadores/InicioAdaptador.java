package elias.app.adaptadores;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import elias.app.enchiloe.R;
import elias.app.enchiloe.fragmentos.CategoriasFragment;
import elias.app.enchiloe.fragmentos.EventosFragment;
import elias.app.enchiloe.fragmentos.InicioFragment;
import elias.app.modelos.Destacado;
import elias.app.modelos.Pyme;

/**
 * Created by elias on 08-08-15.
 */
public class InicioAdaptador extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<Object> datos;
    private OnItemClickListener onItemClickListener;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private FragmentManager fragmentManager;
    private Context cx;
    private HashMap<String,Integer> images;

    public InicioAdaptador(List<Object> datos,HashMap<String,Integer> imgs, FragmentManager f, Context cx) {
        this.datos = datos;
        this.fragmentManager = f;
        this.cx = cx;
        this.images = imgs;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType){
            case TYPE_HEADER:
                View header = inflater.inflate(R.layout.inicio_slider, parent, false);
                vh = new ViewHolderHeader(header);
                break;
            case TYPE_ITEM:
                View item = inflater.inflate(R.layout.inicio_card_item, parent, false);
                vh = new ViewHolderItem(item);
                break;
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()){
            case TYPE_HEADER:
                ViewHolderHeader vHeader = (ViewHolderHeader)holder;
                configurarHeader(vHeader, position);
                break;
            case TYPE_ITEM:
                ViewHolderItem vItem = (ViewHolderItem)holder;
                configurarItem(vItem, position);
                break;
        }

    }

    private void configurarItem(ViewHolderItem vItem, int position) {
        Pyme p = (Pyme)datos.get(position);
        if(p!=null){
            vItem.getTxtNombre().setText(p.getNombre());
            vItem.getImg().setImageResource(R.drawable.quellon);
            vItem.getImg().setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    private void configurarHeader(ViewHolderHeader vHeader, int position) {

        Destacado d = (Destacado)datos.get(position);
        if(d!=null){

            SliderLayout mDemoSlider = vHeader.getVp();

        if(images != null) {

            for (String name : images.keySet()) {
                TextSliderView textSliderView = new TextSliderView(cx);
                // initialize a SliderLayout
                textSliderView
                        .description(name)
                        .image(images.get(name))
                        .setScaleType(BaseSliderView.ScaleType.Fit);
                //.setOnSliderClickListener();

                //add your extra information
                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra", name);

                mDemoSlider.addSlider(textSliderView);
            }

            mDemoSlider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
            mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mDemoSlider.setCustomAnimation(new DescriptionAnimation());
            mDemoSlider.setDuration(6000);
            //mDemoSlider.addOnPageChangeListener(this);
        }
        }
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
    @Override
    public int getItemViewType(int position) {
        if(datos.get(position) instanceof Destacado) {
            return TYPE_HEADER;
        }else if(datos.get(position) instanceof Pyme){
            return TYPE_ITEM;
        }
        return -1;

    }



    //<editor-fold desc="VIEWHOLDERS">
    public class ViewHolderItem extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView txtNombre;



        public ViewHolderItem(View v) {
            super(v);

            img     = (ImageView)v.findViewById(R.id.imgCardInicio);
            txtNombre = (TextView)v.findViewById(R.id.txtCardInicio);

        }

        public ImageView getImg() {
            return img;
        }

        public void setImg(ImageView img) {
            this.img = img;
        }

        public TextView getTxtNombre() {
            return txtNombre;
        }

        public void setTxtNombre(TextView txtNombre) {
            this.txtNombre = txtNombre;
        }
    }

    public class ViewHolderHeader extends RecyclerView.ViewHolder{

        private SliderLayout vp;

        public ViewHolderHeader(View v) {
            super(v);

            vp = (SliderLayout)v.findViewById(R.id.sliderInicio);
        }

        public SliderLayout getVp() {
            return vp;
        }

        public void setVp(SliderLayout txt) {
            this.vp = vp;
        }
    }
    //</editor-fold>

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, Pyme pyme, int position);
    }
}
