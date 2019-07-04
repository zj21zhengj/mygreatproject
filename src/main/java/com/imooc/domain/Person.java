package com.imooc.domain;

import java.util.Date;

public class Person {
    private String flow;
    private String type;
    private String transDate;
    private String orgCode;
    private double moneys;
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

    public double getMoneys() {
        return moneys;
    }

    public void setMoneys(double moneys) {
        double mm = moneys*100;
        this.moneys = (double) Math.round(mm * 100) / 100;
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

    @Override
    public String toString() {
        return "Person{" +
                "flow='" + flow + '\'' +
                ", type='" + type + '\'' +
                ", transDate='" + transDate + '\'' +
                ", orgCode='" + orgCode + '\'' +
                ", moneys=" + moneys +
                ", dingDan='" + dingDan + '\'' +
                ", qianZhi='" + qianZhi + '\'' +
                ", oper='" + oper + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
