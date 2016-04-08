package com.express.serviceImpl;

import com.express.daoImpl.*;
import com.express.model.*;
import com.express.serviceInterface.IMiscService;

import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Created by violet on 2016/3/28.
 */
public class MiscService implements IMiscService {

    private CustomerDao customerDao;
    private ExpressDao expressDao;
    private EmployeesDao employeesDao;
    private ProvinceDao provinceDao;
    private RegionDao regionDao;
    private AddressDao addressDao;
    private CityDao cityDao;
    private OutletsDao outletsDao;

    public OutletsDao getOutletsDao() {
        return outletsDao;
    }

    public void setOutletsDao(OutletsDao outletsDao) {
        this.outletsDao = outletsDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public RegionDao getRegionDao() {
        return regionDao;
    }

    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    public ProvinceDao getProvinceDao() {
        return provinceDao;
    }

    public void setProvinceDao(ProvinceDao provinceDao) {
        this.provinceDao = provinceDao;
    }

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

    //更新或者是插入一条数据
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
    public boolean doLogin(String tel, String pwd) {
        return customerDao.get(tel, pwd);
    }

    //注销登陆
    @Override
    public void doLogOut(int cid) {

    }


    //验证手机号是否可用，true表示没有被注册过，可用；false表示已经被注册过，不可用
    @Override
    public boolean checkTelephone(String tel) {
        return customerDao.checkTelphone(tel);
    }

    ///////////////////////////关于工作人员信息的接口////////////////////////////

    //通过工作人员id查找工作人员信息
    @Override
    public EmployeesEntity getEmployeeInfoById(int id) {
        return employeesDao.get(id);
    }

    //更新或者是插入一条数据
    @Override
    public Response saveEmployeeInfo(EmployeesEntity obj) {
        try{
            employeesDao.save(obj);
            return Response.ok(obj).header("EntityClass", "R_EmployeeInfo").build();
        }
        catch(Exception e) {
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
        return employeesDao.get(tel, pwd);
    }

    //员工注销登陆
    @Override
    public void doLogOutByEmployee(int id) {

    }


    ///////////////////////////关于获取地区信息的接口////////////////////////////

    //获得所有的省份
    @Override
    public List<ProvinceEntity> getAllProvince() {
        return provinceDao.getAllProvince();
    }

    //根据省的id拿到所有的市
    @Override
    public List<CityEntity> getCityList(int pid) {
        return cityDao.getCityList(pid);
    }

    //根据市的id拿到所有的区域
    @Override
    public List<RegionEntity> getRegionList(int cid) {
        return regionDao.getRegionList(cid);
    }

    //根据id查找省
    @Override
    public ProvinceEntity getProvinceById(int id) {
        return provinceDao.get(id);
    }

    //根据id查找市
    @Override
    public CityEntity getCityById(int id) {
        return cityDao.get(id);
    }

    //根据id查找区域
    @Override
    public RegionEntity getRegionById(int id) {
        return regionDao.get(id);
    }

    //用户增加、更改地区
    @Override
    public Response saveAddressbyCus(AddressEntity obj) {
        try{
            addressDao.save(obj);
            return Response.ok(obj).header("EntityClass", "R_Address").build();
        }
        catch(Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }


    /////////////////////////////////营业网点、分拣中心信息///////////////////////////////////
    ////////////////////////////营业网点type = 1， 分拣中心type = 2//////////////////////////////

    //根据id获得营业网点的信息
    @Override
    public OutletsEntity getBranchById(int id) {
        return outletsDao.getBranchById(id);
    }

    //根据id获得分拣中心的信息
    @Override
    public OutletsEntity getSortingCenterById(int id) {
        return outletsDao.getSortingCenterById(id);
    }

    //获得某一区域的所有营业网点信息
    @Override
    public List<OutletsEntity> getAllBranchByRegionId(int id) {
        return outletsDao.getAllBranchByRegionId(id);
    }

    //获得某一区域的所有分拣中心信息
    @Override
    public List<OutletsEntity> getAllSCenterByRegionId(int id) {
        return outletsDao.getAllSCenterByRegionId(id);
    }

    //获得所有的营业网点的信息
    @Override
    public List<OutletsEntity> getAllBranch() {
        return outletsDao.getAllBranch();
    }

    //获得所有的分拣中心的信息
    @Override
    public List<OutletsEntity> getAllSortCenter() {
        return outletsDao.getAllSortCenter();
    }

    //获得所有的分拣中心+营业网点的信息
    @Override
    public List<OutletsEntity> getAllOutlets() {
        return outletsDao.getAllOutlets();
    }


}
