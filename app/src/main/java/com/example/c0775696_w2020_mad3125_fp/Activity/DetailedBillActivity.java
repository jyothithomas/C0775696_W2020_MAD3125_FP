package com.example.c0775696_w2020_mad3125_fp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.c0775696_w2020_mad3125_fp.Model.Bill;
import com.example.c0775696_w2020_mad3125_fp.Model.Hydro;
import com.example.c0775696_w2020_mad3125_fp.Model.Internet;
import com.example.c0775696_w2020_mad3125_fp.Model.Mobile;
import com.example.c0775696_w2020_mad3125_fp.R;

public class DetailedBillActivity extends AppCompatActivity {
    Bill billObj;
    Mobile mob;
    Hydro hydro;
    Internet internet;
    TextView tv1,tv2,tv4,tv5,tv6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_bill);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        Intent mIntent = getIntent();
        // Bill billObj = (Bill) mIntent.getSerializableExtra("Bills");
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();
        if (getIntent().getExtras() != null) {
            billObj = (Bill) mIntent.getSerializableExtra("Bills");
            if (billObj.getBillType().equals(Bill.BillType.Mobile)) {
                mob = (Mobile)mIntent.getSerializableExtra("Bills");
                tv5.setText("Bill ID::::"+billObj.getBillId());
                tv1.setText("Bill Date::::"+billObj.getBillDate());
                tv2.setText("Plan Name::::"+mob.getPlanName());
                tv6.setText("Manufacturer Name::::"+mob.getManufacturerName());
                tv4.setText("Mobile Number::::"+mob.getMobileNumber());
                tv4.setEnabled(false);
            }
            if(billObj.getBillType().equals(Bill.BillType.Hydro))
            {
                hydro = (Hydro)mIntent.getSerializableExtra("Bills");
                tv5.setText("Bill ID::::"+billObj.getBillId());
                tv1.setText("Bill Date::::"+billObj.getBillDate());
                tv2.setText("Bill Type::::"+billObj.getBillType().toString());
                tv6.setText("Agency Name::::"+hydro.getAgencyName());
                tv4.setText("Units Used::::"+hydro.getUnitsUsed());
            }
            if(billObj.getBillType().equals(Bill.BillType.Internet))
            {
                internet = (Internet)mIntent.getSerializableExtra("Bills");
                tv5.setText("Bill ID::::"+billObj.getBillId());
                tv1.setText("Bill Date::::"+billObj.getBillDate());
                tv2.setText("Bill Type::::"+billObj.getBillType().toString());
                tv6.setText("Internet Provider::::"+internet.getProviderName());
                tv4.setText("GB Used::::"+internet.getGbUsed().toString());
            }
        }

    }
}
