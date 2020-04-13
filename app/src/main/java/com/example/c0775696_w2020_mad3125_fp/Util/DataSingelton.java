package com.example.c0775696_w2020_mad3125_fp.Util;

import com.example.c0775696_w2020_mad3125_fp.Model.Customer;

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
}
