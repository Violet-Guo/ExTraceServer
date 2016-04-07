package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.CityEntity;

/**
 * Created by violet on 2016/4/7.
 */
public class CityDao extends BaseDao<CityEntity, Integer> {

    public CityDao() {
        super(CityEntity.class);
    }

    //根据id拿到市
    public CityEntity get(int id){
        CityEntity cityEntity = super.get(id);
        return cityEntity;
    }
}
