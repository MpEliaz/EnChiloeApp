package elias.app.enchiloe.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import elias.app.adaptadores.CategoriasAdaptador;
import elias.app.adaptadores.EventosAdaptador;
import elias.app.enchiloe.R;
import elias.app.modelos.Categoria;
import elias.app.modelos.Evento;

public class CategoriasFragment extends Fragment {

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
        categorias.add(new Categoria("¿Qué hacer?"));
        categorias.add(new Categoria("¿Donde Dormir?"));
        categorias.add(new Categoria("¿Donde Comer?"));
        categorias.add(new Categoria("Servicios"));


        recView = (RecyclerView)v.findViewById(R.id.Categorias_RecView);
        recView.setHasFixedSize(true);

        final CategoriasAdaptador adaptador = new CategoriasAdaptador(categorias);

        recView.setAdapter(adaptador);
        recView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return v;
    }

}
