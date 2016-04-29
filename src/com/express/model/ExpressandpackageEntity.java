package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "expressandpackage", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "ExpressAndPackage")
public class ExpressandpackageEntity implements Serializable {
    private String expressId;
    private String packageId;
    private Date time;

    public ExpressandpackageEntity() {
    }

    public ExpressandpackageEntity(String expressId, String packageId, Date time) {
        this.expressId = expressId;
        this.packageId = packageId;
        this.time = time;
    }

    @Id
    @Column(name = "ExpressID", nullable = false, insertable = true, updatable = true, length = 24)
    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    @Basic
    @Column(name = "PackageID", nullable = false, insertable = true, updatable = true, length = 24)
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Basic
    @Column(name = "Time", nullable = true, insertable = true, updatable = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressandpackageEntity that = (ExpressandpackageEntity) o;

        if (expressId != null ? !expressId.equals(that.expressId) : that.expressId != null) return false;
        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expressId != null ? expressId.hashCode() : 0;
        result = 31 * result + (packageId != null ? packageId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
