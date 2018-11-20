package sv.edu.catolica.booklore;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InnerGroup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_group);

    }

    public void VerComentario(View v){
        Intent inicio = new Intent(this,Comentarios.class);
        startActivity(inicio);
    }

    public void AddComentario(View v){}

}
