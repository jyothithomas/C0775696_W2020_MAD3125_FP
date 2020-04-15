package com.example.c0775696_w2020_mad3125_fp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.c0775696_w2020_mad3125_fp.R;

public class AddNewBillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();
    }
}
