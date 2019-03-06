package com.example.cart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView menulist;
    ArrayList<MenuCard> menu;
    CustomAdapter foodAdapter;
    CartAdapter cartAdapter;
    MenuCard item1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //menulist = findViewById(R.id.menu_list);
        //menulist.setClickable(true);
        item1 = new MenuCard("Chicken Burger", "Rs. 100", "Non-Veg.");
        menu = new ArrayList<>();
        menu.add(item1);
        item1 = new MenuCard("Veg Burger", "Rs. 80", "Veg.");
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




        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_cart);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        cartAdapter = new CartAdapter(getApplicationContext(),menu);
        recyclerView.setAdapter(cartAdapter); // set the Adapter to RecyclerView


    }




}
