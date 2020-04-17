package com.example.c0775696_w2020_mad3125_fp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.c0775696_w2020_mad3125_fp.R;


public class MobileBillFragment extends Fragment {

     private TextView txtFragBillId, txtFragBillDate, txtFragDataUsed, txtFragManufac, txtFragPlanName, txtFragMinsUsed, txtFragBillAmount;


    public MobileBillFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_mobile_bill, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        txtFragBillId = view.findViewById(R.id.txtFragBillId);
        txtFragBillDate = view.findViewById(R.id.txtFragBillDate);
        txtFragDataUsed = view.findViewById(R.id.txtFragDataUsed);
        txtFragManufac = view.findViewById(R.id.txtFragManufac);
        txtFragPlanName = view.findViewById(R.id.txtFragPlanName);
        txtFragMinsUsed = view.findViewById(R.id.txtFragMinsUsed);
        txtFragBillAmount = view.findViewById(R.id.txtBillAmount);

    }

}
