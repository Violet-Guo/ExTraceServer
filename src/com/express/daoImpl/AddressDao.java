package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.AddressEntity;

/**
 * Created by violet on 2016/3/28.
 */
public class AddressDao extends BaseDao<AddressEntity, Integer> {

    public AddressDao() {
        super(AddressEntity.class);
    }

    //更新或者插入一条新的数据
    public void save(AddressEntity addressEntity) {
        super.save(addressEntity);
    }
}
