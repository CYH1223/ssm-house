package com.qf.pojo.po;

import org.relaxng.datatype.helpers.StreamingValidatorImpl;

import java.util.Date;

public class Deposit {
    private String did;// 收费编号
    private double dmoney;// 押金金额
    private Date chargedate;// 收费日期
    private String contractid;// 合同百编号
    private String cname;// 客户姓名
    private int hid;// 房屋编号
    private String remark;// 备注

    public Deposit() {
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public double getDmoney() {
        return dmoney;
    }

    public void setDmoney(double dmoney) {
        this.dmoney = dmoney;
    }

    public Date getChargedate() {
        return chargedate;
    }

    public void setChargedate(Date chargedate) {
        this.chargedate = chargedate;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "did='" + did + '\'' +
                ", dmoney=" + dmoney +
                ", chargedate=" + chargedate +
                ", contractid='" + contractid + '\'' +
                ", cname='" + cname + '\'' +
                ", hid=" + hid +
                ", remark='" + remark + '\'' +
                '}';
    }
}
