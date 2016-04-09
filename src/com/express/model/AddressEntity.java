package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "address", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "Address")
public class AddressEntity {
    private int id;
    private int regionId;
    private String address;
    private int customerId;
    private Integer rank;

    public AddressEntity() {
    }

    public AddressEntity(int id, int regionId, String address, int customerId, Integer rank) {
        this.id = id;
        this.regionId = regionId;
        this.address = address;
        this.customerId = customerId;
        this.rank = rank;
    }

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "RegionID", nullable = false, insertable = true, updatable = true)
    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "Address", nullable = true, insertable = true, updatable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "Rank", nullable = true, insertable = true, updatable = true)
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressEntity that = (AddressEntity) o;

        if (id != that.id) return false;
        if (regionId != that.regionId) return false;
        if (customerId != that.customerId) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (rank != null ? !rank.equals(that.rank) : that.rank != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + regionId;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + customerId;
        result = 31 * result + (rank != null ? rank.hashCode() : 0);
        return result;
    }
}
