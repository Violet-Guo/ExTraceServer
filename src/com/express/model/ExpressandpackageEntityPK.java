package com.express.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by violet on 2016/5/5.
 */
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "ExpressandpackageEntityPK")
public class ExpressandpackageEntityPK implements Serializable {
    private String expressId;
    private String packageId;

    public ExpressandpackageEntityPK() {
    }

    public ExpressandpackageEntityPK(String expressId, String packageId) {
        this.expressId = expressId;
        this.packageId = packageId;
    }

    @Column(name = "ExpressID", nullable = false, insertable = true, updatable = true, length = 24)
    @Id
    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    @Column(name = "PackageID", nullable = false, insertable = true, updatable = true, length = 24)
    @Id
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpressandpackageEntityPK that = (ExpressandpackageEntityPK) o;

        if (expressId != null ? !expressId.equals(that.expressId) : that.expressId != null) return false;
        if (packageId != null ? !packageId.equals(that.packageId) : that.packageId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = expressId != null ? expressId.hashCode() : 0;
        result = 31 * result + (packageId != null ? packageId.hashCode() : 0);
        return result;
    }
}
