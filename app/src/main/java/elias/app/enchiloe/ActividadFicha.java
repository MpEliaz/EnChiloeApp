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

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;

import elias.app.adaptadores.CategoriasAdaptador;
import elias.app.modelos.Categoria;


public class ActividadFicha extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {

    private RecyclerView recView;
    ArrayList<Categoria> categorias;
    private CollapsingToolbarLayout ctlLayout;
    private SliderLayout mDemoSlider;


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

        mDemoSlider = (SliderLayout)findViewById(R.id.slider1);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal", R.drawable.hotel3);
        file_maps.put("Big Bang Theory", R.drawable.hotel2);
        file_maps.put("House of Cards", R.drawable.hotel1);

        for(String name : file_maps.keySet()){
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    //.description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack );
        //mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(6000);
        mDemoSlider.addOnPageChangeListener(this);

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

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onSliderClick(BaseSliderView baseSliderView) {

    }
}
