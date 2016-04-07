package com.express.daoImpl;

import com.express.daoBase.BaseDao;
import com.express.model.EmployeesEntity;

/**
 * Created by violet on 2016/3/28.
 */
public class EmployeesDao extends BaseDao<EmployeesEntity, Integer> {

    //根据工作人员id拿到工作人员的信息
    public EmployeesEntity get(int id){
        EmployeesEntity employeesEntity = super.get(id);
        return employeesEntity;
    }
}
