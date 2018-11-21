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

public class Grupos extends AppCompatActivity {

    private ListView listPubli,ListMio,ListBusc;
    private CustomListAdapterPublicos adapterpubli,adapterMio, adapterbuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grupos);
        Resources res = getResources();
        TabHost control = findViewById(R.id.Grupostabhost);
        control.setup();

        TabHost.TabSpec spec = control.newTabSpec("Grupos Publicos");
        spec.setContent(R.id.grupos_publicos);
        spec.setIndicator("Grupos Publicos",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);


        spec = control.newTabSpec("Mis Grupos");
        spec.setContent(R.id.Mis_Grupos);
        spec.setIndicator("Mis Grupos",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);

        spec = control.newTabSpec("Buscar Grupo");
        spec.setContent(R.id.buscar_grupo);
        spec.setIndicator("Buscar Grupo",res.getDrawable(R.drawable.portada6));
        control.addTab(spec);

        listPubli = findViewById(R.id.listapublicos);
        adapterpubli = new CustomListAdapterPublicos(this,getarrayitemsLeyendo());
        listPubli.setAdapter(adapterpubli);

        ListMio = findViewById(R.id.listmisgrupos);
        adapterMio = new CustomListAdapterPublicos(this,getarrayitemsMio());
        ListMio.setAdapter(adapterMio);

        ListBusc = findViewById(R.id.listabuscar);
        adapterbuscar = new CustomListAdapterPublicos(this,getarrayitemsBuscar());
        ListBusc.setAdapter(adapterbuscar);

        listPubli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent inicio = new Intent(Grupos.this,InnerGroup.class);
                startActivity(inicio);
            }
        });
    }

    private ArrayList<DataModelListaPublicos> getarrayitemsLeyendo(){
        ArrayList<DataModelListaPublicos> listItems = new ArrayList<>();
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));
        listItems.add(new DataModelListaPublicos("https://10images.cgames.de/images/gamestar/226/fallout-76-artwork-render_6034929.jpg"));

        return listItems;
    }
    private ArrayList<DataModelListaPublicos> getarrayitemsMio(){
        ArrayList<DataModelListaPublicos> listItems = new ArrayList<>();
        listItems.add(new DataModelListaPublicos("https://static.zerochan.net/Reiton-kyouju.full.691357.jpg"));
        listItems.add(new DataModelListaPublicos("https://static.zerochan.net/Reiton-kyouju.full.691357.jpg"));
        listItems.add(new DataModelListaPublicos("https://static.zerochan.net/Reiton-kyouju.full.691357.jpg"));

        return listItems;
    }

    private ArrayList<DataModelListaPublicos> getarrayitemsBuscar(){
        ArrayList<DataModelListaPublicos> listItems = new ArrayList<>();
        listItems.add(new DataModelListaPublicos("https://i.imgur.com/BavzNSy.jpg"));

        return listItems;
    }

    public void btnBuscar (View view){
        ListBusc.setVisibility(View.VISIBLE);
    }
}
