package com.wsloan.fanLiWang.entity;

public class DaiShenHe {
    private  Integer id;//回执单编号
    private  String platform;//平台名
    private  String disanfang;//第三方返利利率
    private  String fandian;//返利方式
    private  String rebateScheme;//返利金额，或者利率
    private  String phone;//注册手机号
    private  String yonghu;//注册上用户名
    private  Integer investMoney;//投资金额
    private  String  investLimit;//标的期限
    private  String  investTime;//投资时间
    private Integer refferID;//推荐人ID
    private Double fanli;//返利金额
    private String dailishang;//代理商

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public String getDisanfang() {
        return disanfang;
    }

    public void setDisanfang(String disanfang) {
        this.disanfang = disanfang;
    }

    public String getFandian() {
        return fandian;
    }

    public void setFandian(String fandian) {
        this.fandian = fandian;
    }

    public String getRebateScheme() {
        return rebateScheme;
    }

    public void setRebateScheme(String rebateScheme) {
        this.rebateScheme = rebateScheme;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getYonghu() {
        return yonghu;
    }

    public void setYonghu(String yonghu) {
        this.yonghu = yonghu;
    }

    public Integer getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(Integer investMoney) {
        this.investMoney = investMoney;
    }

    public String getInvestLimit() {
        return investLimit;
    }

    public void setInvestLimit(String investLimit) {
        this.investLimit = investLimit;
    }

    public String getInvestTime() {
        return investTime;
    }

    public void setInvestTime(String investTime) {
        this.investTime = investTime;
    }

    public Integer getRefferID() {
        return refferID;
    }

    public void setRefferID(Integer refferID) {
        this.refferID = refferID;
    }

    public Double getFanli() {
        return fanli;
    }

    public void setFanli(Double fanli) {
        this.fanli = fanli;
    }


    public String getDailishang() {
        return dailishang;
    }

    public void setDailishang(String dailishang) {
        this.dailishang = dailishang;
    }
}
