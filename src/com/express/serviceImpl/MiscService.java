package com.express.serviceImpl;

import com.express.daoImpl.*;
import com.express.model.*;
import com.express.serviceInterface.IMiscService;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by violet on 2016/3/28.
 */
public class MiscService implements IMiscService {

    private ProvinceDao provinceDao;
    private CityDao cityDao;
    private RegionDao regionDao;
    private OutletsDao outletsDao;
    private CustomerDao customerDao;
    private AddressDao addressDao;

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    public ProvinceDao getProvinceDao() {
        return provinceDao;
    }

    public void setProvinceDao(ProvinceDao provinceDao) {
        this.provinceDao = provinceDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public RegionDao getRegionDao() {
        return regionDao;
    }

    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    public OutletsDao getOutletsDao() {
        return outletsDao;
    }

    public void setOutletsDao(OutletsDao outletsDao) {
        this.outletsDao = outletsDao;
    }

    public CustomerDao getCustomerDao() {
        return customerDao;
    }

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /////////////////////////////位置信息的接口////////////////////////////


    /////////////////////////////Address的接口/////////////////////////////

    //获得用户所有的收货地址
    @Override
    public List<CustomerAddressEntity> getAccAddress(int cid) {
        List<CustomerAddressEntity> list = new ArrayList<>();
        List<AddressEntity> addresslist = addressDao.getAccAddress(cid);

        for (int i = 0; i < addresslist.size(); i++) {

            AddressEntity addressEntity = addresslist.get(i);
            CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity();

            RegionEntity region = regionDao.get(addressEntity.getRegionId());
            CityEntity city = cityDao.get(region.getCityId());
            ProvinceEntity province = provinceDao.get(city.getPid());

            customerAddressEntity.setAid(i);
            customerAddressEntity.setCustomerid(cid);
            customerAddressEntity.setName(addressEntity.getName());
            customerAddressEntity.setTelephone(addressEntity.getTelephone());
            customerAddressEntity.setProvince(province.getPname());
            customerAddressEntity.setCity(city.getCname());
            customerAddressEntity.setRegion(region.getArea());
            customerAddressEntity.setAddress(addressEntity.getAddress());
            customerAddressEntity.setRank(addressEntity.getRank());

            list.add(customerAddressEntity);
        }

        return list;
    }

    //获得用户所有的发货地址
    @Override
    public List<CustomerAddressEntity> getSendAddress(int cid) {
        List<CustomerAddressEntity> list = new ArrayList<>();
        List<AddressEntity> addressEntityList = addressDao.getSendAddress(cid);

        for (int i = 0; i < addressEntityList.size(); i++){

            AddressEntity addressEntity = addressEntityList.get(i);
            CustomerAddressEntity customerAddressEntity = new CustomerAddressEntity();

            RegionEntity region = regionDao.get(addressEntity.getRegionId());
            CityEntity city = cityDao.get(region.getCityId());
            ProvinceEntity province = provinceDao.get(city.getPid());

            customerAddressEntity.setAid(i);
            customerAddressEntity.setCustomerid(cid);
            customerAddressEntity.setName(addressEntity.getName());
            customerAddressEntity.setTelephone(addressEntity.getTelephone());
            customerAddressEntity.setProvince(province.getPname());
            customerAddressEntity.setCity(city.getCname());
            customerAddressEntity.setRegion(region.getArea());
            customerAddressEntity.setAddress(addressEntity.getAddress());
            customerAddressEntity.setRank(addressEntity.getRank());

            list.add(customerAddressEntity);
        }

        return list;
    }

    //增加一个收货地址
    @Override
    public Response newAccAddress(AddressEntity obj) {
        try {
            addressDao.save(obj);
            return Response.ok(obj).header("EntityClass", "R_Address").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    //增加一个发货地址
    @Override
    public Response newSendAddress(AddressEntity obj) {
        try {
            addressDao.save(obj);
            return Response.ok(obj).header("EntityClass", "R_Address").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    /////////////////////////////region的接口////////////////////////////


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


    /////////////////////////////////营业网点、分拣中心相关接口///////////////////////////////////
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


    /////////////////////////////工具类的接口////////////////////////////

    //验证手机号是否可用，true表示没有被注册过，可用；false表示已经被注册过，不可用
    @Override
    public boolean checkTelephone(String tel) {
        List<CustomerEntity> list = customerDao.getByTel(tel);
        if (list.size() == 0)
            return true;
        return false;
    }
}
