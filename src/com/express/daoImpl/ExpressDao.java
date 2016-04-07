package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.ExpressEntity;

/**
 * Created by violet on 2016/3/28.
 */
public class ExpressDao extends BaseDao<ExpressEntity, String> {

    public ExpressDao() {
        super(ExpressEntity.class);
    }

    //根据快递单号拿到快递信息
    public ExpressEntity get(String id){
        ExpressEntity expressEntity = super.get(id);
        return expressEntity;
    }
}
