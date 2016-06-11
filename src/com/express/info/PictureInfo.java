package com.express.info;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nvpiao on 2016/6/4 0004.
 */
@org.hibernate.annotations.Proxy(lazy = false)
@XmlRootElement(name = "pictureInfo")
public class PictureInfo {
    private String picture;     //照片转String
    private String expressId;   //哪个快递
    private Integer whichOne;  //哪个照片？ 0 ：揽收   1 ： 派送

    public PictureInfo() {
    }

    public PictureInfo(String picture, String expressId, Integer whichOne) {
        this.picture = picture;
        this.expressId = expressId;
        this.whichOne = whichOne;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getExpressId() {
        return expressId;
    }

    public void setExpressId(String expressId) {
        this.expressId = expressId;
    }

    public Integer getWhichOne() {
        return whichOne;
    }

    public void setWhichOne(Integer whichOne) {
        this.whichOne = whichOne;
    }

    @Override
    public String toString() {
        return "PictureInfo{" +
                "picture='" + picture + '\'' +
                ", expressId='" + expressId + '\'' +
                ", whichOne=" + whichOne +
                '}';
    }
}
