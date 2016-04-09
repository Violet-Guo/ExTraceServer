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


    /////////////////////////////region的接口////////////////////////////

    //获得所有的省份
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getAllProvince")
    public List<ProvinceEntity> getAllProvince();

    //获得对应省下所有的市
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getCityList/{pid}")
    public List<CityEntity> getCityList(@PathParam("pid") int pid);


    //获得对应市下面的所有的区
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getRegionList/{cid}")
    public List<RegionEntity> getRegionList(@PathParam("cid") int cid);

    //根据id查找省
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getProvinceById/{id}")
    public ProvinceEntity getProvinceById(@PathParam("id") int id);

    //根据id查找市
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getCityById/{id}")
    public CityEntity getCityById(@PathParam("id") int id);

    //根据id查找区
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getRegionById/{id}")
    public RegionEntity getRegionById(@PathParam("id") int id);

    /////////////////////////////////营业网点、分拣中心相关接口///////////////////////////////////
    ////////////////////////////营业网点type = 1， 分拣中心type = 2//////////////////////////////

    //根据id获得营业网点的信息
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getBranchById/{id}")
    public OutletsEntity getBranchById(int id);

    //根据id获得分拣中心的信息
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getSortingCenterById/{id}")
    public OutletsEntity getSortingCenterById(int id);

    //获得某一区域的所有营业网点信息
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getAllBranchByRegionId/{id}")
    public List<OutletsEntity> getAllBranchByRegionId(int id);

    //获得某一区域的所有分拣中心信息
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getAllSCenterByRegionId/{id}")
    public List<OutletsEntity> getAllSCenterByRegionId(int id);

    //获得所有的营业网点的信息
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getAllBranch")
    public List<OutletsEntity> getAllBranch();

    //获得所有的分拣中心的信息
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getAllSortCenter")
    public List<OutletsEntity> getAllSortCenter();

    //获得所有的分拣中心+营业网点的信息
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getAllOutlets")
    public List<OutletsEntity> getAllOutlets();


    /////////////////////////////工具类的接口////////////////////////////

    /***
     * 验证手机号是否可用，true表示没有被注册过，可用；false表示已经被注册过，不可用
     *
     * @param tel 手机号
     * @return true表示没有被注册过，可用；false表示已经被注册过，不可用
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/checkTelephone/{tel}")
    public boolean checkTelephone(@PathParam("tel") String tel);


    //////////////////////////////////////////////////////////////////////////

}
