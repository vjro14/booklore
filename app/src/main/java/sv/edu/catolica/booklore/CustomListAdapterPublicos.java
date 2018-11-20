package sv.edu.catolica.booklore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListAdapterPublicos extends BaseAdapter {
    private Context context;
    private ArrayList<DataModelListaPublicos> ListItems;

    public CustomListAdapterPublicos(Context context, ArrayList<DataModelListaPublicos> listItems) {
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
        DataModelListaPublicos item = (DataModelListaPublicos) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.grupospublicos,null);
        ImageView imagen = convertView.findViewById(R.id.imagen);
        Picasso.with(context).load(item.getURL()).into(imagen);

        return convertView;
    }
}
