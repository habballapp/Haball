package com.example.haball.Payment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.haball.R;

public class Payment_Screen1 extends AppCompatActivity {

    private Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__screen1);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        LayoutInflater inflater = LayoutInflater.from(this);

        View customView = inflater.inflate(R.layout.action_bar_main, null);

        bar.setCustomView(customView);
        bar.setDisplayShowCustomEnabled(true);
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        bar.setTitle("");

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Payment_Screen1.this, Payment_Screen2.class);
                startActivity(i);
            }
        });
    }
}
