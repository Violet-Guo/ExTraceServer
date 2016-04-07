package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.ProvinceEntity;

import java.util.List;

/**
 * Created by violet on 2016/4/7.
 */
public class ProvinceDao extends BaseDao<ProvinceEntity, Integer> {

    public ProvinceDao() {
        super(ProvinceEntity.class);
    }

    //根据id拿到省份
    public ProvinceEntity get(int id){
        ProvinceEntity provinceEntity = super.get(id);
        return provinceEntity;
    }

    //获得所有的省份
    public List<ProvinceEntity> getAllProvince(){
        return super.getAll();
    }

}
