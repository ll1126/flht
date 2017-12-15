package com.wsloan.fanLiWang.entity;

public class DaiDaKuan {
    private int ID;
    /**
     * 收款用户名
     * */
    private  String gatheringUser;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * 收款银行账户

     * */
    private String gatheringAccount;

    /**

     * 用户开户的省份
     * */
    private String province;
    /**
     * 所在的市
     * */
    private String city;
    /**
     * 开户行
     * */
    private String khh;
    /**
     * 返利金额
     * */
    private  double fanli;

    public String getProvince() {
        return province;
    }

    public String getGatheringUser() {
        return gatheringUser;
    }

    public void setGatheringUser(String gatheringUser) {
        this.gatheringUser = gatheringUser;
    }

    public String getGatheringAccount() {
        return gatheringAccount;
    }

    public void setGatheringAccount(String gatheringAccount) {
        this.gatheringAccount = gatheringAccount;
    }

    public double getFanli() {
        return fanli;
    }

    public void setFanli(double fanli) {
        this.fanli = fanli;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKhh() {
        return khh;
    }

    public void setKhh(String khh) {
        this.khh = khh;
    }

    @Override
    public String toString() {
        return "DaiDaKuan{" +
                "gatheringUser='" + gatheringUser + '\'' +
                ", gatheringAccount='" + gatheringAccount + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", khh='" + khh + '\'' +
                ", fanli=" + fanli +
                '}';
    }
}
