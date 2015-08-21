package elias.app.enchiloe;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import elias.app.adaptadores.PymeListaAdaptador;
import elias.app.modelos.Pyme;

public class ActividadListaPymes extends AppCompatActivity implements PymeListaAdaptador.OnItemClickListener{

    private PymeListaAdaptador adaptador;
    ArrayList<Pyme> dataset = null;
    private RecyclerView rv;
    private Spinner sp;
    private String cat_nombre;
    private int cat_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_lista_pymes);

        Bundle extras = getIntent().getExtras();
        cat_nombre = extras.getString("cat_nombre");
        cat_id = extras.getInt("cat_id");
        setToolbar();
        getPymes();



    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_pyme_list);
        toolbar.setTitle(cat_nombre);
        setSupportActionBar(toolbar);

    }

    private void setAdapter()
    {
        if(dataset != null)
        {
            adaptador = new PymeListaAdaptador(dataset);
            adaptador.setOnItemClickListener(this);
            rv = (RecyclerView)findViewById(R.id.recView_pymes);
            rv.setHasFixedSize(true);
            rv.setAdapter(adaptador);
            rv.setItemAnimator(new DefaultItemAnimator());
            rv.setLayoutManager(
                    new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        }
    }

    private void getPymes() {

        String URL = "http://192.168.50.14:8000/api/v1/pyme?cat="+cat_id;
        Log.e("URL", URL);
        RequestQueue queue = Volley.newRequestQueue(this);
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Cargando...");
        pDialog.show();

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, URL, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                Log.e("respuesta OK", response.toString());
                dataset = parser(response);
                setAdapter();
                pDialog.hide();

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Respuesta Bad", error.getCause().toString());
                dataset = null;
                pDialog.hide();
            }
        });

        queue.add(req);
    }


    private ArrayList<Pyme> parser(JSONObject response) {

        ArrayList<Pyme> aux = new ArrayList<>();
        JSONArray data;



            try {
                data = (JSONArray) response.getJSONArray("data");
                Log.d("array", data.toString());
                for(int i=0; i<data.length(); i++) {

                    Pyme p = new Pyme();
                    JSONObject object = (JSONObject) data.get(i);
                    //Log.d("->", object.toString());
                    p.setId(object.getInt("id"));
                    p.setNombre(object.getString("nombre"));
                    p.setDireccion(object.getString("direccion"));
                    p.setTelefono(object.getString("telefono"));
                    p.setEmail(object.getString("email"));
                    p.setUrl_imagen(object.getString("url_imagen"));
                    p.setDescripcion_corta(object.getString("descripcion_corta"));
                    p.setDescripcion_larga(object.getString("descripcion_larga"));
                    p.setComuna(object.getJSONObject("comuna").getString("nombre"));
                    //Log.e("geodato",object.getString("geo_posicion"));
                    if(!object.getString("geo_posicion").equals("null")){
                        p.setLatitud(object.getJSONObject("geo_posicion").getDouble("lat"));
                        p.setLongitud(object.getJSONObject("geo_posicion").getDouble("lng"));
                    }
                    aux.add(p);
                }

            }catch (JSONException e){
                e.printStackTrace();
            }



        return aux;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_pymes, menu);
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

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, Pyme p, int position) {
        //Toast.makeText(this, "pulsaste la pyme de id:" + pyme.getId(),Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,ActividadFicha.class);
        i.putExtra("id", p.getId());
        i.putExtra("nombre",p.getNombre());
        i.putExtra("direccion", p.getDireccion());
        i.putExtra("telefono", p.getTelefono());
        i.putExtra("email", p.getEmail());
        i.putExtra("descripcion_larga", p.getDescripcion_larga());
        i.putExtra("latitud", p.getLatitud());
        i.putExtra("longitud", p.getLongitud());
        startActivity(i);


    }
}
