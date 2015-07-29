package elias.app.enchiloe.fragmentos;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import java.util.ArrayList;
import elias.app.adaptadores.CategoriasAdaptador;
import elias.app.modelos.Categoria;

public class CategoriasFragment extends ListFragment {

    private CategoriasAdaptador adapter;
    ArrayList<Categoria> categorias;

    public CategoriasFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        categorias = new ArrayList<Categoria>();
        categorias.add(new Categoria("Hoteles"));
        categorias.add(new Categoria("Pubs"));
        categorias.add(new Categoria("Restaurants"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        categorias.add(new Categoria("Cabañas"));
        adapter = new CategoriasAdaptador(getActivity(), categorias);
        setListAdapter(adapter);
    }

}
