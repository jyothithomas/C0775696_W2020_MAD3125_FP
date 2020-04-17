package com.example.c0775696_w2020_mad3125_fp.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.c0775696_w2020_mad3125_fp.Fragments.HydroBillFragment;
import com.example.c0775696_w2020_mad3125_fp.Fragments.InternetBillFragment;
import com.example.c0775696_w2020_mad3125_fp.Fragments.MobileBillFragment;
import com.example.c0775696_w2020_mad3125_fp.Model.Bill;
import com.example.c0775696_w2020_mad3125_fp.R;

public class DetailedBillActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_bill);

        Intent mIntent = getIntent();
        Bill billObj = mIntent.getParcelableExtra("Bills");

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        mFragmentManager = getSupportFragmentManager();

        if(billObj.getBillType().equals(Bill.BillType.Mobile)) {
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.add(R.id.container, new MobileBillFragment());
            mFragmentTransaction.commit();
        }
        if(billObj.getBillType().equals(Bill.BillType.Hydro))
        {
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.add(R.id.container, new HydroBillFragment());
            mFragmentTransaction.commit();
        }
        if(billObj.getBillType().equals(Bill.BillType.Internet))
        {
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.add(R.id.container, new InternetBillFragment());
            mFragmentTransaction.commit();
        }
    }
}
