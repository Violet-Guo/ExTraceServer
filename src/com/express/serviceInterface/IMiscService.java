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

    /////////////////////////////关于用户信息的接口////////////////////////////

    //通过用户id获得用户信息
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getCustomerInfoById/{id}")
    public CustomerEntity getCustomerInfoById(@PathParam("id")int id);

    //保存或更新用户信息
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveCustomerInfo")
    public Response saveCustomerInfo(CustomerEntity obj);

    //删除用户
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/deleteCustomerInfo/{id}")
    public Response deleteCustomerInfo(@PathParam("id") int id);

    //通过手机号和密码登陆
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/doLogin/{tel}/{pwd}")
    public boolean doLogin(@PathParam("tel") String tel, @PathParam("pwd") String pwd);

    //注销登陆
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/doLogOut/{cid}")
    public void doLogOut(@PathParam("cid") int cid);

    //验证手机号是否可用，true表示没有被注册过，可用；false表示已经被注册过，不可用
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/checkTelephone/{tel}")
    public boolean checkTelephone(@PathParam("tel") String tel);


    ///////////////////////////关于工作人员信息的接口////////////////////////////

    //通过工作人员id查找工作人员信息
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getEmployeeInfoById/{id}")
    public EmployeesEntity getEmployeeInfoById(@PathParam("id")int id);

    //保存工作人员信息
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveEmployeeInfo")
    public Response saveEmployeeInfo(EmployeesEntity obj);

    //删除员工信息
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/deleteEmployee/{id}")
    public Response deleteEmployee(@PathParam("id") int id);

    //员工通过手机号和密码登陆
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/doLoginByEmployee/{tel}/{pwd}")
    public boolean doLoginByEmployee(@PathParam("tel") String tel, @PathParam("pwd") String pwd);

    //注销登陆
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/doLogOutByEmployee/{id}")
    public void doLogOutByEmployee(@PathParam("id") int id);


    ///////////////////////////关于获取地区信息的接口////////////////////////////

    //获得所有的省份
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getAllProvince")
    public List<ProvinceEntity> getAllProvince();

    //获得对应省下所有的市
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getCityList/{pid}")
    public List<CityEntity> getCityList(@PathParam("pid")int pid);


    //获得对应市下面的所有的区
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getRegionList/{cid}")
    public List<RegionEntity> getRegionList(@PathParam("cid")int cid);

    //根据id查找省
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getProvinceById/{id}")
    public ProvinceEntity getProvinceById(@PathParam("id")int id);

    //根据id查找市
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getCityById/{id}")
    public CityEntity getCityById(@PathParam("id")int id);

    //根据id查找区
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getRegionById/{id}")
    public RegionEntity getRegionById(@PathParam("id")int id);

    //用户增加、更改地址信息
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveAddressbyCus")
    public Response saveAddressbyCus(AddressEntity obj);

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
}
