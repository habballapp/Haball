package com.example.haball.Distributor.ui.payments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.haball.Payment.DistributorPaymentRequestAdaptor;
import com.example.haball.Payment.Payment_Screen1;
import com.example.haball.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Payments_Fragment extends Fragment {

    private PaymentsViewModel paymentsViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button create_payment;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        paymentsViewModel =
                ViewModelProviders.of(this).get(PaymentsViewModel.class);
        View root = inflater.inflate(R.layout.activity_distributor_payment_request__criteria_selection, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.rv_payment_ledger);
        create_payment = root.findViewById(R.id.create_payment);
        create_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Payment_Screen1.class);
                startActivity(i);
            }
        });

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new DistributorPaymentRequestAdaptor(this,"Ghulam Rabani & Sons Traders & Distributors","1002312324251524","Invoice","PKR 50,000.00","PKR 600,000.00");

        recyclerView.setAdapter(mAdapter);
        return root;
    }
}