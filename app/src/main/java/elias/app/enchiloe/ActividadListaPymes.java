package elias.app.enchiloe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

public class ActividadListaPymes extends AppCompatActivity {

    private ArrayList<Pyme> pymes;
    private RecyclerView rv;
    private Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_lista_pymes);

        setToolbar();
        getPymes();

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_pyme_list);
        setSupportActionBar(toolbar);

    }

    private void getPymes() {

        String URL = "http://192.168.50.14:8000/api/v1/pyme";

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest req = new JsonObjectRequest(URL, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                Log.d("respuesta OK", response.toString());
                ArrayList<Pyme> dataset =  new ArrayList<Pyme>();
                dataset = parser(response);
                final PymeListaAdaptador adaptador = new PymeListaAdaptador(dataset);
                setPymes(adaptador,dataset);

            }
        }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Respuesta Bad", error.getCause().toString());
            }
        });

        queue.add(req);
    }

    private void setPymes(PymeListaAdaptador adapter, ArrayList<Pyme> dataset) {

        rv = (RecyclerView)findViewById(R.id.recView_pymes);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        rv.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private ArrayList<Pyme> parser(JSONObject response) {

        ArrayList<Pyme> aux = new ArrayList<Pyme>();
        JSONArray data;



            try {
                data = (JSONArray) response.getJSONArray("data");
                Log.d("array", data.toString());
                for(int i=0; i<data.length(); i++) {

                    Pyme p = new Pyme();
                    JSONObject object = (JSONObject) data.get(i);
                    Log.d("->", object.toString());
                    p.setId(object.getInt("id"));
                    p.setNombre(object.getString("nombre"));
                    p.setDireccion(object.getString("direccion"));
                    p.setTelefono(object.getString("telefono"));
                    p.setEmail(object.getString("email"));
                    p.setUrl_imagen(object.getString("url_imagen"));
                    p.setDescripcion_corta(object.getString("descripcion_corta"));
                    p.setComuna(object.getJSONObject("comuna").getString("nombre"));
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
}
