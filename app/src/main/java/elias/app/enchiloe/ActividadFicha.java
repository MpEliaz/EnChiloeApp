package elias.app.enchiloe;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import elias.app.adaptadores.CategoriasAdaptador;
import elias.app.modelos.Categoria;


public class ActividadFicha extends AppCompatActivity {

    private RecyclerView recView;
    ArrayList<Categoria> categorias;
    private CollapsingToolbarLayout ctlLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_ficha);


        //App bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle("Mi Aplicación");

        categorias = new ArrayList<Categoria>();
        categorias.add(new Categoria("¿Qué hacer?",this.getResources().getColor(R.color.cat_1)));
        categorias.add(new Categoria("¿Donde Dormir?", this.getResources().getColor(R.color.cat_2)));
        categorias.add(new Categoria("¿Donde Comer?", this.getResources().getColor(R.color.cat_3)));
        categorias.add(new Categoria("Servicios", this.getResources().getColor(R.color.cat_4)));


        /*recView = (RecyclerView) findViewById(R.id.lstLista);
        recView.setHasFixedSize(true);

        final CategoriasAdaptador adaptador = new CategoriasAdaptador(categorias);

        recView.setAdapter(adaptador);
        recView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));*/

        //CollapsingToolbarLayout
        ctlLayout = (CollapsingToolbarLayout)findViewById(R.id.ctlLayout);
        ctlLayout.setTitle("Hotel Patagonia");
        ctlLayout.setCollapsedTitleTextAppearance(R.layout.ficha_titulo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_ficha, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
