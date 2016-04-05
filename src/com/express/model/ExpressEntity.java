package com.express.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by violet on 2016/3/28.
 */
@Entity
@Table(name = "express", schema = "", catalog = "express")
public class ExpressEntity {
    private int id;
    private Byte isPackage;
    private Float weight;
    private String accepter;
    private Integer accTel;
    private Time getTime;
    private Time outTime;
    private Float tranFee;
    private Float insuFee;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IsPackage")
    public Byte getIsPackage() {
        return isPackage;
    }

    public void setIsPackage(Byte isPackage) {
        this.isPackage = isPackage;
    }

    @Basic
    @Column(name = "Weight")
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "Accepter")
    public String getAccepter() {
        return accepter;
    }

    public void setAccepter(String accepter) {
        this.accepter = accepter;
    }

    @Basic
    @Column(name = "AccTel")
    public Integer getAccTel() {
        return accTel;
    }

    public void setAccTel(Integer accTel) {
        this.accTel = accTel;
    }

    @Basic
    @Column(name = "GetTime")
    public Time getGetTime() {
        return getTime;
    }

    public void setGetTime(Time getTime) {
        this.getTime = getTime;
    }

    @Basic
    @Column(name = "OutTime")
    public Time getOutTime() {
        return outTime;
    }

    public void setOutTime(Time outTime) {
        this.outTime = outTime;
    }

    @Basic
    @Column(name = "TranFee")
    public Float getTranFee() {
        return tranFee;
    }

    public void setTranFee(Float tranFee) {
        this.tranFee = tranFee;
    }

    @Basic
    @Column(name = "InsuFee")
    public Float getInsuFee() {
        return insuFee;
    }

    public void setInsuFee(Float insuFee) {
        this.insuFee = insuFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressEntity that = (ExpressEntity) o;

        if (id != that.id) return false;
        if (isPackage != null ? !isPackage.equals(that.isPackage) : that.isPackage != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (accepter != null ? !accepter.equals(that.accepter) : that.accepter != null) return false;
        if (accTel != null ? !accTel.equals(that.accTel) : that.accTel != null) return false;
        if (getTime != null ? !getTime.equals(that.getTime) : that.getTime != null) return false;
        if (outTime != null ? !outTime.equals(that.outTime) : that.outTime != null) return false;
        if (tranFee != null ? !tranFee.equals(that.tranFee) : that.tranFee != null) return false;
        if (insuFee != null ? !insuFee.equals(that.insuFee) : that.insuFee != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isPackage != null ? isPackage.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (accepter != null ? accepter.hashCode() : 0);
        result = 31 * result + (accTel != null ? accTel.hashCode() : 0);
        result = 31 * result + (getTime != null ? getTime.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + (tranFee != null ? tranFee.hashCode() : 0);
        result = 31 * result + (insuFee != null ? insuFee.hashCode() : 0);
        return result;
    }
}
