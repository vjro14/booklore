package sv.edu.catolica.booklore;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;


public class Leidos extends Activity {

    RatingBar ratingBar;
    private ListView listafrases,listapuntuacion;
    private CustomListAdapterFrases adapter;
    private CustomListAdapterPuntuacones adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leidos);
        GraphView graph = findViewById(R.id.graph);

        ratingBar = findViewById(R.id.star);
        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.CYAN, PorterDuff.Mode.SRC_ATOP);

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(1, 10),
                new DataPoint(2, 5),
                new DataPoint(3, 1),
                new DataPoint(4, 25),
                new DataPoint(5, 50)
        });
        graph.addSeries(series);

// styling
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        series.setSpacing(50);

// draw values on top
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.RED);
//series.setValuesOnTopSize(50);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                float a = ratingBar.getRating();
                Toast.makeText(getApplicationContext(),"Su seleccion de "+a,Toast.LENGTH_LONG).show();
            }
        });

        listafrases = findViewById(R.id.Frases);
        adapter = new CustomListAdapterFrases(this,getarrayitemsPorleer());
        listafrases.setAdapter(adapter);

        listapuntuacion = findViewById(R.id.Puntuacion);
        adapter2 = new CustomListAdapterPuntuacones(this,getarrayitemsPuntuaciones());
        listapuntuacion.setAdapter(adapter2);

    }

    private ArrayList<DataModelFrases> getarrayitemsPorleer(){
        ArrayList<DataModelFrases> listItems = new ArrayList<>();
        listItems.add(new DataModelFrases("En la vida hay cuatro constantes: la vida, la muerte, el proposito y el azar","Elmer Figueroa"));
        listItems.add(new DataModelFrases("En la vida hay cuatro constantes: la vida, la muerte, el proposito y el azar","Elmer Figueroa"));
        listItems.add(new DataModelFrases("En la vida hay cuatro constantes: la vida, la muerte, el proposito y el azar","Elmer Figueroa"));
        listItems.add(new DataModelFrases("En la vida hay cuatro constantes: la vida, la muerte, el proposito y el azar","Elmer Figueroa"));

        return listItems;
    }

    private ArrayList<DataModelPuntuaciones> getarrayitemsPuntuaciones(){
        ArrayList<DataModelPuntuaciones> listItems = new ArrayList<>();
        listItems.add(new DataModelPuntuaciones(Float.parseFloat("5.0"),"Elmer Figueroa"));
        listItems.add(new DataModelPuntuaciones(Float.parseFloat("1.0"),"Elmer Figueroa"));
        listItems.add(new DataModelPuntuaciones(Float.parseFloat("3.0"),"Elmer Figueroa"));
        listItems.add(new DataModelPuntuaciones(Float.parseFloat("4.0"),"Elmer Figueroa"));
        listItems.add(new DataModelPuntuaciones(Float.parseFloat("5" +
                ".0"),"Elmer Figueroa"));

        return listItems;
    }


}
