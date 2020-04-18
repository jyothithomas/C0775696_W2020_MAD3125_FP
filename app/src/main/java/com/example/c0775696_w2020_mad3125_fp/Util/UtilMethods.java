package com.example.c0775696_w2020_mad3125_fp.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilMethods {
    private static UtilMethods repoObj = new UtilMethods();
    public static UtilMethods getInstance() {
        return repoObj;
    }
    private UtilMethods()
    { }

    public String doubleFormatter(Double d)
    {
        return String.format("$ " + "%,.2f", d);
    }
    public boolean emailValidation(String s) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    public boolean mobileValidation(String s)
    {
        if(s.length() == 10)
        {
            return true;
        }
        return false;
    }
}
