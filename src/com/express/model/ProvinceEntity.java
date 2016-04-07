package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "province", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy=false)
@XmlRootElement(name = "Province")
public class ProvinceEntity {
    private int pid;
    private String pname;

    public ProvinceEntity() {
    }

    public ProvinceEntity(int pid, String pname) {
        this.pid = pid;
        this.pname = pname;
    }

    @Id
    @Column(name = "pid", nullable = false, insertable = true, updatable = true)
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "pname", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvinceEntity that = (ProvinceEntity) o;

        if (pid != that.pid) return false;
        if (pname != null ? !pname.equals(that.pname) : that.pname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pid;
        result = 31 * result + (pname != null ? pname.hashCode() : 0);
        return result;
    }
}
