package com.learn.bdc.nationalsday.datalists;

/**
 * Created by Administrator on 2016/09/30.
 */
public class Account {
    private double totalMoney;
    public static double cash=0;
    public static double deposit=0;
    public static double creditCard=0;
    public static double alipay=0;

    public Account() {

        totalMoney=cash+deposit+creditCard+alipay;
    }




}
