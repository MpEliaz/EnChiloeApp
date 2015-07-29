package elias.app.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import elias.app.enchiloe.R;
import elias.app.modelos.Categoria;

/**
 * Created by elias on 26-07-15.
 */
public class CategoriasAdaptador extends BaseAdapter {

    private Context cx;
    private ArrayList<Categoria> lista;
    private LayoutInflater inflater;

    public CategoriasAdaptador(Context context, ArrayList<Categoria> categorias)
    {
        this.cx = context;
        this.lista = categorias;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Categoria getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null)
            inflater = (LayoutInflater)cx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.categoria_list_item, null);

        Categoria p = lista.get(position);
        inicializarComponentes(convertView, p);

        return convertView;
    }

    private void inicializarComponentes(View view, Categoria p)
    {
        TextView nombre = (TextView)view.findViewById(R.id.cat_item);

        nombre.setText(p.getNombre());

    }

}