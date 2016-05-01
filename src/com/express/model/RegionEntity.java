package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by violet on 2016/5/1.
 */
@Entity
@Table(name = "region", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "region")
public class RegionEntity implements Serializable {
    private int id;
    private String area;
    private Integer cityid;

    public RegionEntity() {
    }

    public RegionEntity(int id, String area, Integer cityid) {
        this.id = id;
        this.area = area;
        this.cityid = cityid;
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
    @Column(name = "area", nullable = true, insertable = true, updatable = true, length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "cityid", nullable = true, insertable = true, updatable = true)
    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionEntity that = (RegionEntity) o;

        if (id != that.id) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (cityid != null ? !cityid.equals(that.cityid) : that.cityid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (cityid != null ? cityid.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegionEntity{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", cityid=" + cityid +
                '}';
    }
}
