package sv.edu.catolica.booklore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapterPuntuacones extends BaseAdapter {
    private Context context;
    private ArrayList<DataModelPuntuaciones> ListItems;

    public CustomListAdapterPuntuacones(Context context, ArrayList<DataModelPuntuaciones> listItems) {
        this.context = context;
        ListItems = listItems;
    }

    @Override
    public int getCount() {
        return ListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return ListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataModelPuntuaciones item = (DataModelPuntuaciones) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.puntuaciones,null);
        TextView critico = convertView.findViewById(R.id.critico);
        RatingBar estrellas = convertView.findViewById(R.id.notas);

        critico.setText(item.Persona);
        estrellas.setRating(item.Calificacion);
        return convertView;
    }
}
