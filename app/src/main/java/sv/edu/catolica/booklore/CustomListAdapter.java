package sv.edu.catolica.booklore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DataModel> ListItems;

    public CustomListAdapter(Context context, ArrayList<DataModel> listItems) {
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
        DataModel item = (DataModel) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.mylist,null);
        ImageView imgFoto = convertView.findViewById(R.id.imagen);
        TextView titulo = convertView.findViewById(R.id.Titulo);
        TextView id = convertView.findViewById(R.id.identificador);

        imgFoto.setImageResource(item.getImagen());
        titulo.setText(item.getTitulo());
        id.setText(item.getId());
        return convertView;
    }
}
