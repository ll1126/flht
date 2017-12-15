package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class FMoney implements Serializable {

    private  Integer receiptID;//回执单ID
    private String uname;//用户姓名
    private String usfz;//用户开户行
    private String uphone;//用户手机号
    private String ucard;//用户卡号
    private String uAlipayName;//用户支付宝用户名
    private String uAlipayId;//用户支付宝账号
    private Integer umoney;//用户返利总金额(包括红包)
    private String ysfz;//推荐人开户行
    private String yphone;//推荐人手机号
    private String ycard;//推荐人银行卡号
    private String yAlipayName;//推荐人支付宝用户名
    private String yAlipayId;//推荐人支付宝账号
    private Integer ymoney;//推荐人红包
    private String yname;//推荐人姓名
    private String time;//财务审核时间
    private String payType;//支付方式（支付宝or银行卡）
    private  Integer receiptState;//财务打款状态
    private Integer id;//回执单编号

    public Integer getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(Integer receiptID) {
        this.receiptID = receiptID;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsfz() {
        return usfz;
    }

    public void setUsfz(String usfz) {
        this.usfz = usfz;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUcard() {
        return ucard;
    }

    public void setUcard(String ucard) {
        this.ucard = ucard;
    }

    public String getUAlipayName() {
        return uAlipayName;
    }

    public void setUAlipayName(String uAlipayName) {
        this.uAlipayName = uAlipayName;
    }

    public String getUAlipayId() {
        return uAlipayId;
    }

    public void setUAlipayId(String uAlipayId) {
        this.uAlipayId = uAlipayId;
    }


    public Integer getUmoney() {
        return umoney;
    }

    public void setUmoney(Integer umoney) {
        this.umoney = umoney;
    }

    public String getYsfz() {
        return ysfz;
    }

    public void setYsfz(String ysfz) {
        this.ysfz = ysfz;
    }

    public String getYphone() {
        return yphone;
    }

    public void setYphone(String yphone) {
        this.yphone = yphone;
    }

    public String getYcard() {
        return ycard;
    }

    public void setYcard(String ycard) {
        this.ycard = ycard;
    }

    public String getYAlipayName() {
        return yAlipayName;
    }

    public void setYAlipayName(String yAlipayName) {
        this.yAlipayName = yAlipayName;
    }

    public String getYAlipayId() {
        return yAlipayId;
    }

    public void setYAlipayId(String yAlipayId) {
        this.yAlipayId = yAlipayId;
    }

    public Integer getYmoney() {
        return ymoney;
    }

    public void setYmoney(Integer ymoney) {
        this.ymoney = ymoney;
    }

    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getReceiptState() {
        return receiptState;
    }

    public void setReceiptState(Integer receiptState) {
        this.receiptState = receiptState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

