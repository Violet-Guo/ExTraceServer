package com.express.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;

/**
 * Created by violet on 2016/3/28.
 */
@Entity
@Table(name = "packagehistory", schema = "", catalog = "express")
public class PackagehistoryEntity {
    private Time time;

    @Basic
    @Column(name = "Time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackagehistoryEntity that = (PackagehistoryEntity) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return time != null ? time.hashCode() : 0;
    }
}
