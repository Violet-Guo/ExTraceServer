package com.express.serviceInterface;

import com.express.model.CustomerEntity;
import com.express.model.EmployeesEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    //保存用户信息
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveCustomerInfo")
    public Response saveCustomerInfo(CustomerEntity obj);

    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/deleteCustomerInfo/{id}")
    public Response deleteCustomerInfo(@PathParam("id") int id);

    //登陆
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/doLogin/{cid}/{pwd}")
    public boolean doLogin(@PathParam("cid") int cid, @PathParam("pwd") String pwd);

    //注销登陆
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/doLogOut/{cid}")
    public void doLogOut(@PathParam("cid") int cid);


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


    ///////////////////////////关于获取地区信息的接口////////////////////////////

    //获得所有的省份


    //获得对应省下所有的市


    //获得对应市下面的所有的区
}
