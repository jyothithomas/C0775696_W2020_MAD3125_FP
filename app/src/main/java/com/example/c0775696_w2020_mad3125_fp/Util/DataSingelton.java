package com.example.c0775696_w2020_mad3125_fp.Util;

import com.example.c0775696_w2020_mad3125_fp.Model.Bill;
import com.example.c0775696_w2020_mad3125_fp.Model.Customer;
import com.example.c0775696_w2020_mad3125_fp.Model.Hydro;
import com.example.c0775696_w2020_mad3125_fp.Model.Internet;
import com.example.c0775696_w2020_mad3125_fp.Model.Mobile;
import com.example.c0775696_w2020_mad3125_fp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class DataSingelton {
    private static DataSingelton repoObj = new DataSingelton();
    public static DataSingelton getInstance() {
        return repoObj;
    }
    private DataSingelton() { }
    private HashMap<String, Customer> customerMap = new HashMap<>();
    private ArrayList<Mobile> mobileBills = new ArrayList<>();
    private ArrayList<Hydro> hydroBills = new ArrayList<>();
    private ArrayList<Internet> internetBills = new ArrayList<>();

    public HashMap getCustomerMap(){
        return this.customerMap;
    }
    public Mobile getMobileBill(String billId) {
        for(Mobile mb : mobileBills)
        {
            if(mb.getBillId() == billId)
            {
                return mb;
            }
        }
        return null;
    }

    public Hydro getHydroBill(String billId) {
        for(Hydro hb : hydroBills)
        {
            if(hb.getBillId() == billId)
            {
                return hb;
            }
        }
        return null;
    }
    public Internet getInternetBill(String billId) {
        for(Internet ib : internetBills)
        {
            if(ib.getBillId() == billId)
            {
                return ib;
            }
        }
        return null;
    }
    public void populateData()
    {
        Customer c1 = new Customer("C01","Jyothi","Thomas",
                "Female","jyothi@mail.com","joe123","joe123","Scarborough",
                "05/Sep/1990", R.drawable.women);
        Customer c2 = new Customer("C02","James","Thomas",
                "Male","james@mail.com","jamz123","jamz123","Kerala",
                "21/Aug/1988",R.drawable.man);
        Customer c3 = new Customer("C03","Raelyn","Remy",
                "Female","rae_lyn@mail.com","rae_lyn12","raelyn123","Kollam",
                "05/Jul/2018",R.drawable.women);
        Customer c4 = new Customer("C04","Avani","Patel",
                "Female","Avipt@mail.com","avanipt93","avanipt1993","Guelph",
                "11/June/1993",R.drawable.women);
        Customer c5 = new Customer("C05","Charmi","Patel",
                "Female","charmipt@mail.com","charpt123","chrmi_123","Brampton",
                "01/Aug/1993",R.drawable.women);
        Mobile m1 = new Mobile("MB01",
                "09/Oct/2010",
                Bill.BillType.Mobile,
                "APPLE INC.",
                "All Canada Plan",
                "4372435081",
                3,
                12);
        Mobile m2 = new Mobile("MB02",
                "03/Jun/2011",
                Bill.BillType.Mobile,
                "Samsung",
                "International",
                "123456789",
                6,
                20);
        Hydro h1 = new Hydro( "HY01",
                "12/Dec/2012",
                Bill.BillType.Hydro,
                "ElectroHydro",
                18);
        Hydro h2 = new Hydro( "HY02",
                "10/Apr/2015",
                Bill.BillType.Hydro,
                "HydroCanada",
                25);
        Internet in1 = new Internet("IN01",
               "11/Jun/2013",
                Bill.BillType.Internet,
                "Rogers",
                21.3);
        Internet in2 = new Internet("IN02",
                "30/Jan/2013",
                Bill.BillType.Internet,
                "Bell",
                11.5);
        c2.addBill("IN01", in1);
        c1.addBill("MB01", m1);
        c1.addBill("HY01", h1);
        c3.addBill("HY01",h1);
        c3.addBill("IN02",in2);
        c3.addBill("HY02",h2);
        c4.addBill("MB01",m1);
        c4.addBill("MB02",m2);

        mobileBills.add(m1);
        mobileBills.add(m2);
        hydroBills.add(h1);
        hydroBills.add(h2);
        internetBills.add(in1);
        internetBills.add(in2);

        customerMap.put(c1.getCustomerId(),c1);
        customerMap.put(c2.getCustomerId(),c2);
        customerMap.put(c3.getCustomerId(),c3);
        customerMap.put(c4.getCustomerId(),c4);
        customerMap.put(c5.getCustomerId(),c5);
    }
}
