package com.express.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by violet on 2016/4/11.
 */
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "CustomerAddress")
public class CustomerAddressEntity {
    private int aid;
    private int customerid;
    private String name;
    private String telephone;
    private String province;
    private String city;
    private String region;
    private String address;
    private int rank;

    public CustomerAddressEntity() {
    }

    public CustomerAddressEntity(int aid, int customerid, String name, String telephone, String province, String city, String region, String address, int rank) {
        this.aid = aid;
        this.customerid = customerid;
        this.name = name;
        this.telephone = telephone;
        this.province = province;
        this.city = city;
        this.region = region;
        this.address = address;
        this.rank = rank;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProvince() {
        return province;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "CustomerAddressEntity{" +
                "aid=" + aid +
                ", customerid=" + customerid +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                ", rank=" + rank +
                '}';
    }
}
