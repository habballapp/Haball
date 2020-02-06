package com.example.haball.Distributor;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haball.Distributor.ui.home.HomeFragment;
import com.example.haball.Distributor.ui.main.OrdersFragment;
import com.example.haball.Distributor.ui.main.PaymentsFragment;
import com.example.haball.Distributor.ui.orders.Orders_Fragment;
import com.example.haball.Distributor.ui.payments.Payments_Fragment;
import com.example.haball.Distributor.ui.shipments.Shipments_Fragments;
import com.example.haball.Distributor.ui.support.SupportFragment;
import com.example.haball.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class DistributorDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private TextView tv_username;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_username = toolbar.findViewById(R.id.tv_username);
        tv_username.setText("abcd test");

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_orders, R.id.nav_payments,
                R.id.nav_shipments, R.id.nav_retailer, R.id.nav_profile,
                R.id.nav_support, R.id.nav_logout, R.id.nav_terms_and_conditions)
                .setDrawerLayout(drawer)
                .build();
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new HomeFragment());
        fragmentTransaction.commit();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        Log.i("item no. ", String.valueOf(item.getItemId()));
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new HomeFragment());
                        fragmentTransaction.commit();

                        item.setChecked(true);

                        break;
                    case R.id.nav_orders:
                        Log.i("item no. ", String.valueOf(item.getItemId()));

                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Orders_Fragment());
                        fragmentTransaction.commit();

                        item.setChecked(true);

                        break;
                    case R.id.nav_payments:
                        Log.i("item no. ", String.valueOf(item.getItemId()));
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Payments_Fragment());
                        fragmentTransaction.commit();

                        item.setChecked(true);

                        break;
                    case R.id.nav_support:
                        Log.i("item no. ", String.valueOf(item.getItemId()));
                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new SupportFragment());
                        fragmentTransaction.commit();

                        item.setChecked(true);

                        break;
                    case R.id.nav_shipments:

                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container,new Shipments_Fragments());
                        fragmentTransaction.commit();
                        item.setChecked(true);

                        break;

                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this,getSupportFragmentManager());
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.distributor_dashboard, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int position = menuItem.getItemId();
//        Toast.makeText(this,menuItem.getItemId(),Toast.LENGTH_LONG).show();
//        Fragment fragment;
//        FragmentManager fragmentManager = getSupportFragmentManager(); // For AppCompat use getSupportFragmentManager
        switch(position) {
            default:
            case R.id.nav_home:
                Toast.makeText(this,position,Toast.LENGTH_LONG).show();

                Fragment frag_home = new HomeFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.container, frag_home);
                transaction1.addToBackStack(null);
                transaction1.commit();
                break;
            case R.id.nav_orders:
                Toast.makeText(this,position,Toast.LENGTH_LONG).show();

                Fragment frag_orders = new OrdersFragment();
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.container, frag_orders);
                transaction2.addToBackStack(null);
                transaction2.commit();

                break;
            case R.id.nav_payments:
                Toast.makeText(this,position,Toast.LENGTH_LONG).show();

                Fragment frag_payments = new PaymentsFragment();
                FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.container, frag_payments);
                transaction3.addToBackStack(null);
                transaction3.commit();
                break;
        }
        return true;
    }

}
