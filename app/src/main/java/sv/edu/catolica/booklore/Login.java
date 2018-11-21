package sv.edu.catolica.booklore;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.catolica.booklore.SQLite.Crud;
import sv.edu.catolica.booklore.SQLite.Sesiones;


public class Login extends Activity {

    EditText etUsuario, etClave;
    private Sesiones sessiones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        etUsuario = findViewById(R.id.tvuser);
        etClave = findViewById(R.id.tvpass);
        sessiones = new Sesiones(getApplicationContext());

        if(!sessiones.getUserName().isEmpty() && !sessiones.getPassword().isEmpty()){
            Intent inicio = new Intent(Login.this,Dashboard.class);
            startActivity(inicio);
        }
    }

    public void IniciarSesion(View v){

        String usuario = etUsuario.getText().toString();
        String clave = etClave.getText().toString();

        int flag = 0;
        if(usuario.isEmpty() || clave.isEmpty()){
            Toast.makeText(Login.this,"Complete los campos para continuar",Toast.LENGTH_SHORT).show();
            flag++;
        }

        String claveReal;

        if(flag == 0){
            Crud crud = new Crud(Login.this);
            Cursor userbd = crud.Select("logueo","username='"+usuario+"'");
            int existe = userbd.getCount();
            if(existe == 0){
                Toast.makeText(this,"El usuario no ha sido registrado aún",Toast.LENGTH_SHORT).show();
            } else {
                //Sacar los datos de la consulta
                if(userbd.moveToFirst()){
                    claveReal = userbd.getString(userbd.getColumnIndex("contrasena"));

                    if(clave.equals(claveReal)){
                        //Llenamos las variables de sesion
                        etUsuario.setText("");
                        etClave.setText("");

                        sessiones.setPassword(claveReal);
                        sessiones.setUserName(usuario);
                         Intent inicio = new Intent(Login.this,Dashboard.class);
                        startActivity(inicio);
                    } else {
                        Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }

    public void registro(View v)
    {
        Intent register = new Intent(Login.this,Nuevo_usuario.class);
        startActivity(register);
    }
}
