package com.example.haball.Order;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.haball.R;

public class DistributorOrder_OnaddtoCart extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_order__onaddto_cart);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        LayoutInflater inflater = LayoutInflater.from(this);
        View customView = inflater.inflate(R.layout.custom_actionbar, null);

        actionBar.setCustomView(customView);
        actionBar.setDisplayShowCustomEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rv_addtocart);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // specify an adapter (see also next example)
        mAdapter = new DistributorOrder_OnaddtoCartAdapter(DistributorOrder_OnaddtoCart.this,"AC Card Battery Charger","PKR1200.00");
        mAdapter = new DistributorOrder_OnaddtoCartAdapter(DistributorOrder_OnaddtoCart.this,"AC Card Battery Charger","PKR1200.00");

        recyclerView.setAdapter(mAdapter);




    }
}