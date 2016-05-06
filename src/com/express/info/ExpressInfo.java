package com.express.info;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by 黎明 on 2016/4/20.
 */
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "ExpressInfo")
public class ExpressInfo implements Serializable {
    private String ID;//快递单号
    private String sname;//发件人姓名
    private String stel;//tel
    private String sadd;//省市区
    private String saddinfo;//街道
    private String rname;//收件人姓名
    private String rtel;
    private String radd;
    private String raddinfo;
    private String GetTime;
    private String OutTime;
    private float weight;
    private float TranFee;
    private float InsuFee;
    private String Acc1;
    private String Acc2;

    public ExpressInfo() {
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getAcc1() {
        return Acc1;
    }

    public void setAcc1(String acc1) {
        Acc1 = acc1;
    }

    public String getGetTime() {
        return GetTime;
    }

    public void setGetTime(String getTime) {
        GetTime = getTime;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getAcc2() {
        return Acc2;
    }

    public void setAcc2(String acc2) {
        Acc2 = acc2;
    }

    public float getInsuFee() {
        return InsuFee;
    }

    public void setInsuFee(float insuFee) {
        InsuFee = insuFee;
    }

    public String getRadd() {
        return radd;
    }

    public void setRadd(String radd) {
        this.radd = radd;
    }

    public String getOutTime() {
        return OutTime;
    }

    public void setOutTime(String outTime) {
        OutTime = outTime;
    }

    public String getRaddinfo() {
        return raddinfo;
    }

    public void setRaddinfo(String raddinfo) {
        this.raddinfo = raddinfo;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRtel() {
        return rtel;
    }

    public void setRtel(String rtel) {
        this.rtel = rtel;
    }

    public String getSadd() {
        return sadd;
    }

    public void setSadd(String sadd) {
        this.sadd = sadd;
    }

    public String getSaddinfo() {
        return saddinfo;
    }

    public void setSaddinfo(String saddinfo) {
        this.saddinfo = saddinfo;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public float getTranFee() {
        return TranFee;
    }

    public void setTranFee(float tranFee) {
        TranFee = tranFee;
    }
}
