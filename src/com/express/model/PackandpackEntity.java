package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "packandpack", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "PackAndPack")
public class PackandpackEntity {
    private int id;
    private String packageId;
    private String parentId;
    private Integer isHistory;

    public PackandpackEntity() {
    }

    public PackandpackEntity(int id, String packageId, String parentId, Integer isHistory) {
        this.id = id;
        this.packageId = packageId;
        this.parentId = parentId;
        this.isHistory = isHistory;
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
    @Column(name = "ParentID", nullable = false, insertable = true, updatable = true, length = 24)
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
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
        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (isHistory != null ? !isHistory.equals(that.isHistory) : that.isHistory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (packageId != null ? packageId.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (isHistory != null ? isHistory.hashCode() : 0);
        return result;
    }
}
