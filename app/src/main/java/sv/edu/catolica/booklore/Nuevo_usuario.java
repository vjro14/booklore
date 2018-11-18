package sv.edu.catolica.booklore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.catolica.booklore.SQLite.Crud;

public class Nuevo_usuario extends Activity {

    private EditText etUsuario, etClave, etConfClave;
    private Button btnRegistrar;
    private CheckBox chckTerminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_usuario);

        btnRegistrar = findViewById(R.id.enviar_datos);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarUsuario();
            }
        });
    }

    public void registrarUsuario(){
        //Obtener instancias de los controles
        etUsuario = findViewById(R.id.etUsuario);
        etClave = findViewById(R.id.etClave1);
        etConfClave = findViewById(R.id.etClave2);
        chckTerminos = findViewById(R.id.chkTerm);

        //Obtener los textos de los controles
        String usuario = etUsuario.getText().toString();
        String clave1 = etClave.getText().toString();
        String clave2 = etConfClave.getText().toString();
        boolean marcado = chckTerminos.isChecked();

        //Validaciones de Entradas de Texto
        int flag = 0;

        //Paso 1: controles vacíos
        if(usuario.isEmpty()){
            Toast.makeText(this,"Ingrese nombre de Usuario",Toast.LENGTH_SHORT).show();
            flag++;
        }else if(clave1.isEmpty()){
            Toast.makeText(this,"Ingrese contraseña",Toast.LENGTH_SHORT).show();
            flag++;
        }else if(clave2.isEmpty()){
            Toast.makeText(this,"Confirme contraseña",Toast.LENGTH_SHORT).show();
            flag++;
        }else if(!marcado){
            Toast.makeText(this,"Acepte Términos y condiciones",Toast.LENGTH_SHORT).show();
            flag++;
        }else if(usuario.length() < 3 || usuario.length() > 20){
            Toast.makeText(this,"El usuario debe tener entre 3 y 20 caracteres",Toast.LENGTH_SHORT).show();
            flag++;
        }else if(clave1.length() < 8 || clave1.length() > 20){
            Toast.makeText(this,"La contraseña debe tener entre 8 y 20 caracteres",Toast.LENGTH_SHORT).show();
            flag++;
        }else if(!clave1.equals(clave2)){
            Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show();
            flag++;
        }

        //Paso 2: Si pasa la validación, procedemos a insertar
        if(flag == 0) {
            Crud crud = new Crud(this);

            String[] campos = {"username","contrasena","id_rol"};
            String[] valores = {usuario,clave1,"1"};

            //Antes de hacer la inserción, hacemos la consulta para saber
            //Si el usuario ya existe
            int existe = crud.Select("logueo","username='"+usuario+"'").getCount();

            if(existe > 0){
                Toast.makeText(this,"Ya existe un usuario con ese nombre",Toast.LENGTH_LONG).show();
            }else{
                crud = new Crud(this);
                long resultado = crud.Insert("logueo",campos,valores);
                if(resultado > 0){
                    Toast.makeText(this,"Usuario creado correctamente",Toast.LENGTH_SHORT).show();
                    etUsuario.setText("");
                    etConfClave.setText("");
                    etClave.setText("");
                    chckTerminos.setChecked(false);

                    Intent login = new Intent(getApplicationContext(),Login.class);
                    startActivity(login);
                }else
                {
                    Toast.makeText(this,"Ocurrió un error al crear el usuario",Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}
