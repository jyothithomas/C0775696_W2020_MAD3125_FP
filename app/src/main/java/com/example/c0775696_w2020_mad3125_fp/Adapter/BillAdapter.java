package com.example.c0775696_w2020_mad3125_fp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
}
