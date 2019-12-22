package com.imooc.domain;

import com.common.util.NumberUtil;

import java.text.DecimalFormat;

public class AccountFlow {
    private int id;
    private String date;
    private String time;
    private String currency;
    private long transAmountIn;
    private long transAmountOut;
    private long balance;
    private String transType;
    private String transRemark;

    private String strOfBalance;
    private String strOfTransAmountIn;
    private String strOfTransAmountOut;
    private int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getTransAmountIn() {
        return transAmountIn;
    }

    public void setTransAmountIn(long transAmountIn) {
        this.transAmountIn = transAmountIn;
        DecimalFormat df=new DecimalFormat(",###,##0.00");
        this.strOfTransAmountIn= df.format((float)transAmountIn/100);
    }

    public long getTransAmountOut() {
        return transAmountOut;
    }

    public void setTransAmountOut(long transAmountOut) {
        this.transAmountOut = transAmountOut;
        DecimalFormat df=new DecimalFormat(",###,##0.00");
        this.strOfTransAmountOut= df.format((float)transAmountOut/100);
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
        DecimalFormat df=new DecimalFormat(",###,##0.00");
        this.strOfBalance = df.format((float)balance/100);
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransRemark() {
        return transRemark;
    }

    public void setTransRemark(String transRemark) {
        this.transRemark = transRemark;
    }

    public String getStrOfBalance() {
        return strOfBalance;
    }

    public void setStrOfBalance(String strOfBalance) {
        this.strOfBalance = strOfBalance;
    }

    public String getStrOfTransAmountIn() {
        return strOfTransAmountIn;
    }

    public void setStrOfTransAmountIn(String strOfTransAmountIn) {
        this.strOfTransAmountIn = strOfTransAmountIn;
    }

    public String getStrOfTransAmountOut() {
        return strOfTransAmountOut;
    }

    public void setStrOfTransAmountOut(String strOfTransAmountOut) {
        this.strOfTransAmountOut = strOfTransAmountOut;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
