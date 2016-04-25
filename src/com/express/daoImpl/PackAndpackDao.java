package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.PackandpackEntity;

/**
 * Created by Nvpiao on 2016/4/18 0018.
 */
public class PackAndpackDao extends BaseDao<PackandpackEntity, String> {

    public PackAndpackDao() {
        super(PackandpackEntity.class);
    }

    //更新或者插入一条新的数据
    public void save(PackandpackEntity packandpackEntity) {
        super.save(packandpackEntity);
    }
}
