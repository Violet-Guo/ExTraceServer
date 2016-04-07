package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.CustomerEntity;

/**
 * Created by violet on 2016/3/28.
 */
public class CustomerDao extends BaseDao<CustomerEntity, Integer> {

    public CustomerDao() {
        super(CustomerEntity.class);
    }

    //根据用户id拿到用户信息
    public CustomerEntity get(int id){
        CustomerEntity customerEntity = super.get(id);
        return customerEntity;
    }

    public void save(CustomerEntity customerEntity){
        super.save(customerEntity);
    }

}
