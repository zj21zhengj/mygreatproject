package com.imooc.domain;

import java.util.Date;

public class Person {
    private String flow;
    private String type;
    private String transDate;
    private String orgCode;
    private long moneyin;
    private long moneyout;
    private long money;
    private String dingDan;
    private String qianZhi;
    private String oper;
    private String updateTime;

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public long getMoneyin() {
        return moneyin;
    }

    public void setMoneyin(long moneyin) {
        this.moneyin = moneyin;
    }

    public long getMoneyout() {
        return moneyout;
    }

    public void setMoneyout(long moneyout) {
        this.moneyout = moneyout;
    }

    public String getDingDan() {
        return dingDan;
    }

    public void setDingDan(String dingDan) {
        this.dingDan = dingDan;
    }

    public String getQianZhi() {
        return qianZhi;
    }

    public void setQianZhi(String qianZhi) {
        this.qianZhi = qianZhi;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Person{" +
                "flow='" + flow + '\'' +
                ", type='" + type + '\'' +
                ", transDate='" + transDate + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", moneyin=" + moneyin +
                ", moneyout=" + moneyout +
                ", dingDan='" + dingDan + '\'' +
                ", qianZhi='" + qianZhi + '\'' +
                ", oper='" + oper + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}