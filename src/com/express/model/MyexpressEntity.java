package com.express.model;

import javax.persistence.*;

/**
 * Created by Nvpiao on 2016/6/14 0014.
 */
@Entity
@Table(name = "myexpress", schema = "express", catalog = "")
public class MyexpressEntity {
    private int id;
    private String expressId;
    private Integer customerId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "expressId", nullable = true, length = 25)
    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    @Basic
    @Column(name = "customerId", nullable = true)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyexpressEntity that = (MyexpressEntity) o;

        if (id != that.id) return false;
        if (expressId != null ? !expressId.equals(that.expressId) : that.expressId != null) return false;
        if (customerId != null ? !customerId.equals(that.customerId) : that.customerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (expressId != null ? expressId.hashCode() : 0);
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        return result;
    }
}
