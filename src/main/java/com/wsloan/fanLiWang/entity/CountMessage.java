package com.wsloan.fanLiWang.entity;

public class CountMessage {
    /**
     * 平台名称
     * */
    private String platform;
    /**
     * 註冊人數
     * */
    private int registerNum;
    /**
     * 登錄人數
     * */
    private  int loginNum;
    /**
     * 提交投資回單數
     * */
    private int commitReceiptNum;
    /**
     * 帶審核回單數
     * */
    private int checkReceiptNum;
    /**
     * 已審核回單數
     * */
    private int auditedReceiptNum;
    /**
     * 駁回回單數
     * */
    private int rejectReceiptNum;
    /**
     * 累計返利總額
     * */
    private int rebateMoney;
    /**
     * 累計投資總額
     * */
    private  int investMoney;
    /**
     * 累計錄入平台
     * */
    private int platformNum;


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(int registerNum) {
        this.registerNum = registerNum;
    }

    public int getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(int loginNum) {
        this.loginNum = loginNum;
    }

    public int getCommitReceiptNum() {
        return commitReceiptNum;
    }

    public void setCommitReceiptNum(int commitReceiptNum) {
        this.commitReceiptNum = commitReceiptNum;
    }

    public int getCheckReceiptNum() {
        return checkReceiptNum;
    }

    public void setCheckReceiptNum(int checkReceiptNum) {
        this.checkReceiptNum = checkReceiptNum;
    }

    public int getAuditedReceiptNum() {
        return auditedReceiptNum;
    }

    public void setAuditedReceiptNum(int auditedReceiptNum) {
        this.auditedReceiptNum = auditedReceiptNum;
    }

    public int getRejectReceiptNum() {
        return rejectReceiptNum;
    }

    public void setRejectReceiptNum(int rejectReceiptNum) {
        this.rejectReceiptNum = rejectReceiptNum;
    }

    public int getRebateMoney() {
        return rebateMoney;
    }

    public void setRebateMoney(int rebateMoney) {
        this.rebateMoney = rebateMoney;
    }

    public int getInvestMoney() {
        return investMoney;
    }

    public void setInvestMoney(int investMoney) {
        this.investMoney = investMoney;
    }

    public int getPlatformNum() {
        return platformNum;
    }

    public void setPlatformNum(int platformNum) {
        this.platformNum = platformNum;
    }
}
