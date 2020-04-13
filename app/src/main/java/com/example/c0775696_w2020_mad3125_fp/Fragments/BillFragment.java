package com.example.c0775696_w2020_mad3125_fp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.c0775696_w2020_mad3125_fp.Model.Bill;
import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
import com.example.c0775696_w2020_mad3125_fp.R;
import com.example.c0775696_w2020_mad3125_fp.Util.UtilMethods;

import java.util.ArrayList;

public class BillFragment extends Fragment {
    private TextView txtBillId;
    private TextView txtBillDate;
    private TextView txtBillAmount;
    private ImageView imgBillType;
    double totalAmount;

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    public BillFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bill, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        txtBillId = getView().findViewById(R.id.txtBillId);
        txtBillDate = getView().findViewById(R.id.txtBillDate);
        txtBillAmount = getView().findViewById(R.id.txtBillAmount);
        imgBillType = getView().findViewById(R.id.imgBillType);

        Intent mIntent = getActivity().getIntent();
        Customer customerObj = mIntent.getParcelableExtra("CustomerBills");

        // cust = (Customer) getActivity().getIntent().getExtras().getSerializable("billsKey");
        ArrayList<Bill> bills = customerObj.getBills();
        for(int j = 0; j< bills.size(); j++)
        {
            totalAmount += bills.get(j).getBillTotal();
        }

        // Log.d("Tag", String.valueOf(totalAmount));

        for(int i =0; i <bills.size(); i++)
        {
            if(bills.get(i).getBillId().contains("MB"))
            {
                txtBillId.setText(bills.get(i).getBillId());
                imgBillType.setImageResource(R.drawable.mobileicon);
                txtBillAmount.setText(UtilMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
                txtBillDate.setText(bills.get(i).getBillDate().toString());
            }

            if(bills.get(i).getBillId().contains("HY"))
            {
                txtBillId.setText(bills.get(i).getBillId());
                imgBillType.setImageResource(R.drawable.hydroicon);
                txtBillAmount.setText(UtilMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
                txtBillDate.setText(bills.get(i).getBillDate().toString());
            }

            if(bills.get(i).getBillId().contains("IN"))
            {
                txtBillId.setText(bills.get(i).getBillId());
                imgBillType.setImageResource(R.drawable.interneticon);
                txtBillAmount.setText(UtilMethods.getInstance().doubleFormatter(bills.get(i).billCalculate()));
                txtBillDate.setText(bills.get(i).getBillDate().toString());
            }
        }
    }
}
