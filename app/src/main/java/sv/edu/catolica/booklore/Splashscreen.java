package sv.edu.catolica.booklore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.View;

public class Splashscreen extends Activity {

        private boolean botonBackPresionado = false;
        private static final int DURACION_SPLASH = 5000;
        @Override
        public void onBackPressed(){
            botonBackPresionado = true;
            super.onBackPressed();
            setTitle("");
            getActionBar().setIcon(R.drawable.pancarta);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splashscreen);
            Handler manejador = new Handler(){};
            manejador.postDelayed(new Runnable() {
                @Override
                public void run() {
                    finish();
                    if (!botonBackPresionado){
                        Intent intento = new Intent(Splashscreen.this,Login.class);
                        startActivity(intento);
                    }
                }
            },DURACION_SPLASH);
        }

    }

        //public void modgroup(View v){
        //    Intent intento = new Intent(this,elmer_part.class);
          //  startActivity(intento);
        //}

