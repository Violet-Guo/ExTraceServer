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

    //根据员工的手机号找到员工信息
    public List<EmployeesEntity> getByTel(String tel) {
        return findBy("id", true, Restrictions.eq("telephone", tel));
    }

    //更新员工信息
    public void update(EmployeesEntity employeesEntity) {
        super.update(employeesEntity);
    }
}
