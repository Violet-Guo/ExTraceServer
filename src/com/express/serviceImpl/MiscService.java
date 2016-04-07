package com.express.serviceImpl;

import com.express.daoImpl.CustomerDao;
import com.express.daoImpl.EmployeesDao;
import com.express.daoImpl.ExpressDao;
import com.express.model.CustomerEntity;
import com.express.model.EmployeesEntity;
import com.express.serviceInterface.IMiscService;

import javax.ws.rs.core.Response;


/**
 * Created by violet on 2016/3/28.
 */
public class MiscService implements IMiscService {

    private CustomerDao customerDao;
    private ExpressDao expressDao;
    private EmployeesDao employeesDao;

    public ExpressDao getExpressDao() {
        return expressDao;
    }

    public void setExpressDao(ExpressDao expressDao) {
        this.expressDao = expressDao;
    }

    public EmployeesDao getEmployeesDao() {
        return employeesDao;
    }

    public void setEmployeesDao(EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }



    /////////////////////////////关于用户信息的接口////////////////////////////

    //通过用户id获得用户信息
    @Override
    public CustomerEntity getCustomerInfoById(int id) {
        return customerDao.get(id);
    }

    @Override
    public Response saveCustomerInfo(CustomerEntity obj) {
        try{
            customerDao.save(obj);
            return Response.ok(obj).header("EntityClass", "R_CustomerInfo").build();
        }
        catch(Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    //根据用户id删除用户信息
    @Override
    public Response deleteCustomerInfo(int id) {
        customerDao.removeById(id);
        return Response.ok("Deleted").header("EntityClass", "D_CustomerInfo").build();
    }

    //登陆
    @Override
    public boolean doLogin(int cid, String pwd) {

        return false;
    }

    //注销登陆
    @Override
    public void doLogOut(int cid) {

    }

    ///////////////////////////关于工作人员信息的接口////////////////////////////

    //通过工作人员id查找工作人员信息
    @Override
    public EmployeesEntity getEmployeeInfoById(int id) {
        return employeesDao.get(id);
    }

    @Override
    public Response saveEmployeeInfo(EmployeesEntity obj) {
        return null;
    }


}
