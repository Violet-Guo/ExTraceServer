package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.CustomerEntity;
import org.hibernate.criterion.Restrictions;

import java.util.List;

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

    //根据用户手机号拿到用户信息判断密码是否正确
    public boolean get(String tel, String password){
        CustomerEntity customerEntity;
        List<CustomerEntity> list = findBy("id", true, Restrictions.eq("telephone", tel));
        if (list.size() != 0){
            customerEntity = list.get(0);
            if (customerEntity.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    //更新或者插入一条新的数据
    public void save(CustomerEntity customerEntity){
        super.save(customerEntity);
    }

    //验证手机号是否可用，true表示没有被注册过，可用；false表示已经被注册过，不可用
    public boolean checkTelphone(String tel){
        List<CustomerEntity> list = null;
        list = findBy("id", true, Restrictions.eq("telephone", tel));
        if (0==list.size()){
            return true;
        }
        return false;
    }

}
