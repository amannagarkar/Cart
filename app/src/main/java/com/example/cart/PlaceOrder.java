package com.example.cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlaceOrder extends AppCompatActivity implements CartAdapter.OnItemClickListener {

    ArrayList<MenuCard> arrayList;
    RecyclerView recyclerView;
    CartAdapter cartAdapter;
    int amount_total;
    TextView textView;
    private CartAdapter.OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        arrayList=(ArrayList<MenuCard>) getIntent().getSerializableExtra("order_list");
        amount_total=(int)getIntent().getSerializableExtra("total");

        recyclerView=(RecyclerView)findViewById(R.id.recycler_cart);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        listener=this;
        cartAdapter=new CartAdapter(getApplicationContext(),arrayList,listener);
        recyclerView.setAdapter(cartAdapter);

        textView=(TextView)findViewById(R.id.amount_order_text);
        textView.setText("Total Amount : "+amount_total);

        Toast.makeText(getApplicationContext(),"Make Payment",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNumberPicker(View v, int id, int qty) {

    }
}
