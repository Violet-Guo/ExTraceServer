package com.express.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by violet on 2016/3/28.
 */
@Entity
@Table(name = "packandpack", schema = "", catalog = "express")
public class PackandpackEntity {
    private Byte isHistory;

    @Basic
    @Column(name = "IsHistory")
    public Byte getIsHistory() {
        return isHistory;
    }

    public void setIsHistory(Byte isHistory) {
        this.isHistory = isHistory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackandpackEntity that = (PackandpackEntity) o;

        if (isHistory != null ? !isHistory.equals(that.isHistory) : that.isHistory != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return isHistory != null ? isHistory.hashCode() : 0;
    }
}
