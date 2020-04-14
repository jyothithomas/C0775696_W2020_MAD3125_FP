package com.example.c0775696_w2020_mad3125_fp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0775696_w2020_mad3125_fp.Activity.DetailedBillActivity;
import com.example.c0775696_w2020_mad3125_fp.Model.Bill;
import com.example.c0775696_w2020_mad3125_fp.R;
import com.example.c0775696_w2020_mad3125_fp.Util.UtilMethods;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillsViewHolder> {

    public static ArrayList<Bill> billArrayList;

    public BillAdapter(ArrayList<Bill> billArrayList)
    {
        this.billArrayList = billArrayList;
    }
    @NonNull
    @Override
    public BillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bill
                        , parent
                        , false);
        BillAdapter.BillsViewHolder mBillsViewHolder = new BillAdapter.BillsViewHolder(mView);
        return mBillsViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull final BillsViewHolder holder, final int position) {
        Bill mBills = this.billArrayList.get(position);
        if(mBills.getBillType().equals(Bill.BillType.Mobile))
        {
            holder.imgBillType.setImageResource(R.drawable.mobileicon);
        }
        if(mBills.getBillType().equals(Bill.BillType.Hydro)) {
            holder.imgBillType.setImageResource(R.drawable.hydroicon);
        }
        if(mBills.getBillType().equals(Bill.BillType.Internet)) {
            holder.imgBillType.setImageResource(R.drawable.interneticon);
        }
        holder.textBillID.setText(mBills.getBillId());
        holder.textBillAmount.setText(UtilMethods.getInstance().doubleFormatter(mBills.getBillTotal()));
        holder.textBillDate.setText(mBills.getBillDate().toString());
        holder.textBillType.setText(mBills.getBillType().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) { Bill billObj = billArrayList.get(position);
                Intent mIntent = new Intent(holder.itemView.getContext(), DetailedBillActivity.class);
                mIntent.putExtra("Bills", billObj);
                holder.itemView.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.billArrayList.size();
    }
    public class BillsViewHolder extends RecyclerView.ViewHolder {
        TextView textBillID,textBillDate,textBillType,textBillAmount;
        ImageView imgBillType;
        public BillsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textBillID = itemView.findViewById(R.id.txtBillId);
            textBillDate = itemView.findViewById(R.id.txtBillDate);
            textBillType = itemView.findViewById(R.id.txtBillType);
            textBillAmount = itemView.findViewById(R.id.txtTotalAmount);
            imgBillType = itemView.findViewById(R.id.imgBillType);
        }
    }

}
