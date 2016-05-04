package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by violet on 2016/5/5.
 */
@Entity
@Table(name = "word", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "word")
public class WordEntity implements Serializable {
    private int id;
    private String value;

    public WordEntity() {
    }

    public WordEntity(int id, String value) {
        this.id = id;
        this.value = value;
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
    @Column(name = "value", nullable = true, insertable = true, updatable = true, length = 255)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordEntity that = (WordEntity) o;

        if (id != that.id) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
