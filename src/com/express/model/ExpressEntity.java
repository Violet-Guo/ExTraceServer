package com.express.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "express", schema = "", catalog = "express")
public class ExpressEntity {
    private int id;
    private int customerId;
    private Integer isPackage;
    private Float weight;
    private String accepter;
    private Integer accTel;
    private int accAddressId;
    private Timestamp getTime;
    private Timestamp outTime;
    private Float tranFee;
    private Float insuFee;

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CustomerID", nullable = false, insertable = true, updatable = true)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "IsPackage", nullable = true, insertable = true, updatable = true)
    public Integer getIsPackage() {
        return isPackage;
    }

    public void setIsPackage(Integer isPackage) {
        this.isPackage = isPackage;
    }

    @Basic
    @Column(name = "Weight", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "Accepter", nullable = true, insertable = true, updatable = true, length = 50)
    public String getAccepter() {
        return accepter;
    }

    public void setAccepter(String accepter) {
        this.accepter = accepter;
    }

    @Basic
    @Column(name = "AccTel", nullable = true, insertable = true, updatable = true)
    public Integer getAccTel() {
        return accTel;
    }

    public void setAccTel(Integer accTel) {
        this.accTel = accTel;
    }

    @Basic
    @Column(name = "AccAddressID", nullable = false, insertable = true, updatable = true)
    public int getAccAddressId() {
        return accAddressId;
    }

    public void setAccAddressId(int accAddressId) {
        this.accAddressId = accAddressId;
    }

    @Basic
    @Column(name = "GetTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getGetTime() {
        return getTime;
    }

    public void setGetTime(Timestamp getTime) {
        this.getTime = getTime;
    }

    @Basic
    @Column(name = "OutTime", nullable = true, insertable = true, updatable = true)
    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    @Basic
    @Column(name = "TranFee", nullable = true, insertable = true, updatable = true, precision = 0)
    public Float getTranFee() {
        return tranFee;
    }

    public void setTranFee(Float tranFee) {
        this.tranFee = tranFee;
    }

    @Basic
    @Column(name = "InsuFee", nullable = true, insertable = true, updatable = true, precision = 0)
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
        if (customerId != that.customerId) return false;
        if (accAddressId != that.accAddressId) return false;
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
        result = 31 * result + customerId;
        result = 31 * result + (isPackage != null ? isPackage.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (accepter != null ? accepter.hashCode() : 0);
        result = 31 * result + (accTel != null ? accTel.hashCode() : 0);
        result = 31 * result + accAddressId;
        result = 31 * result + (getTime != null ? getTime.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + (tranFee != null ? tranFee.hashCode() : 0);
        result = 31 * result + (insuFee != null ? insuFee.hashCode() : 0);
        return result;
    }
}
