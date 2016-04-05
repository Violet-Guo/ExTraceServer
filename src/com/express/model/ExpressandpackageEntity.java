package com.express.model;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by violet on 2016/3/28.
 */
@Entity
@Table(name = "expressandpackage", schema = "", catalog = "express")
public class ExpressandpackageEntity {
    private int expressId;
    private Time time;

    @Id
    @Column(name = "ExpressID")
    public int getExpressId() {
        return expressId;
    }

    public void setExpressId(int expressId) {
        this.expressId = expressId;
    }

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

        ExpressandpackageEntity that = (ExpressandpackageEntity) o;

        if (expressId != that.expressId) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expressId;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
