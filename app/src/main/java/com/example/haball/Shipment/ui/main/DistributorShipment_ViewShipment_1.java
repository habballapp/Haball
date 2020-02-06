package com.example.haball.Shipment.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haball.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

public class DistributorShipment_ViewShipment_1 extends Fragment {

    private DistributorShipmentViewShipment1ViewModel mViewModel;

    public static DistributorShipment_ViewShipment_1 newInstance() {
        return new DistributorShipment_ViewShipment_1();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.distributor_shipment__view_shipment_1_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DistributorShipmentViewShipment1ViewModel.class);
        // TODO: Use the ViewModel
    }

}
