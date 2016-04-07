package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.PackageEntity;

/**
 * Created by violet on 2016/3/28.
 */
public class PackageDao extends BaseDao<PackageEntity, String>{

    public PackageDao() {
        super(PackageEntity.class);
    }
}
