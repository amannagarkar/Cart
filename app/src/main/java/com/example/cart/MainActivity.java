package com.example.cart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView menulist;
    ArrayList<MenuCard> menu = new ArrayList<>();
    CustomAdapter foodAdapter;
    MenuCard item1;







    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        menulist = findViewById(R.id.menu_list);
        foodAdapter = new CustomAdapter(menu,getApplicationContext());
        menulist.setAdapter(foodAdapter);
        item1 = new MenuCard("Chicken Burger", "Rs. 100", "Non-Veg.");
        menu.add(item1);

        menulist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {

                    if (position==0) {
                        Intent intent = new Intent(MainActivity.this, editcart.class);
                        startActivity(intent);

                    }

            }
        });

    }
}
