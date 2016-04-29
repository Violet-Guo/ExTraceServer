package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "position", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "Position")
public class PositionEntity implements Serializable {
    private int id;
    private Double x;
    private Double y;
    private Date time;
    private String packageId;

    public PositionEntity() {
    }

    public PositionEntity(int id, Double x, Double y, Date time, String packageId) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.time = time;
        this.packageId = packageId;
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
    @Column(name = "X", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    @Basic
    @Column(name = "Y", nullable = true, insertable = true, updatable = true, precision = 0)
    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Basic
    @Column(name = "Time", nullable = true, insertable = true, updatable = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "PackageID", nullable = false, insertable = true, updatable = true, length = 24)
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionEntity that = (PositionEntity) o;

        if (id != that.id) return false;
        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        if (y != null ? !y.equals(that.y) : that.y != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (x != null ? x.hashCode() : 0);
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (packageId != null ? packageId.hashCode() : 0);
        return result;
    }
}
