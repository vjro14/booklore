package sv.edu.catolica.booklore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class Librerias extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librerias);
        GraphView graph = findViewById(R.id.graph2);

        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);




    }
    private void reserva (View V){
        Intent intento = new Intent(this,Reservas.class);
        startActivity(intento);

    }

    private void cotizaciones (View V){
        Intent intento = new Intent(this,Cotizaciones.class);
        startActivity(intento);

    }
}



