package com.express.model;

import javax.persistence.*;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "packandpack", schema = "", catalog = "express")
public class PackandpackEntity {
    private int id;
    private int packageId;
    private int parentId;
    private Integer isHistory;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "ParentID", nullable = false, insertable = true, updatable = true)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "IsHistory", nullable = true, insertable = true, updatable = true)
    public Integer getIsHistory() {
        return isHistory;
    }

    public void setIsHistory(Integer isHistory) {
        this.isHistory = isHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackandpackEntity that = (PackandpackEntity) o;

        if (id != that.id) return false;
        if (packageId != that.packageId) return false;
        if (parentId != that.parentId) return false;
        if (isHistory != null ? !isHistory.equals(that.isHistory) : that.isHistory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + packageId;
        result = 31 * result + parentId;
        result = 31 * result + (isHistory != null ? isHistory.hashCode() : 0);
        return result;
    }
}
