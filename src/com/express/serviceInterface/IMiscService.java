package com.express.serviceInterface;

import com.express.model.CustomerEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by violet on 2016/3/28.
 */

@Path("/Misc")
public interface IMiscService {
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/getCustomerInfo/{id}")
    public Response getCustomerInfo(@PathParam("id")String id);
}
