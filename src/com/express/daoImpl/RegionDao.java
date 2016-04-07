package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.RegionEntity;


/**
 * Created by violet on 2016/3/28.
 */
public class RegionDao extends BaseDao<RegionEntity, Integer>{

    public RegionDao() {
        super(RegionEntity.class);
    }

    //根据id拿到区域
    public RegionEntity get(int id){
        RegionEntity regionEntity = super.get(id);
        return regionEntity;
    }
}
