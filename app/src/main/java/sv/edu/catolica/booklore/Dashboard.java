package sv.edu.catolica.booklore;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

import sv.edu.catolica.booklore.SQLite.Sesiones;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private CustomListAdapter adapter;
    private Sesiones session;
    private String nombre_usuario;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        session = new Sesiones(getApplicationContext());
        nombre_usuario = session.getUserName();
        password = session.getPassword();

        Resources res = getResources();
        TabHost control = findViewById(R.id.tabhost);
        control.setup();

        TabHost.TabSpec spec = control.newTabSpec("Principal");
        spec.setContent(R.id.publicos);
        spec.setIndicator("Principal",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);

        spec = control.newTabSpec("Leyendo");
        spec.setContent(R.id.mis_grupos);
        spec.setIndicator("Leyendo",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);

        spec = control.newTabSpec("PorLeer");
        spec.setContent(R.id.buscar_grupo);
        spec.setIndicator("Por Leer",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);



        spec = control.newTabSpec("Whishlist");
        spec.setContent(R.id.Whishlist);
        spec.setIndicator("Whishlist",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);



        listView = findViewById(R.id.listapublica);
        adapter = new CustomListAdapter(this,getarrayitems());
        listView.setAdapter(adapter);

        listView = findViewById(R.id.listapublica2);
        adapter = new CustomListAdapter(this,getarrayitems());
        listView.setAdapter(adapter);

        listView = findViewById(R.id.listapublica1);
        adapter = new CustomListAdapter(this,getarrayitems());
        listView.setAdapter(adapter);



        listView = findViewById(R.id.listapublica4);
        adapter = new CustomListAdapter(this,getarrayitems());
        listView.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private ArrayList<DataModel> getarrayitems(){
        ArrayList<DataModel> listItems = new ArrayList<>();
        listItems.add(new DataModel("La torre oscura","4.5 Estrellas",R.drawable.portada1));
        listItems.add(new DataModel("Mago y Cristal","5 Estrellas",R.drawable.portada2));
        listItems.add(new DataModel("Lobos del calla","4.0 Estrellas",R.drawable.portada3));
        listItems.add(new DataModel("Hechicero","3.9 Estrellas",R.drawable.portada6));

        return listItems;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
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
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.CrearGrupos) {

        } else if (id == R.id.area) {
            Intent inicio = new Intent(this,MiArea.class);
            startActivity(inicio);
        } else if (id == R.id.Librerias) {
            Intent inicio = new Intent(this,Librerias.class);
            startActivity(inicio);
        } else if (id == R.id.SalirGrupos) {

        } else if (id == R.id.AcercaDe) {
            Intent inicio = new Intent(this,Informacion.class);
            startActivity(inicio);
        } else if (id == R.id.Salir) {
            System.exit(0);
        }else if (id == R.id.grupos) {
            Intent grupos = new Intent(Dashboard.this,Grupos.class);
            startActivity(grupos);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
