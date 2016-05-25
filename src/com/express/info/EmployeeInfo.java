package com.express.info;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "Employee")
/**
 * 1代表快递员，2代表分拣员，3代表司机
 */
public class EmployeeInfo implements Serializable {
    private Integer employeeId;
    private Integer Job;

    public EmployeeInfo() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getJob() {
        return Job;
    }

    public void setJob(Integer job) {
        Job = job;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "employeeId=" + employeeId +
                ", Job=" + Job +
                '}';
    }

}
