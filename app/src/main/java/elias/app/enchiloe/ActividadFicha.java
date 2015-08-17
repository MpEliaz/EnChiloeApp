package elias.app.enchiloe;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

import elias.app.modelos.Pyme;


public class ActividadFicha extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, OnMapReadyCallback {


    private String nombre="";
    SliderLayout mDemoSlider;
    private Double latitud;
    private Double longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_ficha);

        if(savedInstanceState == null)
        {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {

                setearDatos(extras);
                inicializarToolbar();
                inicializarMapa();
                inicializarSlider();
            }
        }
    }

    private void inicializarSlider() {
        mDemoSlider = (SliderLayout) findViewById(R.id.slider1);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Big Bang Theory", R.drawable.hotel2);
        file_maps.put("House of Cards", R.drawable.hotel3);

        for(String name : file_maps.keySet()){
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Stack);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setIndicatorVisibility(PagerIndicator.IndicatorVisibility.Invisible);
        mDemoSlider.setDuration(6000);
        mDemoSlider.addOnPageChangeListener(this);
    }

    private void inicializarToolbar() {

        //CollapsingToolbarLayout
        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctlLayout);
        ctlLayout.setTitle(nombre);
        //ctlLayout.setCollapsedTitleTextAppearance(R.style.FichaTitle);

        //App bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(nombre);
    }

    private void inicializarMapa() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.ficha_map);
        mapFragment.getMapAsync(this);
    }

    private void setearDatos(Bundle extras) {

        nombre = extras.getString("nombre");
        TextView txtDireccion = (TextView) findViewById(R.id.txtpDireccion);
        TextView txtTelefono = (TextView) findViewById(R.id.txtpTelefono);
        TextView txtEmail = (TextView) findViewById(R.id.txtpEmail);
        TextView txtDescripcion = (TextView) findViewById(R.id.txtpDescLarga);

        txtDireccion.setText(extras.getString("direccion"));
        txtTelefono.setText(extras.getString("telefono"));
        txtEmail.setText(extras.getString("email"));
        txtDescripcion.setText(extras.getString("descripcion_larga"));
        latitud = extras.getDouble("latitud");
        longitud = extras.getDouble("longitud");

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
        if (id == R.id.pyme_filter) {
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
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onResume() {
        mDemoSlider.startAutoCycle();
        super.onResume();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.getUiSettings().setScrollGesturesEnabled(false);

        if(latitud!= 0.0 && longitud!=0.0)
        {
            LatLngBounds position = new LatLngBounds(
                    new LatLng(latitud, longitud), new LatLng(latitud, longitud));

            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(latitud,longitud))
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(position.getCenter(), 10));

        }

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
//                Toast.makeText(ActividadFicha.this, "hola", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ActividadFicha.this, ActividadMapa.class);
                startActivity(i);
            }
        });
    }
}
