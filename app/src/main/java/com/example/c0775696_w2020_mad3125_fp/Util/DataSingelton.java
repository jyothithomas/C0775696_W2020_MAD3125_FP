package com.example.c0775696_w2020_mad3125_fp.Util;

import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
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
        customerMap.put(c1.getCustomerId(),c1);
        customerMap.put(c2.getCustomerId(),c2);
        //customerMap.put(c3.getCustomerId(),c3);
       // customerMap.put(c4.getCustomerId(),c4);
       // customerMap.put(c5.getCustomerId(),c5);
        //customerMap.put(c6.getCustomerId(),c6);
    }
}
