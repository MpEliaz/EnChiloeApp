//package adaptadores;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.RatingBar;
//import android.widget.TextView;
//
//import clases.Picadas;
//import elias.app.picadasenchiloe.R;
//
//import java.util.ArrayList;
//
///**
// * Created by Elias on 16-12-14.
// */
//public class ListaPicadasAdapter extends BaseAdapter {
//
//    private Context cx;
//    private ArrayList<Picadas> lista;
//    private LayoutInflater inflater;
//
//    public ListaPicadasAdapter(Context context, ArrayList<Picadas> picadas)
//    {
//        this.cx = context;
//        this.lista = picadas;
//    }
//
//
//    @Override
//    public int getCount() {
//        return lista.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return lista.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return lista.get(position).getId();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if(inflater == null)
//            inflater = (LayoutInflater)cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        if(convertView == null)
//            convertView = inflater.inflate(R.layout.item_lista_picadas, null);
//
//        Picadas p = lista.get(position);
//        inicializarComponentes(convertView, p);
//
//        return convertView;
//    }
//
//    private void inicializarComponentes(View view, Picadas p)
//    {
//        TextView nombre = (TextView)view.findViewById(R.id.txt_nombre);
//        TextView comuna = (TextView)view.findViewById(R.id.txt_comuna);
//        TextView desc_b = (TextView)view.findViewById(R.id.txt_desc_b);
//        RatingBar ratingBar = (RatingBar)view.findViewById(R.id.rb_calificacion);
//
//        nombre.setText(p.getNombre());
//        comuna.setText(p.getComuna());
//        desc_b.setText(p.getDescripcion_Breve());
//        ratingBar.setRating(p.getCalificacion());
//    }
//}
