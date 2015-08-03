package elias.app.enchiloe.fragmentos;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import elias.app.adaptadores.EventosAdaptador;
import elias.app.enchiloe.ActividadFicha;
import elias.app.enchiloe.R;
import elias.app.modelos.Evento;
import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventosFragment extends Fragment {

    private RecyclerView recView;
    private ArrayList<Evento> eventos;

    public EventosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_eventos, container, false);
        eventos = new ArrayList<Evento>();
        for(int i=0; i<10; i++)
            eventos.add(new Evento(i, "Gran reitimiento en Chanco " + i, "gran reitimiento a las afueras de chanco, yoco curantos y una gran variedad de comida tipica de la zona. " + i));

        recView = (RecyclerView)v.findViewById(R.id.Eventos_RecView);
        recView.setHasFixedSize(true);

        final EventosAdaptador adaptador = new EventosAdaptador(eventos);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("DemoRecView", "Pulsado el elemento " + recView.getChildPosition(v));
                Intent intent = new Intent(getActivity(), ActividadFicha.class);
                startActivity(intent);
            }
        });

        recView.setAdapter(adaptador);
        recView.setLayoutManager(
                new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_eventos, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }
}
