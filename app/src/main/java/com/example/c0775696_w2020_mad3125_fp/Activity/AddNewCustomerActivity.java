package com.example.c0775696_w2020_mad3125_fp.Activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.c0775696_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AddNewCustomerActivity extends AppCompatActivity {

    private TextInputLayout edtCustomerId,edtFirstName,edtLastName,edtBirthDate,edtUsername;
    private TextInputLayout edtEmail,edtPassword,edtLocation;
    private RadioButton rdBtnMale,rdBtnFemale,rdBtnOther;
    private TextInputEditText edtCustomerIdText,edtFirstNameText,edtLastNameText,edtBirthDateText;
    private TextInputEditText edtUsernameText,edtEmailText,edtPasswordText,edtLocationText;
    private Button btnAdd,btnClear;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        addDatePicker();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldCheck();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fieldClear();
            }
        });
    }
    }
}
