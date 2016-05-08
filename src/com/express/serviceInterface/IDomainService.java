package com.express.serviceInterface;

import com.express.info.ExpressInfo;
import com.express.info.ExpresslogisticsInfo;
import com.express.info.PackageInfo;
import com.express.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

/**
 * Created by violet on 2016/4/6.
 */
@Path("/Domain")   //业务操作
public interface IDomainService {

    /////////////////////////////公共的接口（用户和工作人员都要用的）////////////////////////////

    /**
     *  拆包，就是置为history
     * @param packageId 包裹id
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/openPackageByPackageId/{packageId}/{token}")
    public String openPackageByPackageId(@PathParam("packageId") String packageId, @PathParam("token") String token);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/updateExpressFree")
    public String updateExpressFree(ExpressEntity expressEntity);

    /**
     * 通过快递单号获得快递的物流信息
     *
     * @param expressId 快递的单号
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getExpresslogisticsInfosByExpressId/{expressId}/{token}")
    public List<ExpresslogisticsInfo> getExpresslogisticsInfosByExpressId(@PathParam("expressId") String expressId, @PathParam("token") String token);

    /**
     * 向包裹中存入包裹
     *
     * @param packageIds 包裹id list
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/PackageLoadIntoPackage")
    public Integer PackageLoadIntoPackage(List<String> packageIds);

    /**
     * 向包裹中存入快递
     *
     * @param expressIds 快递id list
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/PackageLoadIntoPackage")
    public Integer ExpressLoadIntoPackage(List<String> expressIds);


    /**
     * 按照packageId进行查询
     *
     * @param packageId 包裹id
     * @return 返回包裹信息
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getPackageInfoById/{packageId}/{token}")
    public PackageInfo getPackageInfo(@PathParam("packageId") String packageId, @PathParam("token") String token);


    /**
     * 通过发送地址和收货地址id获取快递id 寄件
     *
     * @param customerId    用户id
     * @param sendAddressId 发送地址id
     * @param recAddressId  收货地址id
     * @return 快递id
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/prepareSendExpress/customerId/{customerId}/sendAddressId/{sendAddressId}/recAddressId/{recAddressId}/{token}")
    public String PrepareSendExpress(@PathParam("customerId") Integer customerId, @PathParam("sendAddressId") Integer sendAddressId, @PathParam("recAddressId") Integer recAddressId, @PathParam("token") String token);

    /**
     * 创建一个包裹
     *
     * @param fromID      出发站点id
     * @param toID        到达站点id
     * @param employeesID 员工id
     * @return
     * @Param isSorter 是否是分拣员
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/createPackage/fromID/{fromID}/toID/{toID}/employeesID/{employeesID}/isSorter/{isSorter}/{token}")
    public PackageInfo CreateAPackage(@PathParam("fromID") Integer fromID, @PathParam("toID") Integer toID, @PathParam("employeesID") Integer employeesID, @PathParam("isSorter") Integer isSorter, @PathParam("token") String token);

    /**
     * 快递装入包裹的操作
     *
     * @param PackageId 包裹Id
     * @param Id        快递Id
     * @param isPackage 是不是包裹 0 不是包裹 1 是包裹
     * @return 是否插入成功
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/loadIntoPackage/packageId/{packageId}/id/{id}/isPackage/{isPackage}/{token}")
    public String LoadIntoPackage(@PathParam("packageId") String PackageId, @PathParam("id") String Id, @PathParam("isPackage") Integer isPackage, @PathParam("token") String token);

    /**
     * 查询包裹中的快件实体列表
     *
     * @param PackageId 包裹Id
     * @return 返回一个快件实体列表
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/searchExpressInPackageById/{packageId}/{token}")
    public List<ExpressInfo> searchExpressInPackageById(@PathParam("packageId") String PackageId, @PathParam("token") String token);

    /**
     * 通过快递单号获取快递信息
     *
     * @param id 快递单号id
     * @return 返回一个快递信息的实体
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getExpressInfoById/{id}/{token}")
    public ExpressInfo getExpressInfoById(@PathParam("id") String id, @PathParam("token") String token);


    /**
     * 按照电话号码查询快递信息
     *
     * @param tel 电话号码
     * @return 快递信息的list
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getExpressInfoByTel/{tel}/{token}")
    public List<ExpressInfo> getExpressInfoByTel(@PathParam("tel") String tel, @PathParam("token") String token);

    /**
     * 按照用户的id查询用户寄出快递信息
     *
     * @param CustomerId
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getSendExpressInfoByCustomerId/{CustomerId}/{token}")
    public List<ExpressInfo> getSendExpressInfoByCustomerId(@PathParam("CustomerId") Integer CustomerId, @PathParam("token") String token);

    /**
     * 按照用户的id查询用户接收快递信息（未收）
     *
     * @param CustomerId
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getDncRercvExpressInfoByCustomerId/{CustomerId}/{token}")
    public List<ExpressInfo> getDncRercvExpressInfoByCustomerId(@PathParam("CustomerId") Integer CustomerId, @PathParam("token") String token);

    /**
     * 按照用户的id查询用户接收快递信息(已收)
     *
     * @param CustomerId
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getAccRercvExpressInfoByCustomerId/{CustomerId}/{token}")
    public List<ExpressInfo> getAccRercvExpressInfoByCustomerId(@PathParam("CustomerId") Integer CustomerId, @PathParam("token") String token);

    /**
     * 通过包裹id查找包裹
     *
     * @param PackageId 包裹Id
     * @return 返回一个包裹对象
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/findAPackageById/{packageId}/{token}")
    public PackageEntity findAPackageById(@PathParam("packageId") String PackageId, @PathParam("token") String token);


    /**
     * 查询包裹中的包裹对象列表
     *
     * @param PackageId 包裹Id
     * @return 返回一个包裹对象列表
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/searchPackageInPackageById/{packageId}/{token}")
    public List<PackageEntity> searchPackageInPackageById(@PathParam("packageId") String PackageId, @PathParam("token") String token);

    /**
     * 保存快递信息
     *
     * @param obj 快递的json数据实体
     * @return 返回resopnse
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/saveExpress")
    public String saveExpress(ExpressEntity obj);

    /**
     * 查询工作量
     *
     * @param employeeId 员工id
     * @param starttime  开始时间
     * @param days       查询总天数
     * @return 返回一个快件列表
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getWork/employeeId/{employeeId}/starttime/{starttime}/days/{days}/{token}")
    public List<ExpressEntity> getWork(@PathParam("employeeId") Integer employeeId, @PathParam("starttime") String starttime, @PathParam("days") Integer days, @PathParam("token") String token);

    /////////////////////////////用户的接口////////////////////////////

    /***
     * 通过用户id获得用户信息
     *
     * @param id 用户的id
     * @return 返回一个用户的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getCustomerInfoById/{id}/{token}")
    public CustomerEntity getCustomerInfoById(@PathParam("id") int id, @PathParam("token") String token);

    /***
     * 通过用户手机号获得用户信息
     *
     * @param tel 用户的tel
     * @return 返回一个用户的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getCustomerInfoByTel/{tel}/{token}")
    public CustomerEntity getCustomerInfoByTel(@PathParam("tel") String tel, @PathParam("token") String token);

    /**
     * 用户注册
     *
     * @param obj obj中含有手机号、密码、姓名，一个实体传过来
     * @return 返回一个仿json数据
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/register")
    public String registerByCus(CustomerEntity obj);

    /***
     * 更新用户信息
     *
     * @param obj 传入一个json格式的用户实体数据
     * @return 返回仿json返回值
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/updateCustomerInfo")
    public String updateCustomerInfo(CustomerEntity obj);

    /***
     * 删除用户
     *
     * @param id 用户的id
     * @return 返回resopnse
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/deleteCustomerInfo/{id}/{token}")
    public Response deleteCustomerInfo(@PathParam("id") int id, @PathParam("token") String token);

    /**
     * post请求登陆
     *
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
     * @param token 用户手机号
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/doLogOut/{token}")
    public void doLogOut(@PathParam("token") String token);

    /**
     * 修改手机号
     *
     * @param telold 手机号
     * @return 模仿json数据
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/changeTel/old/{telold}/new/{telnew}/{token}")
    public String changeTel(@PathParam("telold") String telold, @PathParam("telnew") String telnew, @PathParam("token") String token);

    /**
     * 修改密码
     *
     * @param pwdold 密码
     * @return 模仿json数据
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/changePwd/tel/{tel}/{pwdold}/{pwdnew}/{token}")
    public String changePwd(@PathParam("tel") String tel, @PathParam("pwdold") String pwdold, @PathParam("pwdnew") String pwdnew, @PathParam("token") String token);


    /**
     * 通过快递单号和用户id创建一个快递信息
     *
     * @param id
     * @param cid
     * @return
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
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
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getEmployeeInfoById/{id}/{token}")
    public EmployeesEntity getEmployeeInfoById(@PathParam("id") int id, @PathParam("token") String token);

    /**
     * 增加一个新的员工
     *
     * @param obj 员工实体
     * @return 拼装的json返回数据
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/newEmployee")
    public String newEmployee(EmployeesEntity obj);

    /**
     * 修改员工信息
     *
     * @param obj 员工实体信息
     * @return 拼装的json返回数据
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/changeEmployeeInfo")
    public String changeEmployeeInfo(EmployeesEntity obj);


    /**
     * 删除员工信息
     *
     * @param id 工作人员的id
     * @return 返回response
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/deleteEmployee/{id}/{token}")
    public Response deleteEmployee(@PathParam("id") int id, @PathParam("token") String token);

    /**
     * 员工通过手机号和密码登陆
     *
     * @return 手机号和密码验证成功返回true，验证不成功返回false
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/loginByEmployee")
    public String doLoginByEmployee(EmployeesEntity obj);

    /**
     * 注销登陆
     *
     * @param id 员工的id
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/doLogOutByEmployee/{id}/{token}")
    public void doLogOutByEmployee(@PathParam("id") int id, @PathParam("token") String token);

    /**
     * 修改手机号
     *
     * @param telold 手机号
     * @return 模仿json数据
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/changeTelByEmp/old/{telold}/new/{telnew}/{token}")
    public String changeTelByEmp(@PathParam("telold") String telold, @PathParam("telnew") String telnew, @PathParam("token") String token);

    /**
     * 修改密码
     *
     * @param pwdold 密码
     * @return 模仿json数据
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/changePwdByEmp/tel/{tel}/{pwdold}/{pwdnew}/{token}")
    public String changePwdByEmp(@PathParam("tel") String tel, @PathParam("pwdold") String pwdold, @PathParam("pwdnew") String pwdnew, @PathParam("token") String token);


    /**
     * 保存包裹信息
     *
     * @param obj 一个包裹的json格式的数据实体
     * @return 返回response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/savePackage")
    public String savePackage(PackageEntity obj);

    /**
     * 通过包裹ID查找包裹
     *
     * @param pid 包裹的id
     * @return 返回一个快递的实体
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=UTF-8"})
    @Path("/getPackageById/{id}/{token}")
    public ExpressEntity getPackageById(@PathParam("id") String pid, @PathParam("token") String token);

    /////////////////////////////快递员的接口////////////////////////////


    /////////////////////////////分拣员的接口////////////////////////////


}
