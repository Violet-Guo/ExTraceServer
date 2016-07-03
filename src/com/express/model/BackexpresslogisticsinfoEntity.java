package com.express.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nvpiao on 2016/6/14 0014.
 */
@Entity
@Table(name = "backexpresslogisticsinfo", schema = "express", catalog = "")
public class BackexpresslogisticsinfoEntity {
    private int id;
    private String expressId;
    private Date time;
    private String info;
    private Integer state;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "expressId", nullable = true, length = 24)
    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    @Basic
    @Column(name = "time", nullable = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "info", nullable = true, length = 255)
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BackexpresslogisticsinfoEntity that = (BackexpresslogisticsinfoEntity) o;

        if (id != that.id) return false;
        if (expressId != null ? !expressId.equals(that.expressId) : that.expressId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (expressId != null ? expressId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
