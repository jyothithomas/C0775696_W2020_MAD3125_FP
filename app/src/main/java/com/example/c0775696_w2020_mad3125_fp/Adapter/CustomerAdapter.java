package com.example.c0775696_w2020_mad3125_fp.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0775696_w2020_mad3125_fp.Activity.ShowBillDetailsActivity;
import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
import com.example.c0775696_w2020_mad3125_fp.R;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> // Add view holder
        {
        ArrayList<Customer> customersArrayList;
public CustomerAdapter(ArrayList<Customer> customerArrayList) {
        this.customersArrayList = customerArrayList;
        }

@NonNull
@Override
public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        CustomerViewHolder mCustomerViewHolder = new CustomerViewHolder(mView);
        return mCustomerViewHolder;
        }

@Override
public void onBindViewHolder(@NonNull final CustomerViewHolder holder, final int position) {
        Customer mCustomer = this.customersArrayList.get(position);
        holder.txtName.setText(mCustomer.getFirstName());
        holder.imgAttractions.setImageResource(mCustomer.getCustomerImg());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
@Override
public void onClick(View view)
        {
        Customer customer = customersArrayList.get(position);
        Intent attractionIntent = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
           // Intent mIntent = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
            attractionIntent.putExtra("CustomerBills", customer);
        /*Bundle bundle = new Bundle();
        bundle.putSerializable("customerskey", customer);
        attractionIntent.putExtras(bundle);
        holder.itemView.getContext().startActivity(attractionIntent);*/

        //Intent mIntent = new Intent(holder.itemView.getContext(), MainActivity.class);
        //Add Parameter - Parcalble or serializable
        //holder.itemView.getContext().startActivity(mIntent);

        }
        });
        }


@Override
public int getItemCount() {
        return this.customersArrayList.size();
        }

public class CustomerViewHolder extends RecyclerView.ViewHolder {

    TextView txtName;
    ImageView imgAttractions;

    public CustomerViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtName = itemView.findViewById(R.id.txt_customer_name);
        this.imgAttractions = itemView.findViewById(R.id.img_customer);
    }
}
}