package sv.edu.catolica.booklore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cotizaciones extends AppCompatActivity {
    public Button btn;
    public EditText edt1, edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizaciones);

        btn = (findViewById(R.id.btncotizar));
        edt1 = (findViewById(R.id.edtprecio));
        edt1 = (findViewById(R.id.edtnombrecotizaciones));


    }

    public void Veridico(View V) {
        if (edt1.equals("") || edt2.equals("")) {
            edt1.setText("Error no puede haber campos vacios");
            edt2.setText("Error no puede haber campos vacios");
            edt1.setText("");
            edt2.setText("");

        } else {
            Toast.makeText(getApplicationContext(), "Libro Cotizado", Toast.LENGTH_LONG).show();
            edt1.setText("");
            edt2.setText("");

        }

    }
}
