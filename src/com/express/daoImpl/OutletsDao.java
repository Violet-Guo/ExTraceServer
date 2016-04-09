package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.OutletsEntity;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by violet on 2016/4/8.
 */
public class OutletsDao extends BaseDao<OutletsEntity, Integer> {
    public OutletsDao() {
        super(OutletsEntity.class);
    }

    //根据id获得营业网点的信息
    public OutletsEntity getBranchById(int id) {
        List<OutletsEntity> list = findBy("id", true, Restrictions.eq("id", id), Restrictions.eq("type", 1));
        return list.get(0);
    }

    //根据id获得分拣中心的信息
    public OutletsEntity getSortingCenterById(int id) {
        List<OutletsEntity> list = findBy("id", true, Restrictions.eq("id", id), Restrictions.eq("type", 2));
        return list.get(0);
    }

    //获得某一区域的所有营业网点信息
    public List<OutletsEntity> getAllBranchByRegionId(int id) {
        List<OutletsEntity> list = findBy("id", true, Restrictions.eq("regionId", id), Restrictions.eq("type", 1));
        return list;
    }

    //获得某一区域的所有分拣中心信息
    public List<OutletsEntity> getAllSCenterByRegionId(int id) {
        List<OutletsEntity> list = findBy("id", true, Restrictions.eq("regionId", id), Restrictions.eq("type", 2));
        return list;
    }

    //获得所有的营业网点的信息
    public List<OutletsEntity> getAllBranch() {
        List<OutletsEntity> list = findBy("id", true, Restrictions.eq("type", 1));
        return list;
    }

    //获得所有的分拣中心的信息
    public List<OutletsEntity> getAllSortCenter() {
        List<OutletsEntity> list = findBy("id", true, Restrictions.eq("type", 2));
        return list;
    }

    //获得所有的分拣中心+营业网点的信息
    public List<OutletsEntity> getAllOutlets() {
        return super.getAll();
    }

}
