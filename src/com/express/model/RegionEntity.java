package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by violet on 2016/4/6.
 */
@Entity
@Table(name = "region", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy=false)
@XmlRootElement(name = "Region")
public class RegionEntity {
    private int id;
    private String area;
    private Integer cityId;

    public RegionEntity() {
    }

    public RegionEntity(int id, String area, Integer cityId) {
        this.id = id;
        this.area = area;
        this.cityId = cityId;
    }

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Area", nullable = true, insertable = true, updatable = true, length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Basic
    @Column(name = "CityId", nullable = true, insertable = true, updatable = true)
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionEntity that = (RegionEntity) o;

        if (id != that.id) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (cityId != null ? !cityId.equals(that.cityId) : that.cityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        return result;
    }
}
