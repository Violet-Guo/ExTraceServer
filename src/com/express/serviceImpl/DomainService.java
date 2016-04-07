package com.express.serviceImpl;

import com.express.daoImpl.ExpressDao;
import com.express.model.ExpressEntity;
import com.express.model.PackageEntity;
import com.express.serviceInterface.IDomainService;

import javax.ws.rs.core.Response;

/**
 * Created by violet on 2016/4/6.
 */
public class DomainService implements IDomainService{

    private ExpressDao expressDao;

    public ExpressDao getExpressDao() {
        return expressDao;
    }

    public void setExpressDao(ExpressDao expressDao) {
        this.expressDao = expressDao;
    }

    /////////////////////////////关于快递信息的接口////////////////////////////

    //通过快递单号获取快递信息
    @Override
    public ExpressEntity getExpressInfoById(String id) {
        return expressDao.get(id);
    }

    @Override
    public Response createExpress(String id, int cid) {
        return null;
    }

    @Override
    public Response saveExpress(ExpressEntity obj) {
        return null;
    }

    //////////////////////////////////////////////////////////////////////////

    /////////////////////////////关于包裹信息的接口////////////////////////////

    @Override
    public Response newTransPackage(String id, int uid) {
        return null;
    }

    @Override
    public Response savePackage(PackageEntity obj) {

        return null;
    }
}
