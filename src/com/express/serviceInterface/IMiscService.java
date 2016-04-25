package com.express.serviceInterface;

import com.express.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by violet on 2016/3/28.
 */

@Path("/Misc")
public interface IMiscService {

    /////////////////////////////位置信息的接口////////////////////////////

    /////////////////////////////Address的接口/////////////////////////////
    ///////////////////////////status = 1代表是自己的地址，2代表是收货人的地址///////////

    /**
     * 获得用户所有的收货地址
     * @param cid 用户的id
     * @return 地址的实体list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAccAddress/customerid/{cid}")
    public List<CustomerAddressEntity> getAccAddress(@PathParam("cid")int cid);

    /**
     * 获得用户所有的收货地址
     * @param tel 用户的手机号
     * @return 地址的实体list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAccAddress/customertel/{tel}")
    public List<CustomerAddressEntity> getAccAddress(@PathParam("tel")String tel);

    /**
     * 获得用户所有的发货地址
     * @param cid 用户的id
     * @return 地址的实体list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getSendAddress/customerid/{cid}")
    public List<CustomerAddressEntity> getSendAddress(@PathParam("cid")int cid);

    /**
     * 获得用户所有的发货地址
     * @param tel 用户的tel
     * @return 地址的实体list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getSendAddress/customertel/{tel}")
    public List<CustomerAddressEntity> getSendAddress(@PathParam("tel")String tel);

    /**
     * 增加一个新的收货地址或发货地址
     * @param obj json格式的地址实体
     * @return response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/newAddress")
    public String newAddress(AddressEntity obj);

    /**
     * 修改收货地址或发货地址信息
     * @param obj json格式的地址实体
     * @return response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateAddress")
    public String updateAddress(AddressEntity obj);


    /////////////////////////////region的接口/////////////////////////////

    /**
     * 获得所有的省份
     * @return  返回一个省份的List
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAllProvince")
    public List<ProvinceEntity> getAllProvince();

    /**
     * 获得对应省下所有的市
     * @param pid  省份的id
     * @return 返回一个城市的List
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getCityList/{pid}")
    public List<CityEntity> getCityList(@PathParam("pid") int pid);


    /**
     * 获得对应市下面的所有的区
     * @param cid 城市的id
     * @return 返回一个区域的List
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getRegionList/{cid}")
    public List<RegionEntity> getRegionList(@PathParam("cid") int cid);

    /**
     * 根据id查找省
     * @param id 省的id
     * @return 返回一个省的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getProvinceById/{id}")
    public ProvinceEntity getProvinceById(@PathParam("id") int id);

    /**
     * 根据id查找市
     * @param id 市的id
     * @return 返回一个城市的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getCityById/{id}")
    public CityEntity getCityById(@PathParam("id") int id);

    /**
     * 根据id查找区
     * @param id 区域的id
     * @return 返回一个区域的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getRegionById/{id}")
    public RegionEntity getRegionById(@PathParam("id") int id);

    /////////////////////////////////营业网点、分拣中心相关接口///////////////////////////////////
    ////////////////////////////营业网点type = 1， 分拣中心type = 2//////////////////////////////

    /**
     * 根据id获得营业网点的信息
     * @param id 营业网点的id
     * @return 返回一个营业网点的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getBranchById/{id}")
    public OutletsEntity getBranchById(int id);

    /**
     * 根据id获得分拣中心的信息
     * @param id 分拣中心的id
     * @return 返回一个分拣中心的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getSortingCenterById/{id}")
    public OutletsEntity getSortingCenterById(int id);

    /**
     * 获得某一区域的所有营业网点信息
     * @param id 某一个区域的id
     * @return 返回一个营业网点的list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAllBranchByRegionId/{id}")
    public List<OutletsEntity> getAllBranchByRegionId(int id);

    /**
     * 获得某一区域的所有分拣中心信息
     * @param id 某一个区域的id
     * @return 返回一个分拣中心的list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAllSCenterByRegionId/{id}")
    public List<OutletsEntity> getAllSCenterByRegionId(int id);

    /**
     * 获得所有的营业网点的信息
     * @return 一个营业网点的list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAllBranch")
    public List<OutletsEntity> getAllBranch();

    /**
     * 获得所有的分拣中心的信息
     * @return 返回一个分拣中心的list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAllSortCenter")
    public List<OutletsEntity> getAllSortCenter();

    /**
     * 获得所有的分拣中心+营业网点的信息
     * @return 返回一个分拣中心+营业网点的list
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAllOutlets")
    public List<OutletsEntity> getAllOutlets();


    /////////////////////////////工具类的接口////////////////////////////

    /***
     * 验证手机号是否可用，true表示没有被注册过，可用；false表示已经被注册过，不可用
     * @param tel 手机号
     * @return true表示没有被注册过，可用；false表示已经被注册过，不可用
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/checkTelephone/{tel}")
    public boolean checkTelephone(@PathParam("tel") String tel);

    /**
     * 计算价格用的
     * @param from 发送地
     * @param to   目的地
     * @param weight 宽
     * @param area 长
     * @return 返回一个Float的价格
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/calc/from/{from}/to/{to}/weight/{weight}/area/{area}")
    public Float calc(@PathParam("from") String from, @PathParam("to") String to, @PathParam("weight") Float weight, @PathParam("area") Float area);


    //////////////////////////////////////////////////////////////////////////

}
