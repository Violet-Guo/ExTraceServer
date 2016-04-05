package com.express.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "expressandpackage", schema = "", catalog = "express")
public class ExpressandpackageEntity {
    private int expressId;
    private int packageId;
    private Timestamp time;

    @Id
    @Column(name = "ExpressID", nullable = false, insertable = true, updatable = true)
    public int getExpressId() {
        return expressId;
    }

    public void setExpressId(int expressId) {
        this.expressId = expressId;
    }

    @Basic
    @Column(name = "PackageID", nullable = false, insertable = true, updatable = true)
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    @Basic
    @Column(name = "Time", nullable = true, insertable = true, updatable = true)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressandpackageEntity that = (ExpressandpackageEntity) o;

        if (expressId != that.expressId) return false;
        if (packageId != that.packageId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expressId;
        result = 31 * result + packageId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
