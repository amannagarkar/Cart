package com.example.cart;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;

public class CartAdapter extends ArrayAdapter<MenuCard>{

    private ArrayList<MenuCard> menuCardsdata;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView foodName;
        TextView foodqnty;
        TextView foodCost;
        TextView foodtotal;
        Button Addbtn;
        Button Subbutton;


    }

    public CartAdapter(ArrayList<MenuCard> data, Context context) {
        super(context, R.layout.cart_item_layout, data);
        this.menuCardsdata = data;
        this.mContext=context;

    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MenuCard menuCard = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.cart_item_layout, parent, false);
            viewHolder.foodName = (TextView) convertView.findViewById(R.id.item_name);
            viewHolder.foodqnty = (TextView) convertView.findViewById(R.id.item_quantity);
            viewHolder.foodCost = (TextView) convertView.findViewById(R.id.item_cost);
            viewHolder.foodtotal = (TextView) convertView.findViewById(R.id.item_total);
            viewHolder.Addbtn = (Button) convertView.findViewById(R.id.add_btn);
            viewHolder.Subbutton = (Button) convertView.findViewById(R.id.sub_btn);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }


        int x = Integer.valueOf(R.id.item_cost);
        int y = Integer.valueOf(R.id.item_quantity);
        int amount = x * y;
        viewHolder.foodName.setText(menuCard.getFoodName());
        viewHolder.foodqnty.setText(menuCard.getFoodType());
        viewHolder.foodCost.setText(menuCard.getFoodCost());
        viewHolder.foodtotal.setText(amount);

        // Return the completed view to render on screen
        return convertView;
    }
}

