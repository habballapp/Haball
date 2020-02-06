package com.example.haball.Distributor.ui.shipments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haball.R;
import com.example.haball.Shipment.DistributorShipmentAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DistributorShipment_ViewDashboard extends Fragment {

    private ShipmentsViewModel sendViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private DistributorShipmentViewDashboardViewModel mViewModel;

    public static DistributorShipment_ViewDashboard newInstance() {
        return new DistributorShipment_ViewDashboard();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       // return inflater.inflate(R.layout.distributor_shipment__view_dashboard_fragment, container, false);
        sendViewModel =
                ViewModelProviders.of(this).get(ShipmentsViewModel.class);
        View root = inflater.inflate(R.layout.activity_distributor_shipment__view_dashboard, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.rv_shipment);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new DistributorShipmentAdapter("Shield Company","1002312324251524","Shield","06-01-2020","100","Recieved",getActivity());
        recyclerView.setAdapter(mAdapter);
        return root;
    }



}
