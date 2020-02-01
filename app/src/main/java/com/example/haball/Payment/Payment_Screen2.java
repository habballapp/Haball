package com.example.haball.Payment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.example.haball.R;

public class Payment_Screen2 extends AppCompatActivity {


    private Button btn_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment__screen2);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        LayoutInflater inflater = LayoutInflater.from(this);

        View customView = inflater.inflate(R.layout.action_bar_main, null);

        bar.setCustomView(customView);
        bar.setDisplayShowCustomEnabled(true);
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        bar.setTitle("");
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.banking_channel);

        btn_update = findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Payment_Screen2.this, Payment_Screen3.class);
                startActivity(i);
            }
        });

        rl.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                final AlertDialog alertDialog = new AlertDialog.Builder(Payment_Screen2.this).create();
                LayoutInflater inflater = LayoutInflater.from(Payment_Screen2.this);
                View view_popup = inflater.inflate(R.layout.payment_details, null);
                alertDialog.setView(view_popup);
                ImageButton img_btn = view_popup.findViewById(R.id.image_button);
                img_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }

        });
    }
    }

