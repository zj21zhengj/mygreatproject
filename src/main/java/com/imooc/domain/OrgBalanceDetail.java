package com.imooc.domain;

import com.common.util.NumberUtil;
import org.apache.commons.codec.binary.StringUtils;

import java.math.BigDecimal;


public class OrgBalanceDetail {

    private String orgCode;
    private String accountDate;
    private BigDecimal adjustAmount;
    private BigDecimal accountAmount;
    private String accountType;
    private String serialNo;
    private String tradeNo;
    private String operAcct;
    private String lastUpdateTime;

    private String nameOfAccountType;
    private String strOfAccountAmount;
    private String strOfAdjustAmount;
    private int assetOrgId;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(String accountDate) {
        this.accountDate = accountDate;
    }

    public BigDecimal getAdjustAmount() {
        return adjustAmount;
    }

    public void setAdjustAmount(BigDecimal adjustAmount) {
        this.adjustAmount = adjustAmount;
        if (null != adjustAmount) {
            this.strOfAdjustAmount = NumberUtil.num2String(adjustAmount.longValue());
        }
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
        if (null != accountAmount) {
            this.strOfAccountAmount = NumberUtil.num2String(accountAmount.longValue());
        }
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
        if (StringUtils.equals("1", accountType)) {
            this.nameOfAccountType = "清算";
        } else if (StringUtils.equals("2", accountType)) {
            this.nameOfAccountType = "结算";
        } else if (StringUtils.equals("3", accountType)) {
            this.nameOfAccountType = "撤销";
        }
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOperAcct() {
        return operAcct;
    }

    public void setOperAcct(String operAcct) {
        this.operAcct = operAcct;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getNameOfAccountType() {
        return nameOfAccountType;
    }

    public void setNameOfAccountType(String nameOfAccountType) {
        this.nameOfAccountType = nameOfAccountType;
    }

    public String getStrOfAccountAmount() {
        return strOfAccountAmount;
    }

    public void setStrOfAccountAmount(String strOfAccountAmount) {
        this.strOfAccountAmount = strOfAccountAmount;
    }

    public String getStrOfAdjustAmount() {
        return strOfAdjustAmount;
    }

    public void setStrOfAdjustAmount(String strOfAdjustAmount) {
        this.strOfAdjustAmount = strOfAdjustAmount;
    }

    public int getAssetOrgId() {
        return assetOrgId;
    }

    public void setAssetOrgId(int assetOrgId) {
        this.assetOrgId = assetOrgId;
    }
}

