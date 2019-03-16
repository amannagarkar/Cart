package com.example.cart;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements CartAdapter.OnItemClickListener
 {

    ListView menulist;
    ArrayList<MenuCard> menu;
    CustomAdapter foodAdapter;
    CartAdapter cartAdapter;
    MenuCard item1;
    TextView total;
    Button order_place;
     RecyclerView recyclerView;
     private CartAdapter.OnItemClickListener listener;
     int amount_total;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total=(TextView)findViewById(R.id.amount_cart);
        order_place=(Button)findViewById(R.id.button_place_order);

        //menulist = findViewById(R.id.menu_list);
        //menulist.setClickable(true);
        item1 = new MenuCard("Chicken Burger", "100", "Non-Veg.");
        menu = new ArrayList<>();
        menu.add(item1);
        item1 = new MenuCard("Veg Burger", "80", "Veg.","2");
        menu.add(item1);

       /* foodAdapter = new CustomAdapter(menu,getApplicationContext());
        menulist.setAdapter(foodAdapter);

        menulist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(view.getContext(),editcart.class);
                startActivity(intent);
            }
        }); */




        recyclerView = (RecyclerView) findViewById(R.id.recycler_cart);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        listener=this;
        cartAdapter = new CartAdapter(getApplicationContext(),menu,listener);
        recyclerView.setAdapter(cartAdapter); // set the Adapter to RecyclerView


        set_total();


        order_place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PlaceOrder.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("order_list",menu);
                bundle.putSerializable("total",amount_total);
                intent.putExtras(bundle);
                startActivity(intent);
                //showNumberPicker(v);
            }
        });




    }

    public void set_total()
    {
        amount_total=0;
        for(int i=0;i<menu.size();i++)
            amount_total=amount_total+(Integer.parseInt(menu.get(i).food_cost)*Integer.parseInt(menu.get(i).quantity));
        total.setText("Total : "+String.valueOf(amount_total));
    }


     public void showNumberPicker(View view,int id,int qty){
         DialogBox newFragment = new DialogBox();
         newFragment.set(id,qty);
         //newFragment.setValueChangeListener(view.get);
         newFragment.show(getSupportFragmentManager(), "time picker");
     }


     public void doPositiveClick(int id,int val) {
         // Do stuff here.
         Log.i("FragmentAlertDialog", "Positive click!");
         Toast.makeText(getApplicationContext(),"ID : "+String.valueOf(id)+" Val : "+String.valueOf(val),Toast.LENGTH_SHORT).show();
         menu.get(id).quantity=String.valueOf(val);

         cartAdapter = new CartAdapter(getApplicationContext(),menu,listener);
         recyclerView.setAdapter(cartAdapter);
         set_total();
     }

     public void doNegativeClick() {
         // Do stuff here.
         Log.i("FragmentAlertDialog", "Negative click!");
     }

 }
