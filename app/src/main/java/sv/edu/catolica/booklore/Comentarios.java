package sv.edu.catolica.booklore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Comentarios extends AppCompatActivity {

    ListView lista;
    CustomListAdapterFrases adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);
        lista=findViewById(R.id.LvComentario);
        adapter = new CustomListAdapterFrases(this,getarrayitemsPorleer());
        lista.setAdapter(adapter);
    }

    private ArrayList<DataModelFrases> getarrayitemsPorleer(){
        ArrayList<DataModelFrases> listItems = new ArrayList<>();
        listItems.add(new DataModelFrases("En la vida hay cuatro constantes: la vida, la muerte, el proposito y el azar","Elmer Figueroa"));
        listItems.add(new DataModelFrases("En la vida hay cuatro constantes: la vida, la muerte, el proposito y el azar","Elmer Figueroa"));
        listItems.add(new DataModelFrases("En la vida hay cuatro constantes: la vida, la muerte, el proposito y el azar","Elmer Figueroa"));
        listItems.add(new DataModelFrases("En la vida hay cuatro constantes: la vida, la muerte, el proposito y el azar","Elmer Figueroa"));

        return listItems;
    }
}
