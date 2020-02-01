package com.example.haball.Payment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.haball.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DistributorPaymentRequestAdaptor extends RecyclerView.Adapter<DistributorPaymentRequestAdaptor.ViewHolder> {
    private Context mContxt;
    private String heading, ledgerid, doctype, transaction, balance;
    public DistributorPaymentRequestAdaptor(DistributorPaymentRequest_CriteriaSelection requestLedger, String heading, String ledgerid, String doctype, String transaction, String balance) {
        this.mContxt = requestLedger;
        this.heading = heading;
        this.ledgerid = ledgerid;
        this.doctype = doctype;
        this.transaction = transaction;
        this.balance = balance;
    }

    @NonNull
    @Override
    public DistributorPaymentRequestAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_inflate = LayoutInflater.from(mContxt).inflate(R.layout.distributerorder_shoprecycler,parent,false);
        return new DistributorPaymentRequestAdaptor.ViewHolder(view_inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tv_heading.setText(heading);
        holder.ledger_id_value.setText(ledgerid);
        holder.document_type_value.setText(doctype);
        holder.transaction_value.setText(transaction);
        holder.balance_value.setText(balance);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_heading, ledger_id_value, document_type_value, transaction_value,balance_value;
        public ImageButton menu_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_heading = itemView.findViewById(R.id.heading);
            ledger_id_value = itemView.findViewById(R.id.ledger_id_value);
            document_type_value = itemView.findViewById(R.id.document_type_value);
            transaction_value = itemView.findViewById(R.id.transaction_value);
            balance_value = itemView.findViewById(R.id.balance_value);
        }
    }
}
