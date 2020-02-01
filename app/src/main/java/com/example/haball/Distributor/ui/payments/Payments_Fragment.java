package com.example.haball.Distributor.ui.payments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.haball.Payment.Payment_Screen1;
import com.example.haball.R;


public class Payments_Fragment extends Fragment {

    private PaymentsViewModel paymentsViewModel;
    private RecyclerView recyclerView;

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
        return root;
    }
}