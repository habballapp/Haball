package com.example.haball.Distributor;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.example.haball.Distributor.ui.expandablelist.CustomExpandableListModel;
import com.example.haball.Distributor.ui.expandablelist.CustomExpandableListViewAdapter;
import com.example.haball.Distributor.ui.home.HomeFragment;
import com.example.haball.Distributor.ui.main.OrdersFragment;
import com.example.haball.Distributor.ui.main.PaymentsFragment;
import com.example.haball.Distributor.ui.orders.Orders_Fragment;
import com.example.haball.Distributor.ui.payments.Payments_Fragment;
import com.example.haball.Distributor.ui.support.SupportFragment;
import com.example.haball.R;

import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.techatmosphere.expandablenavigation.model.ChildModel;
import com.techatmosphere.expandablenavigation.model.HeaderModel;
import com.techatmosphere.expandablenavigation.view.ExpandableNavigationListView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DistributorDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private TextView tv_username;
    private FragmentTransaction fragmentTransaction;
    private DrawerLayout drawer;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<CustomExpandableListModel> headerList = new ArrayList<>();
    HashMap<CustomExpandableListModel, List<CustomExpandableListModel>> childList = new HashMap<>();
    private ExpandableNavigationListView navigationExpandableListView;

    Menu m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributor_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_username = toolbar.findViewById(R.id.tv_username);
        tv_username.setText("abcd test");

        drawer = findViewById(R.id.drawer_layout);

//        expandableListView = findViewById(R.id.navList);
//        prepareMenuData();
//        populateExpandableList();

        final NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_orders,R.id.nav_subcategory_laptops, R.id.nav_payments,
//                R.id.nav_shipments, R.id.nav_retailer, R.id.nav_profile,
//                R.id.nav_support, R.id.nav_logout, R.id.nav_terms_and_conditions)
//                .setDrawerLayout(drawer)
//                .build();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container,new HomeFragment());
        fragmentTransaction.commit();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationExpandableListView = findViewById(R.id.expandable_navigation);
        navigationExpandableListView
                .init(this)
                .addHeaderModel(new HeaderModel("Dashboard"))
                .addHeaderModel(new HeaderModel("Orders"))
                .addHeaderModel(
                        new HeaderModel("Payment")
                                .addChildModel(new ChildModel("Payments Summary"))
                                .addChildModel(new ChildModel("Consolidate Payments"))
                                .addChildModel(new ChildModel("Payment Request"))
                                .addChildModel(new ChildModel("Payment Ledger"))
                                .addChildModel(new ChildModel("Proof of Payments"))

                )
                .addHeaderModel(new HeaderModel("Shipment"))
                .addHeaderModel(new HeaderModel("Retailer"))
                .addHeaderModel(new HeaderModel("Profile"))
                .addHeaderModel(new HeaderModel("Support"))
                .addHeaderModel(new HeaderModel("Logout"))
                .build()
                .addOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        navigationExpandableListView.setSelected(groupPosition);

                        if (id == 0) {
                            Log.i("Dashboard","Dashboard Activity");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 1) {
                            Log.i("Orders","Orders Activity");
//                            startActivity(new Intent(AwokoHomeActivity.this, MoviesActivity.class));
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 2) {
                            Log.i("Payments","Payments Activity");
//                            drawer.closeDrawer(GravityCompat.START);
                            navigationView.setItemTextColor(ColorStateList.valueOf(Color.RED));
                        } else if (id == 3) {
                            Log.i("Shipment","Shipment Activity");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 4) {
                            Log.i("Retailer","Retailer Activity");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 5) {
                            Log.i("Profile","Profile Activity");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 6) {
                            Log.i("Suppport","Support Activity");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 7) {
                            Log.i("Logout","Logout Activity");
                            drawer.closeDrawer(GravityCompat.START);
                        }

                        return false;
                    }
                })
                .addOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        navigationExpandableListView.setSelected(groupPosition, childPosition);

                        if (id == 0) {
                            Log.i("Payments Summary","Child");
//                            startActivity(new Intent(AwokoHomeActivity.this, KidsActivity.class));
                        } else if (id == 1) {
                            Log.i("Consolidate Payments","Child");
//                            Common.showToast(AwokoHomeActivity.this, "music");
//                            startActivity(new Intent(AwokoHomeActivity.this, MusicActivity.class));
                        } else if (id == 2) {
                            Log.i("Payment Request","Child");
//                            Common.showToast(AwokoHomeActivity.this, "tv series");
//                            startActivity(new Intent(AwokoHomeActivity.this, TvSeriesActivity.class));
                        }
                        else if (id == 3) {
                            Log.i("Payment Ledger","Child");
//                            Common.showToast(AwokoHomeActivity.this, "tv series");
//                            startActivity(new Intent(AwokoHomeActivity.this, TvSeriesActivity.class));
                        }
                        else if (id == 4) {
                            Log.i("Proof of Payments","Child");
//                            Common.showToast(AwokoHomeActivity.this, "tv series");
//                            startActivity(new Intent(AwokoHomeActivity.this, TvSeriesActivity.class));
                        }
                        drawer.closeDrawer(GravityCompat.START);
                        return false;
                    }
                });
        navigationExpandableListView.expandGroup(1);

//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);



