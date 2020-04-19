package com.example.c0775696_w2020_mad3125_fp.Activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.c0775696_w2020_mad3125_fp.Model.Bill;
import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
import com.example.c0775696_w2020_mad3125_fp.Model.Hydro;
import com.example.c0775696_w2020_mad3125_fp.Model.Internet;
import com.example.c0775696_w2020_mad3125_fp.Model.Mobile;
import com.example.c0775696_w2020_mad3125_fp.R;
import com.example.c0775696_w2020_mad3125_fp.Util.UtilMethods;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class AddNewBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spnBillType;
    private TextInputLayout edtBillId,edtNumber,edtBillDate,edtDataUsed,edtMinsUsed,edtManuftrName;
    private TextInputLayout edtPlanName,edtUnitsUsed,edtAgencyName;
    private TextInputEditText edtBillIdText,edtNumberText,edtBillDateText,edtDataUsedText,edtMinsUsedText,edtManuftrNameText;
    private TextInputEditText edtPlanNameText,edtUnitsUsedText,edtAgencyNameText;
    private Button btnBillAdd,btnBillClear;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Customer custObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_bill);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();
        edtBillId = findViewById(R.id.edtBillId);
        edtNumber = findViewById(R.id.edtNumber);
        edtBillDate = findViewById(R.id.edtBillDate);
        edtDataUsed = findViewById(R.id.edtDataUsed);
        edtMinsUsed = findViewById(R.id.edtMinsUsed);
        edtManuftrName = findViewById(R.id.edtManufacName);
        edtPlanName = findViewById(R.id.edtPlanName);
        edtUnitsUsed = findViewById(R.id.edtUnitsUsed);
        edtAgencyName = findViewById(R.id.edtAgencyName);
        edtBillIdText = findViewById(R.id.edtBillIdText);
        edtNumberText = findViewById(R.id.edtNumberText);
        edtBillDateText = findViewById(R.id.edtBillDateText);
        edtDataUsedText = findViewById(R.id.edtDataUsedText);
        edtMinsUsedText = findViewById(R.id.edtMinsUsedText);
        edtManuftrNameText = findViewById(R.id.edtManufacNameText);
        edtPlanNameText = findViewById(R.id.edtPlanNameText);
        edtUnitsUsedText = findViewById(R.id.edtUnitsUsedText);
        edtAgencyNameText = findViewById(R.id.edtAgencyNameText);
        spnBillType = findViewById(R.id.spnBillType);

        btnBillAdd = findViewById(R.id.btnBillAdd);
        btnBillClear = findViewById(R.id.btnBillClear);
        Intent mIntent = getIntent();
        custObj = mIntent.getParcelableExtra("CustomerBills2");

        ArrayList<String> billType = new ArrayList<>();
        billType.add("MOBILE");
        billType.add("HYDRO");
        billType.add("INTERNET");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, billType);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBillType.setAdapter(dataAdapter);

        spnBillType.setOnItemSelectedListener(this);

        btnBillClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearfields();
            }
        });

        addDatePicker();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) parent.getChildAt(0)).setTextSize(18);
        ((TextView) parent.getChildAt(0)).setTypeface(null,Typeface.BOLD);

        if(position == 0)
        {
            initFields();
            clearfields();
            edtUnitsUsed.setVisibility(View.INVISIBLE);
            edtAgencyName.setVisibility(View.INVISIBLE);
            btnBillAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean Flag = false;
                    if (edtBillIdText.getText().toString().isEmpty()) {
                        edtBillIdText.setError("Please enter the bill ID");
                        Flag = true;
                        return;
                    }
                    if (edtBillDateText.getText().toString().isEmpty()) {
                        edtBillDateText.setError("Please enter bill date");
                        Flag = true;
                        return;
                    }
                    if (edtNumberText.getText().toString().isEmpty()) {
                        edtNumberText.setError("Please enter your phone number");
                        Flag = true;
                        return;
                    }
                    if (edtDataUsedText.getText().toString().isEmpty()) {
                        edtDataUsedText.setError("Please enter the data used");
                        Flag = true;
                        return;
                    }
                    if (edtMinsUsedText.getText().toString().isEmpty()) {
                        edtMinsUsedText.setError("Please enter the mins used");
                        Flag = true;
                        return;
                    }
                    if (edtManuftrNameText.getText().toString().isEmpty()) {
                        edtManuftrNameText.setError("Please enter the manufacturer");
                        Flag = true;
                        return;
                    }
                    if (edtPlanNameText.getText().toString().isEmpty()) {
                        edtPlanNameText.setError("Please enter your plan name");
                        Flag = true;
                        return;
                    }
                    if (!UtilMethods.getInstance().mobileValidation(edtNumberText.getText().toString())) {
                        edtNumberText.setError("Invalid Phone number");
                        new MaterialAlertDialogBuilder(AddNewBillActivity.this)
                                .setTitle("Invalid phone number")
                                .setMessage("Please check the phone number")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                        Flag = true;
                        return;
                    }
                    if (!Flag) {
                        Mobile mObj = new Mobile(edtBillIdText.getText().toString(),
                                edtBillDateText.getText().toString(),
                                Bill.BillType.Mobile,
                                edtManuftrNameText.getText().toString(),
                                edtPlanNameText.getText().toString(),
                                edtNumberText.getText().toString(),
                                Integer.parseInt(edtDataUsedText.getText().toString()),
                                Integer.parseInt(edtMinsUsedText.getText().toString()));
                        custObj.getCustomerBills().put(mObj.getBillId(), mObj);
                        Intent mIntent = new Intent(AddNewBillActivity.this, ShowBillDetailActivity.class);
                        mIntent.putExtra("CustomerBills", custObj);
                        startActivity(mIntent);
                    }
                }
            });
        }

        if(position == 1)
        {
            hidefields();
            clearfields();
            edtUnitsUsed.setVisibility(View.VISIBLE);
            edtAgencyName.setVisibility(View.VISIBLE);
            edtAgencyName.setHint("Enter Agency Name");
            edtUnitsUsed.setHint("Enter Units Used");
            btnBillAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean Flag = false;
                    if (edtBillIdText.getText().toString().isEmpty()) {
                        edtBillIdText.setError("Please enter the bill ID");
                        Flag = true;
                        return;
                    }
                    if (edtBillDateText.getText().toString().isEmpty()) {
                        edtBillDateText.setError("Please enter the bill date");
                        Flag = true;
                        return;
                    }
                    if(edtAgencyNameText.getText().toString().isEmpty())
                    {
                        edtNumberText.setError("Please enter the agency");
                        Flag = true;
                        return;
                    }
                    if(edtUnitsUsedText.getText().toString().isEmpty())
                    {
                        edtDataUsedText.setError("Please enter the units used");
                        Flag = true;
                        return;
                    }
                    if (!Flag)
                    {
                        Hydro hObj = new Hydro(edtBillIdText.getText().toString(),
                                edtBillDateText.getText().toString(),
                                Bill.BillType.Hydro,
                                edtAgencyNameText.getText().toString(),
                                Integer.parseInt(edtUnitsUsedText.getText().toString()));
                    custObj.getCustomerBills().put(hObj.getBillId(), hObj);
                    Intent mIntent = new Intent(AddNewBillActivity.this, ShowBillDetailActivity.class);
                    mIntent.putExtra("CustomerBills", custObj);
                    startActivity(mIntent);
                 }
                }
            });
        }

        if(position == 2)
        {
            hidefields();
            clearfields();
            edtUnitsUsed.setVisibility(View.VISIBLE);
            edtAgencyName.setVisibility(View.VISIBLE);
            edtAgencyName.setHint("Enter Provider Name");
            edtUnitsUsed.setHint("Enter Data Used");
            btnBillAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean Flag = false;
                    if (edtBillIdText.getText().toString().isEmpty()) {
                        edtBillIdText.setError("Please enter the bill ID");
                        Flag = true;
                        return;
                    }
                    if (edtBillDateText.getText().toString().isEmpty()) {
                        edtBillDateText.setError("Please enter the bill date");
                        Flag = true;
                        return;
                    }
                    if(edtAgencyNameText.getText().toString().isEmpty())
                    {
                        edtNumberText.setError("Please enter the provider");
                        Flag = true;
                        return;
                    }
                    if(edtUnitsUsedText.getText().toString().isEmpty())
                    {
                        edtDataUsedText.setError("Please enter the data used");
                        Flag = true;
                        return;
                    }
                    if (!Flag) {

                        Internet iObj = new Internet(edtBillIdText.getText().toString(),
                                edtBillDateText.getText().toString(),
                                Bill.BillType.Internet,
                                edtAgencyNameText.getText().toString(),
                                Double.parseDouble(edtUnitsUsedText.getText().toString()));
                        custObj.getCustomerBills().put(iObj.getBillId(), iObj);
                        Intent mIntent = new Intent(AddNewBillActivity.this, ShowBillDetailActivity.class);
                        mIntent.putExtra("CustomerBills", custObj);
                        startActivity(mIntent);
                    }
                }
            });
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void addDatePicker()
    {
        edtBillDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddNewBillActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                String date ="";
                month = month + 1;
                String monthName = getMonthName(month);
                if(day<10) {
                    date = "0"+day + "/" + monthName + "/" + year;
                }
                else
                {
                    date = day + "/" + monthName + "/" + year;
                }
                edtBillDateText.setText(date);
            }
        };
    }

    public static String getMonthName(int monthNumber){
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber-1];
    }
    public void initFields()
    {
        edtMinsUsed.setVisibility(View.VISIBLE);
        edtNumber.setVisibility(View.VISIBLE);
        edtDataUsed.setVisibility(View.VISIBLE);
        edtMinsUsed.setVisibility(View.VISIBLE);
        edtPlanName.setVisibility(View.VISIBLE);
        edtManuftrName.setVisibility(View.VISIBLE);
    }
    public void hidefields()
    {
        edtMinsUsed.setVisibility(View.INVISIBLE);
        edtNumber.setVisibility(View.INVISIBLE);
        edtDataUsed.setVisibility(View.INVISIBLE);
        edtMinsUsed.setVisibility(View.INVISIBLE);
        edtPlanName.setVisibility(View.INVISIBLE);
        edtManuftrName.setVisibility(View.INVISIBLE);
    }

    public void clearfields()
    {
        edtNumberText.getText().clear();
        edtDataUsedText.getText().clear();
        edtMinsUsedText.getText().clear();
        edtPlanNameText.getText().clear();
        edtManuftrNameText.getText().clear();
        edtBillDateText.getText().clear();
        edtBillIdText.getText().clear();
        edtAgencyNameText.getText().clear();
        edtDataUsedText.getText().clear();
        edtUnitsUsedText.getText().clear();
    }
}