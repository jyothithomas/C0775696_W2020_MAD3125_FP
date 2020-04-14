package com.example.c0775696_w2020_mad3125_fp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0775696_w2020_mad3125_fp.Adapter.BillAdapter;
import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
import com.example.c0775696_w2020_mad3125_fp.R;
import com.example.c0775696_w2020_mad3125_fp.Util.UtilMethods;

import java.util.ArrayList;

public class ShowBillDetailActivity extends AppCompatActivity {
    private RecyclerView rvBillsList;
    private ArrayList billsArrayList;
    private BillAdapter billsAdapter;
    private ImageView imgAddButton;
    private TextView txtTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_detail);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setTitle("UTILITY BILLS");
        Intent mIntent = getIntent();
        Customer customerObj = mIntent.getParcelableExtra("CustomerBills");
        billsArrayList = customerObj.getBills();
        txtTotalAmount = findViewById(R.id.txtTotalAmount);
        if(!billsArrayList.isEmpty()){
            txtTotalAmount.setText("Total:"+ UtilMethods.getInstance().doubleFormatter((customerObj.getTotalAmount())));
        }
        else
        {
            txtTotalAmount.setText("No bills for this Customer.");
        }
        rvBillsList = findViewById(R.id.rvBillsList);
        billsAdapter = new BillAdapter(this.billsArrayList);

        RecyclerView.LayoutManager mLinearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvBillsList.setLayoutManager(mLinearLayoutManager);
        rvBillsList.setAdapter(billsAdapter);
    }
}
