package com.example.c0775696_w2020_mad3125_fp.Util;

import com.example.c0775696_w2020_mad3125_fp.Model.Bill;
import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
import com.example.c0775696_w2020_mad3125_fp.Model.Hydro;
import com.example.c0775696_w2020_mad3125_fp.Model.Internet;
import com.example.c0775696_w2020_mad3125_fp.Model.Mobile;
import com.example.c0775696_w2020_mad3125_fp.R;

import java.util.HashMap;

public class DataSingelton {
    private static DataSingelton repoObj = new DataSingelton();
    public static DataSingelton getInstance() {
        return repoObj;
    }
    private DataSingelton() { }
    private HashMap<String, Customer> customerMap = new HashMap<>();

    public HashMap getCustomerMap(){
        return this.customerMap;
    }
    public void populateData()
    {
        Customer c1 = new Customer("C01","Jyothi","Thomas",
                "Female","jyothi@mail.com","joe123","joe123","Scarborough",
                "01/01/1991", R.drawable.women);
        Customer c2 = new Customer("C02","James","Thomas",
                "Male","james@mail.com","jamz123","jamz123","Kerala",
                "01/01/1988",R.drawable.man);
        Mobile m1 = new Mobile("MB100",
                "9/10/2010",
                Bill.BillType.Mobile,
                "APPLE INC.",
                "Student Plan",
                "4379077578",
                1,
                6);
        Hydro h1 = new Hydro( "HY100",
                "12/12/2012",
                Bill.BillType.Hydro,
                "PUREWATA",
                22);
        Internet in1 = new Internet("IN100",
               "11/1/2013",
                Bill.BillType.Internet,
                "SKYLINK",
                22.8);
        c2.addBill("IN100", in1);
        c1.addBill("MB100", m1);
        c1.addBill("HY100", h1);
        customerMap.put(c1.getCustomerId(),c1);
        customerMap.put(c2.getCustomerId(),c2);
        //customerMap.put(c3.getCustomerId(),c3);
       // customerMap.put(c4.getCustomerId(),c4);
       // customerMap.put(c5.getCustomerId(),c5);
        //customerMap.put(c6.getCustomerId(),c6);
    }
}
