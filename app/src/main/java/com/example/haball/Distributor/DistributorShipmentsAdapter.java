package com.example.haball.Distributor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.haball.Distributor.ui.main.PlaceholderFragment;
import com.example.haball.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DistributorShipmentsAdapter extends RecyclerView.Adapter<DistributorShipmentsAdapter.ViewHolder> {

    private PlaceholderFragment mContext;
    private  String heading,shipment_no_value,name_value,tv_date,tv_price,tv_option;
    Context activity;
    String dashboard, id, pending, createdDate;

    public DistributorShipmentsAdapter(PlaceholderFragment placeholderFragment, String heading, String shipment_no_value, String name_value, String tv_date, String tv_price, String tv_option){

        this.heading = heading;
        this.mContext = placeholderFragment;
        this.shipment_no_value = shipment_no_value;
        this.name_value = name_value;
        this.tv_date = tv_date;
        this.tv_price = tv_price;
        this.tv_option = tv_option;
    }


    public DistributorShipmentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_inflate = LayoutInflater.from(mContext.getContext()).inflate(R.layout.distributorshipment_recycler,parent,false);
        return new DistributorShipmentsAdapter.ViewHolder(view_inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DistributorShipmentsAdapter.ViewHolder holder, int position) {

        holder.tv_heading.setText(heading);
        holder.shipment_no_value.setText(shipment_no_value);
        holder.name_value.setText(name_value);
        holder.tv_date.setText(tv_date);
        holder.tv_price.setText(tv_price);
        holder.tv_option.setText(tv_option);


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_heading,shipment_no_value,name_value,tv_date,tv_price,tv_option;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_heading = itemView.findViewById(R.id.heading);
            shipment_no_value = itemView.findViewById(R.id.shipment_no_value);
            name_value = itemView.findViewById(R.id.name_value);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_option = itemView.findViewById(R.id.tv_option);
        }
    }
}
