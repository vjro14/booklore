package sv.edu.catolica.booklore;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class Leyendo extends AppCompatActivity {

    private ListView listafrases,listapuntuacion;
    private CustomListAdapterFrases adapter;
    private CustomListAdapterPuntuacones adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leyendo);

        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        series.setTitle("Random Curve 1");
        series.setColor(Color.GREEN);
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(10);
        series.setThickness(8);

        // custom paint to make a dotted line
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setPathEffect(new DashPathEffect(new float[]{8, 5}, 0));
        series.setCustomPaint(paint);
        graph.addSeries(series);

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
        listItems.add(new DataModelPuntuaciones(Float.parseFloat("5.0"),"Elmer Figueroa"));

        return listItems;
    }
}
