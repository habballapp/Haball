package com.example.haball.Distribution_Login;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.haball.Distributor.DistributorDashboard;
import com.example.haball.R;
import com.example.haball.Registration.Registration_Activity;
import com.example.haball.Support.Support_dashboard;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Distribution_Login extends AppCompatActivity {

    private Button btn_login,btn_signup,btn_support,btn_password,btn_reset;
    public ImageButton btn_back;
    private Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distribution__login);
        getWindow().setBackgroundDrawableResource(R.drawable.background_logo);

        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_signup);
        btn_support = findViewById(R.id.btn_support);
        btn_password = findViewById(R.id.btn_password);
        btn_back = (ImageButton)findViewById(R.id.btn_back);


//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowHomeEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(false);
//
//
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View customView = inflater.inflate(R.layout.actio   n_bar_main, null);
//
//        actionBar.setCustomView(customView);
//        actionBar.setDisplayShowCustomEnabled(true);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));

        LayoutInflater inflater = LayoutInflater.from(this);

        View customView = inflater.inflate(R.layout.action_bar_main, null);

        bar.setCustomView(customView);
        bar.setDisplayShowCustomEnabled(true);
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        bar.setTitle("");
//         btn_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Distribution_Login.this, DistributorDashboard.class);
                startActivity(intent);
            }
        });
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Distribution_Login.this, Registration_Activity.class);
                startActivity(intent);
            }
        });
        btn_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Distribution_Login.this, Support_dashboard.class);
                startActivity(intent);
            }
        });

        btn_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog alertDialog = new AlertDialog.Builder(Distribution_Login.this).create();
                LayoutInflater inflater = LayoutInflater.from(Distribution_Login.this);
                View view_popup = inflater.inflate(R.layout.forget_password, null);
                alertDialog.setView(view_popup);
                btn_reset = view_popup.findViewById(R.id.btn_reset);
                ImageButton img_btn = view_popup.findViewById(R.id.image_button);
                btn_reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        final AlertDialog alertDialog1 = new AlertDialog.Builder(Distribution_Login.this).create();
                        LayoutInflater inflater = LayoutInflater.from(Distribution_Login.this);
                        View view_popup = inflater.inflate(R.layout.email_sent, null);
                        alertDialog1.setView(view_popup);
                        ImageButton img_email = view_popup.findViewById(R.id.image_email);
                        img_email.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog1.dismiss();
                            }
                        });
                        alertDialog1.show();

                    }
                });
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
