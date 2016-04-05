package com.express.serviceImpl;

import com.express.daoImpl.CustomerDao;
import com.express.serviceInterface.IMiscService;

import javax.ws.rs.core.Response;

/**
 * Created by violet on 2016/3/28.
 */
public class MiscService implements IMiscService {

    private CustomerDao customerDao;


    @Override
    public Response getCustomerInfo(String id) {
        return null;
    }
}