//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
//        {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId())
//                {
//                    case R.id.nav_home:
//                        Log.i("item no. ", String.valueOf(item.getItemId()));
//                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.main_container,new HomeFragment());
//                        fragmentTransaction.commit();
//
//                        item.setChecked(true);
//                        drawer.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.orders:
////                        Log.i("item no. ", String.valueOf(item.getItemId()));
////                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
////                        fragmentTransaction.replace(R.id.main_container,new Orders_Fragment());
////                        fragmentTransaction.commit();
////
////                        item.setChecked(true);
//                        m=navigationView.getMenu();
//                        m.findItem(R.id.nav_subcategory_laptops).setVisible(true);
//
//                        switch (item.getItemId()){
//                            case R.id.nav_subcategory_laptops:
//                                Log.i("item sub","sub item");
//                            break;
//
//                        }
//
//                        break;
//                    case R.id.nav_payments:
//                        Log.i("item no. ", String.valueOf(item.getItemId()));
//                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.main_container,new Payments_Fragment());
//                        fragmentTransaction.commit();
//
//                        item.setChecked(true);
//                        drawer.closeDrawer(GravityCompat.START);
//                        break;
//                    case R.id.nav_support:
//                        Log.i("item no. ", String.valueOf(item.getItemId()));
//                        fragmentTransaction=getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.main_container,new SupportFragment());
//                        fragmentTransaction.commit();
//
//                        item.setChecked(true);
//                        drawer.closeDrawer(GravityCompat.START);
//                        break;
//                }
//                return true;
//            }
//        });

//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this,getSupportFragmentManager());
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        viewPager.setAdapter(sectionsPagerAdapter);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
    }

//    private void populateExpandableList() {
//        expandableListAdapter = new CustomExpandableListViewAdapter(this, headerList, childList);
//        expandableListView.setAdapter(expandableListAdapter);
//
//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//
//                if (headerList.get(groupPosition).isGroup) {
//
//                }
//
//                return false;
//            }
//        });
//
//        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//
//                if (childList.get(headerList.get(groupPosition)) != null) {
//
//                }
//
//                return false;
//            }
//        });
//    }
//
//    private void prepareMenuData() {
//        CustomExpandableListModel customExpandableListModel = new CustomExpandableListModel("Dashboard", false, false);
//
//        headerList.add(customExpandableListModel);
//
//        if (!customExpandableListModel.hasChildren) {
//            childList.put(customExpandableListModel, null);
//        }
//
//        customExpandableListModel = new CustomExpandableListModel("Orders", true, true); //Menu of Java Tutorials
//        headerList.add(customExpandableListModel);
//        List<CustomExpandableListModel> childModelsList = new ArrayList<>();
//        CustomExpandableListModel childModel = new CustomExpandableListModel("Payments", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new CustomExpandableListModel("Shipments", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new CustomExpandableListModel("Retailer", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new CustomExpandableListModel("Profile", false, false);
//        childModelsList.add(childModel);
//
//
//        customExpandableListModel = new CustomExpandableListModel("Payments", true, true); //Menu of Java Tutorials
//        headerList.add(customExpandableListModel);
//        childModel = new CustomExpandableListModel("Support", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new CustomExpandableListModel("Logout", false, false);
//        childModelsList.add(childModel);
//
//        childModel = new CustomExpandableListModel("Terms & Conditions", false, false);
//        childModelsList.add(childModel);
//
//        customExpandableListModel = new CustomExpandableListModel("Shipment", true, true); //Menu of Java Tutorials
//        headerList.add(customExpandableListModel);
//
//        customExpandableListModel = new CustomExpandableListModel("Retailer", true, true); //Menu of Java Tutorials
//        headerList.add(customExpandableListModel);
//
//        customExpandableListModel = new CustomExpandableListModel("Profile", true, true); //Menu of Java Tutorials
//        headerList.add(customExpandableListModel);
//
//        customExpandableListModel = new CustomExpandableListModel("Support", true, true); //Menu of Java Tutorials
//        headerList.add(customExpandableListModel);
//
//        customExpandableListModel = new CustomExpandableListModel("Logout", true, true); //Menu of Java Tutorials
//        headerList.add(customExpandableListModel);
//
//        customExpandableListModel = new CustomExpandableListModel("Terms & Conditions", true, true); //Menu of Java Tutorials
//        headerList.add(customExpandableListModel);
//
//
//    }

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
//        switch(position) {
//            default:
//            case R.id.nav_home:
//                Toast.makeText(this,position,Toast.LENGTH_LONG).show();
//
//                Fragment frag_home = new HomeFragment();
//                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
//                transaction1.replace(R.id.container, frag_home);
//                transaction1.addToBackStack(null);
//                transaction1.commit();
//                break;
//            case R.id.nav_orders:
//                Toast.makeText(this,position,Toast.LENGTH_LONG).show();
//
//                Fragment frag_orders = new OrdersFragment();
//                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
//                transaction2.replace(R.id.container, frag_orders);
//                transaction2.addToBackStack(null);
//                transaction2.commit();
//
//                break;
//            case R.id.nav_payments:
//                Toast.makeText(this,position,Toast.LENGTH_LONG).show();
//
//                Fragment frag_payments = new PaymentsFragment();
//                FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
//                transaction3.replace(R.id.container, frag_payments);
//                transaction3.addToBackStack(null);
//                transaction3.commit();
//                break;
//        }
        drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
