package com.example.c0775696_w2020_mad3125_fp.Util;

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
}
