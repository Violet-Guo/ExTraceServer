package com.express.info;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Nvpiao on 2016/5/3 0003.
 * <p>
 * 1 未揽收
 * 2 揽收
 * 3 派送
 * 4 寄送
 * 5 签收
 */
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "newExpresslogisticsInfo")
public class ExpresslogisticsInfo implements Serializable {
    private String time;
    private String info;
    private Integer state;

    public ExpresslogisticsInfo() {
    }

    public ExpresslogisticsInfo(String time, String info, Integer state) {
        this.time = time;
        this.info = info;
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ExpresslogisticsInfo{" +
                "time='" + time + '\'' +
                ", info='" + info + '\'' +
                ", state=" + state +
                '}';
    }
}
