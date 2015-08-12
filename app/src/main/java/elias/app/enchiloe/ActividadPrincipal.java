package elias.app.enchiloe;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.content.res.ColorStateList;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import elias.app.adaptadores.MainPagerAdapter;
import elias.app.enchiloe.fragmentos.CategoriasFragment;
import elias.app.enchiloe.fragmentos.EventosFragment;
import elias.app.enchiloe.fragmentos.InicioFragment;


public class ActividadPrincipal extends AppCompatActivity implements ViewPager.OnPageChangeListener {

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
        pager.addOnPageChangeListener(this);
        pager.setAdapter(adapter);
        tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setBackgroundColor(getResources().getColor(R.color.color_primary));
        tabs.setTabTextColors(ColorStateList.valueOf(getResources().getColor(R.color.white)));
        tabs.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (pager.getCurrentItem()==1) {
            getMenuInflater().inflate(R.menu.menu_inicio, menu);
        }
        if (pager.getCurrentItem()==2) {
            getMenuInflater().inflate(R.menu.menu_eventos, menu);
        }

        //getMenuInflater().inflate(R.menu.menu_actividad_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.eventos_filter) {
            Intent a = new Intent(this, ActividadListaPymes.class);
            startActivity(a);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
       // Toast.makeText(this,"page "+i, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
