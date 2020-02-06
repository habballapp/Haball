package com.example.haball.Distributor.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haball.Distributor.DistributorOrdersAdapter;
import com.example.haball.Distributor.DistributorPaymentsAdapter;
import com.example.haball.R;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = null;

        switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
            case 1: {
                rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
                break;
            }
            case 2: {
                rootView = inflater.inflate(R.layout.fragment_payments, container, false);
                recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_fragment_payments);

                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                recyclerView.setHasFixedSize(true);

                // use a linear layout manager
                layoutManager = new LinearLayoutManager(rootView.getContext());
                recyclerView.setLayoutManager(layoutManager);

                // specify an adapter (see also next example)
                mAdapter = new DistributorPaymentsAdapter(this,"Ghulam Rabani & Sons Traders & Distributors","51247895354254780369","PKR 600,000.00","Paid");
                recyclerView.setAdapter(mAdapter);
                break;
            }

            case 3: {
                rootView = inflater.inflate(R.layout.fragment_orders, container, false);
                recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_fragment_orders);

                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                recyclerView.setHasFixedSize(true);

                // use a linear layout manager
                layoutManager = new LinearLayoutManager(rootView.getContext());
                recyclerView.setLayoutManager(layoutManager);

                // specify an adapter (see also next example)
                mAdapter = new DistributorOrdersAdapter(this,"Ghulam Rabani & Sons Traders & Distributors","51247895354254780369","PKR 600,000.00","Approved");
                recyclerView.setAdapter(mAdapter);
                break;
            }
        }
        return rootView;
    }
}