package com.express.serviceInterface;

import com.express.model.ExpressEntity;
import com.express.model.PackageEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by violet on 2016/4/6.
 */
@Path("/Domain")   //业务操作
public interface IDomainService {
    /////////////////////////////关于快递信息的接口////////////////////////////

    //通过快递单号获取快递信息
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getExpressInfoById/{id}")
    public ExpressEntity getExpressInfoById(@PathParam("id")String id);

    //通过快递单号和用户id创建一个快递信息
    // @Consumes：声明该方法使用 HTML FORM。
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/createExpress/id/{id}/cid/{cid}")
    public Response createExpress(@PathParam("id") String id, @PathParam("cid") int cid);

    //保存快递信息
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("/saveExpress")
    public Response saveExpress(ExpressEntity obj);

    //////////////////////////////////////////////////////////////////////////

    /////////////////////////////关于包裹信息的接口////////////////////////////

    //创建一个新的包裹
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/newPackage")
    public Response newTransPackage(String id, int uid);

    //保存包裹信息
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/savePackage")
    public Response savePackage(PackageEntity obj);

    //通过包裹ID查找包裹
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getPackageById/{id}")
    public ExpressEntity getPackageById(@PathParam("id")int pid);

    ///////////////////////////////////////////////////////////////////////////
}
