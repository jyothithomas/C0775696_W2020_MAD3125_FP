package com.example.c0775696_w2020_mad3125_fp.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
import com.example.c0775696_w2020_mad3125_fp.R;
import com.example.c0775696_w2020_mad3125_fp.Util.DataSingelton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class AddNewCustomerActivity extends AppCompatActivity {

    private TextInputLayout edtCustomerId, edtFirstName, edtLastName, edtBirthDate, edtUsername;
    private TextInputLayout edtEmail, edtPassword, edtLocation;
    private RadioButton rdBtnMale, rdBtnFemale, rdBtnOther;
    private TextInputEditText edtCustomerIdText, edtFirstNameText, edtLastNameText, edtBirthDateText;
    private TextInputEditText edtUsernameText, edtEmailText, edtPasswordText, edtLocationText;
    private Button btnAdd, btnClear;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_customer);
        edtCustomerId = findViewById(R.id.edtCustomerId);
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtBirthDate = findViewById(R.id.edtBirthDate);
        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtLocation = findViewById(R.id.edtLocation);
        edtCustomerIdText = findViewById(R.id.edtCustomerIdText);
        edtFirstNameText = findViewById(R.id.edtFirstNameText);
        edtLastNameText = findViewById(R.id.edtLastNameText);
        edtBirthDateText = findViewById(R.id.edtBirthDateText);
        edtUsernameText = findViewById(R.id.edtUsernameText);
        edtEmailText = findViewById(R.id.edtEmailText);
        edtPasswordText = findViewById(R.id.edtPasswordText);
        edtLocationText = findViewById(R.id.edtLocationText);

        rdBtnMale = findViewById(R.id.rdBtnMale);
        rdBtnFemale = findViewById(R.id.rdBtnFemale);
        rdBtnOther = findViewById(R.id.rdBtnOther);

        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);

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

    private void addDatePicker() {
        edtBirthDateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        AddNewCustomerActivity.this,
                        android.R.style.Widget_Holo_ActionBar_Solid,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String date = "";
                month = month + 1;
                String monthName = getMonthName(month);
                if (day < 10) {
                    date = "0" + day + "/" + monthName + "/" + year;
                } else {
                    date = day + "/" + monthName + "/" + year;
                }
                edtBirthDateText.setText(date);
            }
        };
    }

    public static String getMonthName(int monthNumber) {
        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        return monthNames[monthNumber - 1];
    }
    public void fieldCheck()
    {
        boolean someFlag = false;
        if(edtCustomerIdText.getText().toString().isEmpty())
        {
            edtCustomerId.setError("Please enter customer ID");
            someFlag = true;
            return;
        }
        if(edtFirstNameText.getText().toString().isEmpty()){
            edtFirstName.setError("Please enter first name");
            someFlag = true;
            return;
        }
        if(edtLastNameText.getText().toString().isEmpty())
        {
            edtLastName.setError("Please enter last name");
            someFlag = true;
            return;
        }
        if(edtBirthDateText.getText().toString().isEmpty())
        {
            edtBirthDate.setError("Please enter date of birth");
            someFlag = true;
            return;
        }
        if(edtUsernameText.getText().toString().isEmpty())
        {
            edtUsername.setErrorEnabled(true);
            edtUsername.setError("Please enter username");
            someFlag = true;
            return;
        }
        if(edtEmailText.getText().toString().isEmpty())
        {
            edtEmail.setError("Please enter email");
            someFlag = true;
            return;
        }
        if(edtPasswordText.getText().toString().isEmpty())
        {
            edtPassword.setErrorEnabled(true);
            edtPassword.setError("Please enter password");
            someFlag = true;
            return;
        }
        if(edtLocationText.getText().toString().isEmpty())
        {
            edtLocation.setError("Please enter location");
            someFlag = true;
            return;
        }
        if(!someFlag) {
            Customer customer = new Customer(edtCustomerIdText.getText().toString(),
                    edtFirstNameText.getText().toString(),
                    edtLastNameText.getText().toString(),
                    getGender(),
                    edtEmailText.getText().toString(),
                    edtUsernameText.getText().toString(),
                    edtPasswordText.getText().toString(),
                    edtLocationText.getText().toString(),
                    edtBirthDateText.getText().toString(),
                    R.drawable.women);
            DataSingelton.getInstance().getCustomerMap().put(customer.getCustomerId(), customer);
            Intent mIntent = new Intent(AddNewCustomerActivity.this, CustomerListActivity.class);
            mIntent.putExtra("Customer", customer);
            startActivity(mIntent);
        }
    }

    public String getGender()
    {
        if (rdBtnMale.isChecked()){
            return "Male";
        }
        else if (rdBtnFemale.isChecked()) {
            return "Female";
        }
        else if(rdBtnOther.isChecked())
        {
            return "Other";
        }
        return null;
    }

    public void fieldClear()
    {
        edtUsernameText.getText().clear();
        edtPasswordText.getText().clear();
        edtBirthDateText.getText().clear();
        edtCustomerIdText.getText().clear();
        edtEmailText.getText().clear();
        edtLastNameText.getText().clear();
        edtFirstNameText.getText().clear();
        edtLocationText.getText().clear();

        rdBtnFemale.setChecked(false);
        rdBtnMale.setChecked(false);
        rdBtnOther.setChecked(false);
    }
}
