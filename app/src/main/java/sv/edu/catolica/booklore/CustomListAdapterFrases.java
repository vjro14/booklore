package sv.edu.catolica.booklore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapterFrases extends BaseAdapter {
    private Context context;
    private ArrayList<DataModelFrases> ListItems;

    public CustomListAdapterFrases(Context context, ArrayList<DataModelFrases> listItems) {
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
        DataModelFrases item = (DataModelFrases) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.frases,null);
        TextView titulo = convertView.findViewById(R.id.frase);
        TextView id = convertView.findViewById(R.id.autor);

        titulo.setText(item.getFrase());
        id.setText(item.getAutor());
        return convertView;
    }
}
