package com.learn.bdc.nationalsday.datalists;


/**
 * Created by Administrator on 2016/09/30.
 */
public class Bill {
    private double num;
    private String reason;
    private boolean balance;

    public Bill(double num, String reason, boolean balance) {
        this.num = num;
        this.reason = reason;
        this.balance = balance;
    }

    public double getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isBalance() {
        return balance;
    }

    public void setBalance(boolean balance) {
        this.balance = balance;
    }
}
