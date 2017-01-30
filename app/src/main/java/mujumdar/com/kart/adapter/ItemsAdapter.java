package mujumdar.com.kart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import mujumdar.com.kart.R;

/**
 * Created by Omkar on 1/31/2017.
 */

public class ItemsAdapter extends ArrayAdapter<ItemDataModel> {
    private ArrayList<ItemDataModel> m_items;
    Context m_context;

    private static class ViewHolder {
        TextView itemName;
        TextView itemValue;
    }

    public ItemsAdapter(ArrayList<ItemDataModel> items, Context context) {
        super(context, R.layout.item_list_layout, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemDataModel dataModel = getItem(position);
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_list_layout, parent, false);
            viewHolder.itemName = (TextView) convertView.findViewById(R.id.itemName);
            viewHolder.itemValue= (TextView) convertView.findViewById(R.id.itemValue);
            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.itemName.setText(dataModel.getItemName());
        viewHolder.itemValue.setText(dataModel.getItemValue());

        return convertView;
    }
}
