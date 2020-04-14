package com.example.c0775696_w2020_mad3125_fp.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0775696_w2020_mad3125_fp.Adapter.BillAdapter;
import com.example.c0775696_w2020_mad3125_fp.R;

import java.util.ArrayList;

public class ShowBillDetailActivity extends AppCompatActivity {
    private RecyclerView rvBillsList;
    private ArrayList billsArrayList;
    private BillAdapter billsAdapter;
    private ImageView imgAddButton;
    private TextView txtTotalAmountValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_detail);
    }
}
