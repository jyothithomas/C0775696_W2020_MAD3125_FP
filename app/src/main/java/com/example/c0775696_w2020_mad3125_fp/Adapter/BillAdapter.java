package com.example.c0775696_w2020_mad3125_fp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0775696_w2020_mad3125_fp.Model.Bill;
import com.example.c0775696_w2020_mad3125_fp.R;

import java.util.ArrayList;

public class BillAdapter extends RecyclerView.Adapter<BillsAdapter.BillsViewHolder> {

    public static ArrayList<Bill> billArrayList;

    public BillsAdapter(ArrayList<Bill> billArrayList)
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
