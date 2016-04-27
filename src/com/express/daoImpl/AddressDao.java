package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.AddressEntity;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by violet on 2016/3/28.
 */
public class AddressDao extends BaseDao<AddressEntity, Integer> {

    public AddressDao() {
        super(AddressEntity.class);
    }

    //////////////////status=1代表是自己的地址，status=2代表是收件人的地址////////////

    //更新或者插入一条新的数据
    public void save(AddressEntity addressEntity) {
        super.save(addressEntity);
    }

    /**
     * 获得一个用户的所有收件人地址
     * @param cid 用户的id
     * @return Address实体
     */
    public List<AddressEntity> getAccAddress(int cid){
        List<AddressEntity> list = findBy("id", true, Restrictions.eq("customerId", cid), Restrictions.eq("status",2));
        return list;
    }

    /**
     * 获得一个用户的所有发件人地址
     * @param cid 用户的id
     * @return Address实体
     */
    public List<AddressEntity> getSendAddress(int cid){
        List<AddressEntity> list = findBy("id", true, Restrictions.eq("customerId", cid), Restrictions.eq("status", 1));
        return list;
    }

    /**
     * 根据用户的id和地址状态查找地址信息
     * @param cusid
     * @param rank
     * @return
     */
    public List<AddressEntity> findByCusIdAndRank(int cusid, int rank){
        List<AddressEntity> list = findBy("id", true, Restrictions.eq("customerId", cusid), Restrictions.eq("rank", rank));
        return list;
    }

}
