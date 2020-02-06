package com.example.haball.Order;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.haball.Distributor.ui.orders.Orders_Fragment;
import com.example.haball.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DistributorOrderAdapter extends RecyclerView.Adapter<DistributorOrderAdapter.ViewHolder> {

    private Orders_Fragment mContext;
    private  String heading,orderno,amount,status;

    public DistributorOrderAdapter(Orders_Fragment requestOrder, String heading, String orderno, String amount, String status){

        this.heading = heading;
        this.mContext = requestOrder;
        this.orderno = orderno;
        this.amount = amount;
        this.status = status;
    }
    @NonNull
    @Override
    public DistributorOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_inflate = LayoutInflater.from(mContext.getContext()).inflate(R.layout.orders_layout,parent,false);
        return new DistributorOrderAdapter.ViewHolder(view_inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DistributorOrderAdapter.ViewHolder holder, int position) {

        holder.tv_heading.setText(heading);
        holder.order_no_value.setText(orderno);
        holder.amount_value.setText(amount);
        holder.status_value.setText(status);

    }
    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_heading,order_no_value,amount_value,status_value,tv_price;
        public ImageButton menu_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_heading = itemView.findViewById(R.id.heading);
            order_no_value = itemView.findViewById(R.id.order_no_value);
            amount_value = itemView.findViewById(R.id.amount_value);
            status_value = itemView.findViewById(R.id.status_value);
        }
    }
}
