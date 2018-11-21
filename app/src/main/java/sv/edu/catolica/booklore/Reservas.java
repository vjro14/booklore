package sv.edu.catolica.booklore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reservas extends AppCompatActivity {

    public Button btn;
    public EditText edt1, edt2, edt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);


        btn = (findViewById(R.id.btnaceptarReserva));
        edt1 = (findViewById(R.id.edtprezy));
        edt2 = (findViewById(R.id.edtnom));
        edt3 = (findViewById(R.id.edtquantity));

    }

    public void veraz(View V) {
        if (edt1.equals("") || edt2.equals("") || edt3.equals("")) {
            edt1.setText("Error no puede haber campos vacios");
            edt2.setText("Error no puede haber campos vacios");
            edt3.setText("Error no puede haber campos vacios");
            edt1.setText("");
            edt2.setText("");
            edt3.setText("");

        } else{
            Toast.makeText(getApplicationContext(), "Libro Reservado", Toast.LENGTH_LONG).show();
            edt1.setText("");
            edt2.setText("");
            edt3.setText("");

        }

    }
}