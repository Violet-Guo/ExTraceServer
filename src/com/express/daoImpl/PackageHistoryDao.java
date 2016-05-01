package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.PackagehistoryEntity;

/**
 * Created by Nvpiao on 2016/4/26 0026.
 */
public class PackageHistoryDao extends BaseDao<PackagehistoryEntity, Integer> {

    public PackageHistoryDao() {
        super(PackagehistoryEntity.class);
    }
}
