package sv.edu.catolica.booklore;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class dashboard_tablas extends AppCompatActivity {

    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_tablas);
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

        spec = control.newTabSpec("Leidos");
        spec.setContent(R.id.Porleer);
        spec.setIndicator("Leidos",res.getDrawable(R.drawable.portada6));
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

        listView = findViewById(R.id.listapublica3);
        adapter = new CustomListAdapter(this,getarrayitems());
        listView.setAdapter(adapter);

        listView = findViewById(R.id.listapublica4);
        adapter = new CustomListAdapter(this,getarrayitems());
        listView.setAdapter(adapter);
    }

    private ArrayList<DataModel> getarrayitems(){
        ArrayList<DataModel> listItems = new ArrayList<>();
        listItems.add(new DataModel("La torre oscura","4.5 Estrellas",R.drawable.portada1));
        listItems.add(new DataModel("Mago y Cristal","5 Estrellas",R.drawable.portada2));
        listItems.add(new DataModel("Lobos del calla","4.0 Estrellas",R.drawable.portada3));
        listItems.add(new DataModel("Hechicero","3.9 Estrellas",R.drawable.portada6));

        return listItems;
    }
}
