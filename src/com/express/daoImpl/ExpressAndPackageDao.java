package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.ExpressandpackageEntity;

/**
 * Created by Nvpiao on 2016/4/18 0018.
 */
public class ExpressAndPackageDao extends BaseDao<ExpressandpackageEntity, String> {

    public ExpressAndPackageDao() {
        super(ExpressandpackageEntity.class);
    }

    //更新或者插入一条新的数据
    public void save(ExpressandpackageEntity expressandpackageEntity) {
        super.save(expressandpackageEntity);
    }
}
