package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class Banner implements Serializable {
    private  Integer id ;//轮播ID
    private  String image;//PC图片
    private  String wangzhi;//PC网址
    private  String shuoming;//pc说明
    private  Integer paixu;//PC排序
    private  String appimage;//app图片
    private String appwangzhi;//app网址
    private  String appshuoming;//APP说明
    private  Integer apppaixu;//APP排序

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWangzhi() {
        return wangzhi;
    }

    public void setWangzhi(String wangzhi) {
        this.wangzhi = wangzhi;
    }

    public String getShuoming() {
        return shuoming;
    }

    public void setShuoming(String shuoming) {
        this.shuoming = shuoming;
    }

    public Integer getPaixu() {
        return paixu;
    }

    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }

    public String getAppimage() {
        return appimage;
    }

    public void setAppimage(String appimage) {
        this.appimage = appimage;
    }

    public String getAppwangzhi() {
        return appwangzhi;
    }

    public void setAppwangzhi(String appwangzhi) {
        this.appwangzhi = appwangzhi;
    }

    public String getAppshuoming() {
        return appshuoming;
    }

    public void setAppshuoming(String appshuoming) {
        this.appshuoming = appshuoming;
    }

    public Integer getApppaixu() {
        return apppaixu;
    }

    public void setApppaixu(Integer apppaixu) {
        this.apppaixu = apppaixu;
    }
}
