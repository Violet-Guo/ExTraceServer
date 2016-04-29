package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "packagehistory", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "PackageHistory")
public class PackagehistoryEntity implements Serializable {
    private int id;
    private String packageId;
    private int fromOutletsId;
    private int toOutletsId;
    private Date time;

    public PackagehistoryEntity() {
    }

    public PackagehistoryEntity(int id, String packageId, int fromOutletsId, int toOutletsId, Date time) {
        this.id = id;
        this.packageId = packageId;
        this.fromOutletsId = fromOutletsId;
        this.toOutletsId = toOutletsId;
        this.time = time;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "FromOutletsID", nullable = false, insertable = true, updatable = true)
    public int getFromOutletsId() {
        return fromOutletsId;
    }

    public void setFromOutletsId(int fromOutletsId) {
        this.fromOutletsId = fromOutletsId;
    }

    @Basic
    @Column(name = "ToOutletsID", nullable = false, insertable = true, updatable = true)
    public int getToOutletsId() {
        return toOutletsId;
    }

    public void setToOutletsId(int toOutletsId) {
        this.toOutletsId = toOutletsId;
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

        PackagehistoryEntity that = (PackagehistoryEntity) o;

        if (id != that.id) return false;
        if (fromOutletsId != that.fromOutletsId) return false;
        if (toOutletsId != that.toOutletsId) return false;
        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (packageId != null ? packageId.hashCode() : 0);
        result = 31 * result + fromOutletsId;
        result = 31 * result + toOutletsId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
