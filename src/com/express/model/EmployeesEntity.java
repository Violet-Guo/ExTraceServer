package com.express.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by violet on 2016/5/3.
 */
@Entity
@Table(name = "employees", schema = "", catalog = "express")
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "employees")
public class EmployeesEntity implements Serializable {
    private int id;
    private String name;
    private String password;
    private String telephone;
    private Integer job;
    private String jobText;
    private Integer status;
    private int outletsId;
    private String sendPackageId;
    private String recvPackageId;

    public EmployeesEntity() {
    }

    public EmployeesEntity(int id, String name, String password, String telephone, Integer job, String jobText, Integer status, int outletsId, String sendPackageId, String recvPackageId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.job = job;
        this.jobText = jobText;
        this.status = status;
        this.outletsId = outletsId;
        this.sendPackageId = sendPackageId;
        this.recvPackageId = recvPackageId;
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
    @Column(name = "Name", nullable = true, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Password", nullable = true, insertable = true, updatable = true, length = 25)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Telephone", nullable = true, insertable = true, updatable = true, length = 11)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "Job", nullable = true, insertable = true, updatable = true)
    public Integer getJob() {
        return job;
    }

    public void setJob(Integer job) {
        this.job = job;
    }

    @Basic
    @Column(name = "jobText", nullable = true, insertable = true, updatable = true, length = 255)
    public String getJobText() {
        return jobText;
    }

    public void setJobText(String jobText) {
        this.jobText = jobText;
    }

    @Basic
    @Column(name = "status", nullable = true, insertable = true, updatable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "OutletsID", nullable = false, insertable = true, updatable = true)
    public int getOutletsId() {
        return outletsId;
    }

    public void setOutletsId(int outletsId) {
        this.outletsId = outletsId;
    }

    @Basic
    @Column(name = "SendPackageID", nullable = true, insertable = true, updatable = true, length = 24)
    public String getSendPackageId() {
        return sendPackageId;
    }

    public void setSendPackageId(String sendPackageId) {
        this.sendPackageId = sendPackageId;
    }

    @Basic
    @Column(name = "RecvPackageID", nullable = true, insertable = true, updatable = true, length = 24)
    public String getRecvPackageId() {
        return recvPackageId;
    }

    public void setRecvPackageId(String recvPackageId) {
        this.recvPackageId = recvPackageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeesEntity that = (EmployeesEntity) o;

        if (id != that.id) return false;
        if (outletsId != that.outletsId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (job != null ? !job.equals(that.job) : that.job != null) return false;
        if (jobText != null ? !jobText.equals(that.jobText) : that.jobText != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (sendPackageId != null ? !sendPackageId.equals(that.sendPackageId) : that.sendPackageId != null)
            return false;
        if (recvPackageId != null ? !recvPackageId.equals(that.recvPackageId) : that.recvPackageId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (job != null ? job.hashCode() : 0);
        result = 31 * result + (jobText != null ? jobText.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + outletsId;
        result = 31 * result + (sendPackageId != null ? sendPackageId.hashCode() : 0);
        result = 31 * result + (recvPackageId != null ? recvPackageId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeesEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", job=" + job +
                ", jobText='" + jobText + '\'' +
                ", status=" + status +
                ", outletsId=" + outletsId +
                ", sendPackageId='" + sendPackageId + '\'' +
                ", recvPackageId='" + recvPackageId + '\'' +
                '}';
    }
}
