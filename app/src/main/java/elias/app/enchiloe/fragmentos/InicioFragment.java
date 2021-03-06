package elias.app.enchiloe.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import elias.app.adaptadores.InicioAdaptador;
import elias.app.enchiloe.R;
import elias.app.modelos.Destacado;
import elias.app.modelos.Pyme;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener, SearchView.OnQueryTextListener, InicioAdaptador.OnItemClickListener {

    private SliderLayout mDemoSlider;
    List<Object> dataset = null;
    private RecyclerView rv;
    private ViewPager viewpager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal", R.drawable.hannibal);
        file_maps.put("Big Bang Theory", R.drawable.bigbang);
        file_maps.put("House of Cards", R.drawable.house);

        dataset = new ArrayList<>();
        dataset.add(new Destacado(1,"hola",null));
        dataset.add(new Pyme(1,"Pyme 1", "url"));
        dataset.add(new Pyme(2,"Pyme 2", "url"));
        dataset.add(new Pyme(3,"Pyme 3", "url"));
        dataset.add(new Pyme(4,"Pyme 4", "url"));

        //<editor-fold desc="SliderLayout">
/*        mDemoSlider = (SliderLayout)v.findViewById(R.id.slider);


        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Hannibal", R.drawable.hannibal);
        file_maps.put("Big Bang Theory", R.drawable.bigbang);
        file_maps.put("House of Cards", R.drawable.house);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(6000);
        //mDemoSlider.addOnPageChangeListener(this);*/
        //</editor-fold>

        final InicioAdaptador adaptador = new InicioAdaptador(dataset, file_maps, getActivity().getSupportFragmentManager(), getActivity());
        adaptador.setOnItemClickListener(this);
        rv = (RecyclerView)v.findViewById(R.id.inicio_RecView);


        //rv.setLayoutManager(new GridLayoutManager(getActivity(),2));

        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? 2 : 1;
            }
        });

        rv.setLayoutManager(manager);
        rv.setHasFixedSize(true);
        rv.setAdapter(adaptador);
        return v;
    }
    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        //mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onResume() {
        //mDemoSlider.startAutoCycle();
        super.onResume();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //Toast.makeText(getActivity(),slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_inicio, menu);
        super.onCreateOptionsMenu(menu, inflater);

/*        final MenuItem item = menu.findItem(R.id.pyme_filter);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);*/
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onItemClick(View view, Pyme pyme, int position) {

    }
}


