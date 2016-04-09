package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.EmployeesEntity;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by violet on 2016/3/28.
 */
public class EmployeesDao extends BaseDao<EmployeesEntity, Integer> {

    public EmployeesDao() {
        super(EmployeesEntity.class);
    }

    //根据工作人员id拿到工作人员的信息
    public EmployeesEntity get(int id) {
        EmployeesEntity employeesEntity = super.get(id);
        return employeesEntity;
    }

    //更新或者插入一条新的数据
    public void save(EmployeesEntity employeesEntity) {
        super.save(employeesEntity);
    }

    //根据员工手机号拿到员工信息判断密码是否正确
    public boolean get(String tel, String password) {
        EmployeesEntity employeesEntity;
        List<EmployeesEntity> list = findBy("id", true, Restrictions.eq("telephone", tel));
        if (list.size() != 0) {
            employeesEntity = list.get(0);
            if (employeesEntity.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
