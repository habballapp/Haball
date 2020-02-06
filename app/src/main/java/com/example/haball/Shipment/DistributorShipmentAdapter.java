package com.example.haball.Shipment;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haball.Distributor.ui.shipments.DistributorShipment_ViewDashboard;
import com.example.haball.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class DistributorShipmentAdapter extends RecyclerView.Adapter<DistributorShipmentAdapter.ViewHolder> {
//
//    private Shipments_Fragments mContext;
    private  String heading,shipment_no_value,name_value,tv_date,tv_price,tv_option;
    Context activity;

    public DistributorShipmentAdapter(String heading, String shipment_no_value, String name_value, String tv_date, String tv_price, String tv_option, Context activity) {
        this.heading = heading;
        this.shipment_no_value = shipment_no_value;
        this.name_value = name_value;
        this.tv_date = tv_date;
        this.tv_price = tv_price;
        this.tv_option = tv_option;
        this.activity = activity;
    }

    public DistributorShipmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view_inflate = LayoutInflater.from(activity).inflate(R.layout.distributorshipment_recycler,parent,false);
        return new DistributorShipmentAdapter.ViewHolder(view_inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull DistributorShipmentAdapter.ViewHolder holder, int position) {

        holder.tv_heading.setText(heading);
        holder.shipment_no_value.setText(shipment_no_value);
        holder.name_value.setText(name_value);
        holder.tv_date.setText(tv_date);
        holder.tv_price.setText(tv_price);
        holder.tv_option.setText(tv_option);
        holder.menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(activity, view);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_items, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_view:
                                //handle menu1 click
                                Toast.makeText(activity,"View Clicked",Toast.LENGTH_LONG).show();
                                FragmentTransaction fragmentTransaction= ((FragmentActivity)activity).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.add(R.id.main_container,new DistributorShipment_ViewDashboard());
                                fragmentTransaction.commit();

                                break;
                            case R.id.menu_edit:
                                //handle menu2 click
                                Toast.makeText(activity,"Edit Clicked",Toast.LENGTH_LONG).show();

                                break;
                            case R.id.menu_delete:
                                //handle menu3 click
                                Toast.makeText(activity,"Delete Clicked",Toast.LENGTH_LONG).show();
                                final AlertDialog deleteAlert = new AlertDialog.Builder(activity).create();
                                LayoutInflater delete_inflater = LayoutInflater.from(activity);
                                View delete_alert = delete_inflater.inflate(R.layout.delete_alert, null);
                                deleteAlert.setView(delete_alert);
                                Button btn_delete = (Button) delete_alert.findViewById(R.id.btn_delete);
                                btn_delete.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        deleteAlert.dismiss();
                                        AlertDialog.Builder delete_successAlert = new AlertDialog.Builder(activity);
                                        LayoutInflater delete_inflater = LayoutInflater.from(activity);
                                        View delete_success_alert = delete_inflater.inflate(R.layout.delete_success, null);
                                        delete_successAlert.setView(delete_success_alert);
                                        delete_successAlert.show();
                                    }
                                });
                                deleteAlert.show();
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 2;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_heading,shipment_no_value,name_value,tv_date,tv_price,tv_option;
        public ImageButton menu_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_heading = itemView.findViewById(R.id.heading);
            shipment_no_value = itemView.findViewById(R.id.shipment_no_value);
            name_value = itemView.findViewById(R.id.name_value);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_option = itemView.findViewById(R.id.tv_option);
            menu_btn = itemView.findViewById(R.id.menu_btn);

        }
    }
}
