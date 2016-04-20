package com.express.serviceImpl;

import com.express.daoImpl.AddressDao;
import com.express.daoImpl.CustomerDao;
import com.express.daoImpl.EmployeesDao;
import com.express.daoImpl.ExpressDao;
import com.express.model.*;
import com.express.serviceInterface.IDomainService;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by violet on 2016/4/6.
 */
public class DomainService implements IDomainService {

    private ExpressDao expressDao;
    private EmployeesDao employeesDao;
    private AddressDao addressDao;
    private CustomerDao customerDao;

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public EmployeesDao getEmployeesDao() {
        return employeesDao;
    }

    public void setEmployeesDao(EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }

    public ExpressDao getExpressDao() {
        return expressDao;
    }

    public void setExpressDao(ExpressDao expressDao) {
        this.expressDao = expressDao;
    }

    /////////////////////////////公共的接口（用户和工作人员都要用的）////////////////////////////

    @Override
    public ExpressEntity getExpressInfoById(String id) {
        return null;
    }

    @Override
    public Response saveExpress(ExpressEntity obj) {
        return null;
    }


    /////////////////////////////用户的接口////////////////////////////

    //通过用户id获得用户信息
    @Override
    public CustomerEntity getCustomerInfoById(int id) {
        return customerDao.get(id);
    }

    //注册，并在注册过程中检查手机号是否注册过
    @Override
    public String registerByCus(CustomerEntity obj) {
        List<CustomerEntity> list = customerDao.getByTel(obj.getTelephone());
        if (list.size() == 0) {
            try {
                customerDao.save(obj);
                return "{\"registerstate\":\"true\"}";
            } catch (Exception e) {
                e.printStackTrace();
                return "{\"registerstate\":\"false\"}";
            }
        } else {
            return "{\"registerstate\":\"deny\"}";
        }
    }

    //更新或者是插入一条数据
    @Override
    public Response saveCustomerInfo(CustomerEntity obj) {
        try {
            customerDao.save(obj);
            return Response.ok(obj).header("EntityClass", "R_CustomerInfo").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    //根据用户id删除用户信息
    @Override
    public Response deleteCustomerInfo(int id) {
        customerDao.removeById(id);
        return Response.ok("Deleted").header("EntityClass", "D_CustomerInfo").build();
    }

    //用户登陆post方法
    @Override
    public String login(CustomerEntity obj) {
        List<CustomerEntity> list = customerDao.getByTel(obj.getTelephone());
        if (list.size() != 0) {
            CustomerEntity customerEntity = list.get(0);
            if (customerEntity.getPassword().equals(obj.getPassword())) {
                return "{\"name\":\"" + customerEntity.getName() + "\", \"loginstate\":\"true\"}";
            }
        }
        return "{\"loginstate\":\"false\"}";
    }

    //注销登陆
    @Override
    public void doLogOut(int cid) {

    }

    @Override
    public Response createExpress(String id, int cid) {
        return null;
    }

    /////////////////////////////工作人员的公共接口////////////////////////////

    //通过工作人员id查找工作人员信息
    @Override
    public EmployeesEntity getEmployeeInfoById(int id) {
        return employeesDao.get(id);
    }

    //更新或者是插入一条数据
    @Override
    public Response saveEmployeeInfo(EmployeesEntity obj) {
        try {
            employeesDao.save(obj);
            return Response.ok(obj).header("EntityClass", "R_EmployeeInfo").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    //删除员工信息
    @Override
    public Response deleteEmployee(int id) {
        employeesDao.removeById(id);
        return Response.ok("Deleted").header("EntityClass", "D_Employee").build();
    }

    //员工通过手机号和密码登陆
    @Override
    public boolean doLoginByEmployee(String tel, String pwd) {
        List<EmployeesEntity> list = employeesDao.getByTel(tel);
        EmployeesEntity employeesEntity = new EmployeesEntity();
        if (list.size() != 0) {
            employeesEntity = list.get(0);
            if (employeesEntity.getPassword().equals(pwd)) {
                return true;
            }
        }
        return false;
    }

    //员工注销登陆
    @Override
    public void doLogOutByEmployee(int id) {

    }

    @Override
    public Response savePackage(PackageEntity obj) {
        return null;
    }

    @Override
    public ExpressEntity getPackageById(int pid) {
        return null;
    }

    /////////////////////////////快递员的接口////////////////////////////


    /////////////////////////////分拣员的接口////////////////////////////
}
