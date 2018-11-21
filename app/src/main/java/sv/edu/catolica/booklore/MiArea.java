package sv.edu.catolica.booklore;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MiArea extends AppCompatActivity {

    private ListView listLeyendo,listLeidos,listPorleer,listWishlist;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_area);
        Resources res = getResources();
        TabHost control = findViewById(R.id.tabhost);
        control.setup();

        TabHost.TabSpec spec = control.newTabSpec("Leyendo");
        spec.setContent(R.id.leyendo);
        spec.setIndicator("Leyendo",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);


        spec = control.newTabSpec("Leidos");
        spec.setContent(R.id.leidos);
        spec.setIndicator("Leidos",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);

        spec = control.newTabSpec("Whishlist");
        spec.setContent(R.id.whishlist);
        spec.setIndicator("WhishList",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);

        listLeyendo = findViewById(R.id.listaleyendo);
        adapter = new CustomListAdapter(this,getarrayitemsLeyendo());
        listLeyendo.setAdapter(adapter);

        listLeidos = findViewById(R.id.listaliedos);
        adapter = new CustomListAdapter(this,getarrayitemsLeidos());
        listLeidos.setAdapter(adapter);


        listWishlist = findViewById(R.id.listawhishlist);
        adapter = new CustomListAdapter(this,getarrayitemsWhishlist());
        listWishlist.setAdapter(adapter);


        listLeyendo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inicio = new Intent(MiArea.this,Leyendo.class);
                startActivity(inicio);
            }
        });

        listLeidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inicio = new Intent(MiArea.this,Leidos.class);
                startActivity(inicio);
            }
        });
        listWishlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*String selected = ((TextView) view.findViewById(R.id.identificador)).getText().toString();
                Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_LONG).show();*/
                Intent intento = new Intent(MiArea.this,LibreriaWishlist.class);
                startActivity(intento);
            }
        });
    }

    private ArrayList<DataModel> getarrayitemsLeyendo(){
        ArrayList<DataModel> listItems = new ArrayList<>();
        listItems.add(new DataModel("La torre oscura","1",R.drawable.portada1));

        return listItems;
    }
    private ArrayList<DataModel> getarrayitemsLeidos(){
        ArrayList<DataModel> listItems = new ArrayList<>();
        listItems.add(new DataModel("Lobos del calla","3",R.drawable.portada3));
        listItems.add(new DataModel("Hechicero","4",R.drawable.portada6));

        return listItems;
    }
    private ArrayList<DataModel> getarrayitemsPorleer(){
        ArrayList<DataModel> listItems = new ArrayList<>();
        listItems.add(new DataModel("Hechicero","4",R.drawable.portada6));

        return listItems;
    }
    private ArrayList<DataModel> getarrayitemsWhishlist(){
        ArrayList<DataModel> listItems = new ArrayList<>();
        listItems.add(new DataModel("La torre oscura","1",R.drawable.portada1));
        listItems.add(new DataModel("Mago y Cristal","2",R.drawable.portada2));
        listItems.add(new DataModel("Lobos del calla","3",R.drawable.portada3));
        listItems.add(new DataModel("Hechicero","4",R.drawable.portada6));

        return listItems;
    }


}
