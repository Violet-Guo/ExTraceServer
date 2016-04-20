package com.express.serviceInterface;

import com.express.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by violet on 2016/4/6.
 */
@Path("/Domain")   //业务操作
public interface IDomainService {

    /////////////////////////////公共的接口（用户和工作人员都要用的）////////////////////////////

    /**
     * 通过快递单号获取快递信息
     *
     * @param id 快递单号id
     * @return 返回一个快递信息的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getExpressInfoById/{id}")
    public ExpressEntity getExpressInfoById(@PathParam("id") String id);

    /**
     * 保存快递信息
     *
     * @param obj 快递的json数据实体
     * @return 返回resopnse
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/saveExpress")
    public Response saveExpress(ExpressEntity obj);


    /////////////////////////////用户的接口////////////////////////////

    /***
     * 通过用户id获得用户信息
     *
     * @param id 用户的id
     * @return 返回一个用户的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getCustomerInfoById/{id}")
    public CustomerEntity getCustomerInfoById(@PathParam("id") int id);

    /**
     * 用户注册
     * @param obj obj中含有手机号、密码、姓名，一个实体传过来
     * @return 返回一个仿json数据
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/register")
    public String registerByCus(CustomerEntity obj);

    /***
     * 保存或更新用户信息
     *
     * @param obj 传入一个json格式的用户实体数据
     * @return 返回resopnse
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveCustomerInfo")
    public Response saveCustomerInfo(CustomerEntity obj);

    /***
     * 删除用户
     *
     * @param id 用户的id
     * @return 返回resopnse
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/deleteCustomerInfo/{id}")
    public Response deleteCustomerInfo(@PathParam("id") int id);

    /**
     * post请求登陆
     * @param obj 客户信息实体
     * @return 登陆成功为true，失败为false
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public String login(CustomerEntity obj);

    /***
     * 注销登陆
     *
     * @param cid 用户id
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/doLogOut/{cid}")
    public void doLogOut(@PathParam("cid") int cid);


    /**
     * 通过快递单号和用户id创建一个快递信息
     *
     * @param id
     * @param cid
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/createExpress/id/{id}/cid/{cid}")
    public Response createExpress(@PathParam("id") String id, @PathParam("cid") int cid);


    /////////////////////////////工作人员的公共接口////////////////////////////

    /**
     * 通过工作人员id查找工作人员信息
     *
     * @param id 工作人员的id
     * @return 返回一个工作人员的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getEmployeeInfoById/{id}")
    public EmployeesEntity getEmployeeInfoById(@PathParam("id") int id);

    /**
     * 保存工作人员信息
     *
     * @param obj json格式的工作人员信息实体
     * @return 返回Resopnse
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/saveEmployeeInfo")
    public Response saveEmployeeInfo(EmployeesEntity obj);


    /**
     * 删除员工信息
     *
     * @param id 工作人员的id
     * @return 返回response
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/deleteEmployee/{id}")
    public Response deleteEmployee(@PathParam("id") int id);

    /**
     * 员工通过手机号和密码登陆
     *
     * @param tel 11位的手机号
     * @param pwd 密码
     * @return 手机号和密码验证成功返回true，验证不成功返回false
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/doLoginByEmployee/{tel}/{pwd}")
    public boolean doLoginByEmployee(@PathParam("tel") String tel, @PathParam("pwd") String pwd);

    /**
     * 注销登陆
     *
     * @param id 员工的id
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/doLogOutByEmployee/{id}")
    public void doLogOutByEmployee(@PathParam("id") int id);

    /**
     * 保存包裹信息
     *
     * @param obj 一个包裹的json格式的数据实体
     * @return 返回response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/savePackage")
    public Response savePackage(PackageEntity obj);

    /**
     * 通过包裹ID查找包裹
     *
     * @param pid 包裹的id
     * @return 返回一个快递的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getPackageById/{id}")
    public ExpressEntity getPackageById(@PathParam("id") int pid);

    /////////////////////////////快递员的接口////////////////////////////


    /////////////////////////////分拣员的接口////////////////////////////


}
