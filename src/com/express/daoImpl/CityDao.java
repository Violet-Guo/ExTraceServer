package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.CityEntity;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by violet on 2016/4/7.
 */
public class CityDao extends BaseDao<CityEntity, Integer> {

    public CityDao() {
        super(CityEntity.class);
    }

    //根据id拿到市
    public CityEntity get(int id) {
        CityEntity cityEntity = super.get(id);
        return cityEntity;
    }

    //根据省的id拿到市的信息
    public List<CityEntity> getCityList(int id) {
        List<CityEntity> list = findBy("cid", true, Restrictions.eq("pid", id));
        return list;
    }
}
