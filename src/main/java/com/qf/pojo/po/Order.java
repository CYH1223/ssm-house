package com.qf.pojo.po;

public class Order {
             private String oid;
             private String cname;
             private String picture;
             private String houseType;
             private int price;
             private String area;
             private String position;
    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }



    public Order() {
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cname='" + cname + '\'' +
                ", picture='" + picture + '\'' +
                ", houseType='" + houseType + '\'' +
                ", price=" + price +
                ", area='" + area + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
