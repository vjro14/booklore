package sv.edu.catolica.booklore;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

import sv.edu.catolica.booklore.SQLite.Crud;

public class MiArea extends AppCompatActivity {

    private ListView listLeyendo,listLeidos,listPorleer,listWishlist;
    private CustomListAdapterPublicos adapter;
    Crud crud;
    String idli,nombre,portada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_area);
        Resources res = getResources();
        TabHost control = findViewById(R.id.tabhost);
        control.setup();
        crud=new Crud(MiArea.this);
        idli="";
        nombre="";
        portada="";
        TabHost.TabSpec spec = control.newTabSpec("Leyendo");
        spec.setContent(R.id.leyendo);
        spec.setIndicator("Leyendo",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);
        //String [] val={"portada"};
        //String [] para={"https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"};
        //crud.Insert("libro",val,para);

        spec = control.newTabSpec("Leidos");
        spec.setContent(R.id.leidos);
        spec.setIndicator("Leidos",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);

        spec = control.newTabSpec("Whishlist");
        spec.setContent(R.id.whishlist);
        spec.setIndicator("WhishList",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);

        listLeyendo = findViewById(R.id.listaleyendo);
        adapter = new CustomListAdapterPublicos(this,getarrayitemsLeyendo());
        listLeyendo.setAdapter(adapter);

        listLeidos = findViewById(R.id.listaliedos);
        adapter = new CustomListAdapterPublicos(this,getarrayitemsLeidos());
        listLeidos.setAdapter(adapter);


        listWishlist = findViewById(R.id.listawhishlist);
        adapter = new CustomListAdapterPublicos(this,getarrayitemsWhishlist());
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


    private ArrayList<DataModelListaPublicos> getarrayitemsLeyendo(){
        ArrayList<DataModelListaPublicos> listItems = new ArrayList<>();
        Cursor userbd = crud.Select("libro","");

        if(userbd.moveToFirst()){
            portada=userbd.getString(userbd.getColumnIndex("portada"));

            listItems.add(new DataModelListaPublicos(portada));

        }

        return listItems;
    }
    private ArrayList<DataModelListaPublicos> getarrayitemsLeidos(){
        ArrayList<DataModelListaPublicos> listItems = new ArrayList<>();
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));

        return listItems;
    }
    private ArrayList<DataModelListaPublicos> getarrayitemsPorleer(){
        ArrayList<DataModelListaPublicos> listItems = new ArrayList<>();
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));

        return listItems;
    }
    private ArrayList<DataModelListaPublicos> getarrayitemsWhishlist(){
        ArrayList<DataModelListaPublicos> listItems = new ArrayList<>();
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));

        return listItems;
    }


}
