package com.qf.pojo.po;

public class House {
    private int hid;//房屋编号
    private String houseType;//房型
    private int price;//价格
    private String unit;//户型
    private int area;//面积
    private String orientation;//朝向
    private String site;//地址
    private String picture;//图片

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public House() {
    }

    @Override
    public String toString() {
        return "House{" +
                "hid=" + hid +
                ", houseType='" + houseType + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", area=" + area +
                ", orientation='" + orientation + '\'' +
                ", site='" + site + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
