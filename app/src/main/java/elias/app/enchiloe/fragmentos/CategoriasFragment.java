package elias.app.enchiloe.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import elias.app.adaptadores.CategoriasAdaptador;
import elias.app.adaptadores.EventosAdaptador;
import elias.app.enchiloe.ActividadFicha;
import elias.app.enchiloe.ActividadListaPymes;
import elias.app.enchiloe.R;
import elias.app.modelos.Categoria;
import elias.app.modelos.Evento;

public class CategoriasFragment extends Fragment implements CategoriasAdaptador.OnItemClickListener {

    private RecyclerView recView;
    ArrayList<Categoria> categorias;

    public CategoriasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_categorias, container, false);

        categorias = new ArrayList<Categoria>();
        categorias.add(new Categoria(1,"¿Qué hacer?",v.getContext().getResources().getColor(R.color.cat_1)));
        categorias.add(new Categoria(2,"¿Donde Dormir?", v.getContext().getResources().getColor(R.color.cat_2)));
        categorias.add(new Categoria(3,"¿Donde Comer?", v.getContext().getResources().getColor(R.color.cat_3)));
        categorias.add(new Categoria(4,"Servicios", v.getContext().getResources().getColor(R.color.cat_4)));


        recView = (RecyclerView)v.findViewById(R.id.Categorias_RecView);
        recView.setHasFixedSize(true);

        final CategoriasAdaptador adaptador = new CategoriasAdaptador(categorias);
        adaptador.setOnItemClickListener(this);


        recView.setAdapter(adaptador);
        recView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return v;
    }

    @Override
    public void onItemClick(View view, Categoria cat, int position) {
        //Toast.makeText(getActivity(), "pulsaste la la cat de id:" + cat.getId(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ActividadListaPymes.class);
        intent.putExtra("cat_id",cat.getId());
        intent.putExtra("cat_nombre",cat.getNombre());
        startActivity(intent);
    }
}
