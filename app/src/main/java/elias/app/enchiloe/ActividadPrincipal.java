package elias.app.enchiloe;

import android.support.v4.app.Fragment;
import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

import elias.app.adaptadores.MainPagerAdapter;
import elias.app.enchiloe.fragmentos.CategoriasFragment;
import elias.app.enchiloe.fragmentos.EventosFragment;
import elias.app.enchiloe.fragmentos.InicioFragment;


public class ActividadPrincipal extends AppCompatActivity {

    Toolbar toolbar;
    private ViewPager pager;
    private TabLayout tabs;
    private ArrayList<Fragment> fragments;
    private MainPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragments = new ArrayList<Fragment>();
        fragments.add(new CategoriasFragment());
        fragments.add(new InicioFragment());
        fragments.add(new EventosFragment());
        adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);

        pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setBackgroundColor(getResources().getColor(R.color.color_primary));
        tabs.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        tabs.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad_principal, menu);
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
