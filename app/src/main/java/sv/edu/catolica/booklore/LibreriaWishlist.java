package sv.edu.catolica.booklore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LibreriaWishlist extends AppCompatActivity {

    public Button btn;
    public TextView tvTit,tvDesc;
    public ImageView ivPort;
    public String port,tit,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libreria_wishlist);

        tvTit=findViewById(R.id.tvTitulo);
        tvDesc=findViewById(R.id.tvDescripcion);
        ivPort=findViewById(R.id.ivPortada);

        if(port.equals("") || tit.equals("") || desc.equals("")){
            tvTit.setText(R.string.TituloNo);
            tvDesc.setText(R.string.DescripcionNo);
            ivPort.setImageResource(R.drawable.error);
        }

        btn=findViewById(R.id.btnMapa);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(LibreriaWishlist.this,LibreriaMapa.class);
                startActivity(intento);
            }
        });
    }
}
