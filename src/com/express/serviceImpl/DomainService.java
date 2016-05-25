package com.express.serviceImpl;

import com.express.daoImpl.*;
import com.express.info.EmployeeInfo;
import com.express.info.ExpressInfo;
import com.express.info.ExpresslogisticsInfo;
import com.express.info.PackageInfo;
import com.express.model.*;
import com.express.serviceInterface.IDomainService;
import org.hibernate.criterion.Restrictions;
import utils.Authentication;
import utils.Utils;

import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by violet on 2016/4/6.
 */
public class DomainService implements IDomainService {

    private WordDao wordDao;
    private OutletsDao outletsDao;
    private PackageHistoryDao packageHistoryDao;
    private RegionDao regionDao;
    private CityDao cityDao;
    private ProvinceDao provinceDao;
    private PackAndpackDao packAndpackDao;
    private ExpressAndPackageDao expressAndPackageDao;
    private PackageDao packageDao;
    private ExpressDao expressDao;
    private EmployeesDao employeesDao;
    private AddressDao addressDao;
    private CustomerDao customerDao;
    private Authentication au = Authentication.getInstance();

    public WordDao getWordDao() {
        return wordDao;
    }

    public void setWordDao(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    public OutletsDao getOutletsDao() {
        return outletsDao;
    }

    public void setOutletsDao(OutletsDao outletsDao) {
        this.outletsDao = outletsDao;
    }

    public PackageHistoryDao getPackageHistoryDao() {
        return packageHistoryDao;
    }

    public void setPackageHistoryDao(PackageHistoryDao packageHistoryDao) {
        this.packageHistoryDao = packageHistoryDao;
    }

    public RegionDao getRegionDao() {
        return regionDao;
    }

    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public ProvinceDao getProvinceDao() {
        return provinceDao;
    }

    public void setProvinceDao(ProvinceDao provinceDao) {
        this.provinceDao = provinceDao;
    }

    public PackAndpackDao getPackAndpackDao() {
        return packAndpackDao;
    }

    public void setPackAndpackDao(PackAndpackDao packAndpackDao) {
        this.packAndpackDao = packAndpackDao;
    }

    public ExpressAndPackageDao getExpressAndPackageDao() {
        return expressAndPackageDao;
    }

    public void setExpressAndPackageDao(ExpressAndPackageDao expressAndPackageDao) {
        this.expressAndPackageDao = expressAndPackageDao;
    }

    public PackageDao getPackageDao() {
        return packageDao;
    }

    public void setPackageDao(PackageDao packageDao) {
        this.packageDao = packageDao;
    }

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
    public List<EmployeeInfo> getSendEmployeesInfos(String expressId, String token) {
        if (!au.verify(token))
            return null;

        List<EmployeeInfo> lists = new ArrayList<>();

        //获得快递实体
        ExpressEntity expressEntity = expressDao.get(expressId);
        //如果是包裹,否则没有人持有
        if (expressEntity.getIsPackage() == 1) {
            //获取包裹路程中的物流信息
            List<ExpressandpackageEntity> by = expressAndPackageDao.findBy("expressId", true, Restrictions.eq("expressId", expressId));
            //获取揽收状态
            PackageEntity firstPackageEntity = packageDao.get(by.get(0).getPackageId());
            EmployeesEntity firstEmployeesEntity = employeesDao.get(firstPackageEntity.getEmployeesId());
            //设置揽收人
            EmployeeInfo employeeInfo = new EmployeeInfo();
            employeeInfo.setEmployeeId(firstEmployeesEntity.getId());
            employeeInfo.setJob(firstEmployeesEntity.getJob());
            lists.add(employeeInfo);

            //获取包裹的信息。判断是否已经结束了。
            EmployeeInfo lastEmployeeInfo = null;
            int last = by.size();
            if (last > 1) {
                PackageEntity lastPackageEntity = packageDao.get(by.get(last - 1).getPackageId());
                EmployeesEntity lastEmployeesEntity = employeesDao.get(lastPackageEntity.getEmployeesId());
                if (lastEmployeesEntity.getSendPackageId().equals(lastPackageEntity.getId())) {
                    //相等说明是派送的
                    lastEmployeeInfo = new EmployeeInfo();
                    lastEmployeeInfo.setEmployeeId(lastEmployeesEntity.getId());
                    lastEmployeeInfo.setJob(lastEmployeesEntity.getJob());
                    //减去最后一个包裹信息
                    --last;
                }
                for (int i = 1; i < last; ++i) {
                    //司机
                    EmployeeInfo employee = new EmployeeInfo();
                    List<EmployeesEntity> employeesEntities = employeesDao.findBy("sendPackageId", true, Restrictions.eq("sendPackageId", by.get(i).getPackageId()));
                    employee.setEmployeeId(employeesEntities.get(0).getId());
                    employee.setJob(employeesEntities.get(0).getJob());
                    lists.add(employee);
                }
            }
            if (lastEmployeeInfo != null)
                lists.add(lastEmployeeInfo);
        }
        return lists;
    }

    @Override
    public String setDriverPackage(Integer employeeId, String packageId, String token) {
        if (!au.verify(token))
            return null;
        try {
            //获取司机实体对象
            EmployeesEntity employeesEntity = employeesDao.get(employeeId);
            employeesEntity.setSendPackageId(packageId);
            employeesDao.update(employeesEntity);
            return "{\"state\":\"" + 1 + "\"}";
        } catch (Exception e) {
            return "{\"state\":\"" + 0 + "\"}";
        }
    }

    @Override
    public String openPackageByPackageId(String packageId, String token) {
        if (!au.verify(token))
            return null;
        try {
            //获取包裹实体对象
            PackageEntity packageEntity = packageDao.get(packageId);
            packageEntity.setIsHistory(1);
            packageDao.update(packageEntity);
            return "{\"state\":\"" + 1 + "\"}";
        } catch (Exception e) {
            return "{\"state\":\"" + 0 + "\"}";
        }
    }

    @Override
    public String updateExpressFree(ExpressEntity expressEntity) {
        try {
            //获取快递实体对象
            ExpressEntity entity = expressDao.get(expressEntity.getId());
            entity.setWeight(expressEntity.getWeight());
            entity.setTranFee(expressEntity.getTranFee());
            entity.setInsuFee(expressEntity.getInsuFee());
            expressDao.update(entity);
            return "{\"state\":\"" + 1 + "\"}";
        } catch (Exception e) {
            return "{\"state\":\"" + 0 + "\"}";
        }
    }

    @Override
    public List<ExpresslogisticsInfo> getExpresslogisticsInfosByExpressId(String expressId, String token) {
        if (!au.verify(token))
            return null;
        List<WordEntity> allWord = wordDao.getAll();
        List<ExpresslogisticsInfo> lists = new ArrayList<>();

        //获得快递实体
        ExpressEntity expressEntity = expressDao.get(expressId);
        //如果不是包裹
        if (expressEntity.getIsPackage() == 0) {
            ExpresslogisticsInfo expresslogisticsInfo = new ExpresslogisticsInfo();
            expresslogisticsInfo.setState(1);
            expresslogisticsInfo.setInfo(wordDao.get(2).getValue());
            lists.add(expresslogisticsInfo);
        } else if (expressEntity.getIsPackage() == 1) {
            //获取包裹路程中的物流信息
            List<ExpressandpackageEntity> by = expressAndPackageDao.findBy("expressId", true, Restrictions.eq("expressId", expressId));
            //获取揽收状态
            PackageEntity firstPackageEntity = packageDao.get(by.get(0).getPackageId());
            EmployeesEntity firstEmployeesEntity = employeesDao.get(firstPackageEntity.getEmployeesId());
            //设置揽收信息
            ExpresslogisticsInfo expresslogisticsInfo = new ExpresslogisticsInfo();
            expresslogisticsInfo.setState(2);
            expresslogisticsInfo.setInfo(wordDao.get(4).getValue() + firstEmployeesEntity.getName() + wordDao.get(5).getValue());
            expresslogisticsInfo.setTime(Utils.dateToString(expressEntity.getGetTime()));
            lists.add(expresslogisticsInfo);

            //获取包裹的信息。判断是否已经结束了。
            ExpresslogisticsInfo lastExpressInfo = null;
            int last = by.size();
            if (last > 1) {
                PackageEntity lastPackageEntity = packageDao.get(by.get(last - 1).getPackageId());
                EmployeesEntity lastEmployeesEntity = employeesDao.get(lastPackageEntity.getEmployeesId());
//                CustomerEntity lastCustomerEntity = customerDao.get(lastPackageEntity.getEmployeesId());
                if (lastEmployeesEntity.getSendPackageId().equals(lastPackageEntity.getId())) {
                    //相等说明是派送的
                    lastExpressInfo = new ExpresslogisticsInfo();
                    lastExpressInfo.setTime(Utils.dateToString(by.get(last - 1).getTime()));
                    lastExpressInfo.setState(3);
                    lastExpressInfo.setInfo(lastEmployeesEntity.getName() + wordDao.get(7).getValue());
                    //减去最后一个包裹信息
                    --last;
                }
                for (int i = 1; i < last; ++i) {
                    //要判断最后的包裹是不是发送的包裹
                    ExpresslogisticsInfo express = new ExpresslogisticsInfo();

                    List<PackagehistoryEntity> hisBy = packageHistoryDao.findBy("time", true, Restrictions.eq("packageId", by.get(i).getPackageId()));
                    List<OutletsEntity> fromOutLetBy = outletsDao.findBy("id", true, Restrictions.eq("id", hisBy.get(0).getFromOutletsId()));
                    List<OutletsEntity> toOutLetBy = outletsDao.findBy("id", true, Restrictions.eq("id", hisBy.get(0).getToOutletsId()));
                    //添加包裹信息
                    express.setTime(Utils.dateToString(by.get(i).getTime()));
                    express.setState(4);
                    express.setInfo(wordDao.get(9).getValue() + fromOutLetBy.get(0).getName() + wordDao.get(10).getValue() + toOutLetBy.get(0).getName());

                    lists.add(express);
                }
            }
            if (lastExpressInfo != null)
                lists.add(lastExpressInfo);
            //判断快递是否已经被签收
            if (expressEntity.getOutTime() != null) {
                ExpresslogisticsInfo recvExpress = new ExpresslogisticsInfo();
                recvExpress.setTime(Utils.dateToString(expressEntity.getOutTime()));
                recvExpress.setState(5);
                recvExpress.setInfo(wordDao.get(12).getValue());
                lists.add(recvExpress);
            }
        }

        return lists;
    }

    @Override
    public Integer PackageLoadIntoPackage(List<String> packageIds) {
        //获得包裹id
        String packageId = packageIds.get(0);
        //遍历剩下的id存入关系表
        for (int i = 1; i < packageIds.size(); ++i) {
            //存入快递快递表
            PackandpackEntity packandpackEntity = new PackandpackEntity();
            packandpackEntity.setIsHistory(0);
            packandpackEntity.setPackageId(packageIds.get(i));
            packandpackEntity.setParentId(packageId);
            packAndpackDao.save(packandpackEntity);
        }
        return 1;
    }

    @Override
    public Integer ExpressLoadIntoPackage(List<String> expressIds) {
        //获得包裹id
        String packageId = expressIds.get(0);
        //遍历剩下的id存入关系表
        for (int i = 1; i < expressIds.size(); ++i) {
            //存入包裹快递表
            ExpressandpackageEntity expressandpackageEntity = new ExpressandpackageEntity();
            expressandpackageEntity.setTime(new Date());
            expressandpackageEntity.setPackageId(packageId);
            expressandpackageEntity.setExpressId(expressIds.get(i));
            expressAndPackageDao.save(expressandpackageEntity);
        }
        return 1;
    }

    @Override
    public PackageInfo getPackageInfo(String packageId, String token) {
        if (!au.verify(token))
            return null;
        //创建一个包裹的信息对象
        PackageInfo packageInfo = new PackageInfo();
        //获取包裹的对象实体
        PackageEntity packageEntity = packageDao.get(packageId);
        //获取包裹历史的对象实体
        List<PackagehistoryEntity> by = packageHistoryDao.findBy("time", true, Restrictions.eq("packageId", packageEntity.getId()));
        PackagehistoryEntity packagehistoryEntity = by.get(by.size() - 1);
        //获取出发和到达站点对象
        OutletsEntity fromOutletsEntity = outletsDao.get(packagehistoryEntity.getFromOutletsId());
        OutletsEntity toOutletsEntity = outletsDao.get(packagehistoryEntity.getToOutletsId());
        //获取用户对象

        EmployeesEntity employeesEntity = employeesDao.get(packageEntity.getEmployeesId());

        //填充数据
        packageInfo.setId(packageEntity.getId());
        packageInfo.setPackageFrom(fromOutletsEntity.getName());
        packageInfo.setPackageTo(toOutletsEntity.getName());
        packageInfo.setEmployeesName(employeesEntity.getName());
        packageInfo.setEmployeesID(packageEntity.getEmployeesId());
        packageInfo.setCloseTime(packageEntity.getTime().toString());

        return packageInfo;
    }

    @Override
    public String PrepareSendExpress(Integer customerId, Integer sendAddressId, Integer recvAddressId, String token) {
        if (!au.verify(token))
            return null;
        ExpressEntity expressEntity = new ExpressEntity();

        //获取id 校验是否存在
        String packageId = Utils.getUUid();
        while (true) {
            List<PackageEntity> by = packageDao.findBy("id", true, Restrictions.eq("id", packageId));
            if (by.size() == 0)
                break;
            else
                packageId = Utils.getUUid();
        }

        //填充实体信息
        expressEntity.setId(packageId);
        expressEntity.setSendAddressId(sendAddressId);
        expressEntity.setAccAddressId(recvAddressId);

        //外键约束，必须带用户id
        expressEntity.setCustomerId(customerId);

        expressDao.save(expressEntity);

        //返回实体对象
        return "{\"state\":\"" + expressEntity.getId() + "\"}";
    }

    @Override
    public PackageInfo CreateAPackage(Integer fromID, Integer toID, Integer employeesID, Integer isSorter, String token) {
        if (!au.verify(token))
            return null;
        PackageEntity packageEntity = new PackageEntity();
        PackageInfo packageInfo = new PackageInfo();

        //获取id 校验是否存在
        String packageId = Utils.getUUid();
        while (true) {
            List<PackageEntity> by = packageDao.findBy("id", true, Restrictions.eq("id", packageId));
            if (by.size() == 0) {
                break;
            } else {
                packageId = Utils.getUUid();
            }
        }

        EmployeesEntity employeesEntity = employeesDao.get(employeesID);

        //填充实体信息
        packageEntity.setTime(new Date());
        packageEntity.setId(packageId);
        packageEntity.setEmployeesId(employeesID);
        packageEntity.setIsHistory(0);
        packageDao.save(packageEntity);

        packageInfo.setId(packageId);
        packageInfo.setCloseTime(new Date().toString());
        packageInfo.setEmployeesID(employeesID);
        packageInfo.setEmployeesName(employeesEntity.getName());

        //分拣员
        if (isSorter == 1) {
            OutletsEntity fromOutletsEntity = outletsDao.get(fromID);
            OutletsEntity toOutletsEntity = outletsDao.get(toID);

            packageInfo.setPackageFrom(fromOutletsEntity.getName());
            packageInfo.setPackageTo(toOutletsEntity.getName());

            PackagehistoryEntity packagehistoryEntity = new PackagehistoryEntity();
            packagehistoryEntity.setPackageId(packageId);
            packagehistoryEntity.setFromOutletsId(fromID);
            packagehistoryEntity.setToOutletsId(toID);
            packagehistoryEntity.setTime(new Date());

            packageHistoryDao.save(packagehistoryEntity);
        } else if (isSorter == 0) {
            //快递员
            if (fromID == 1) {
                //派送包
//                PackagehistoryEntity packagehistoryEntity = new PackagehistoryEntity();
//                packagehistoryEntity.setPackageId(packageId);
//                packagehistoryEntity.setFromOutletsId(-1);//表示是派送包
//                packagehistoryEntity.setTime(new Date());

//                packageHistoryDao.save(packagehistoryEntity);

                employeesEntity.setSendPackageId(packageId);
                if (employeesEntity.getSendPackageId() != null) {
                    //如果以前有包则将以前的包设为历史
                    PackageEntity prePackage = packageDao.get(employeesEntity.getSendPackageId());
                    prePackage.setIsHistory(1);
                    packageDao.update(prePackage);
                }
            } else if (fromID == 0) {
                //揽收包
                employeesEntity.setRecvPackageId(packageId);
                if (employeesEntity.getSendPackageId() != null) {
                    //如果以前有包则将以前的包设为历史
                    PackageEntity prePackage = packageDao.get(employeesEntity.getRecvPackageId());
                    prePackage.setIsHistory(1);
                    packageDao.update(prePackage);
                }
            }
            employeesDao.update(employeesEntity);
        }

        return packageInfo;
    }

    @Override
    public String LoadIntoPackage(String PackageId, String Id, Integer isPackage, String token) {
        if (!au.verify(token))
            return null;
        try {
            //如果不是包裹
            if (isPackage == 0) {
                ExpressandpackageEntity expressandpackageEntity = new ExpressandpackageEntity();
                expressandpackageEntity.setPackageId(PackageId);
                expressandpackageEntity.setExpressId(Id);
                expressandpackageEntity.setTime(new Date());
                expressAndPackageDao.save(expressandpackageEntity);
            } else if (isPackage == 1) {
                PackandpackEntity packandpackEntity = new PackandpackEntity();
                //如果是包裹存储父包裹表
                packandpackEntity.setParentId(PackageId);
                packandpackEntity.setPackageId(Id);
                //不是历史
                packandpackEntity.setIsHistory(0);
                packAndpackDao.save(packandpackEntity);
            }
            return "{\"state\":\"" + 1 + "\"}";
        } catch (Exception e) {
            return "{\"state\":\"" + 0 + "\"}";
        }
    }

    @Override
    public List<ExpressInfo> searchExpressInPackageById(String PackageId, String token) {
        if (!au.verify(token))
            return null;
        List<ExpressInfo> lists = new ArrayList<>();
        //按照条件查找相应的包裹里所有快件
        List<ExpressandpackageEntity> all = expressAndPackageDao.findBy("packageId", true, Restrictions.eq("packageId", PackageId));
        for (int i = 0; i < all.size(); ++i) {
            String expressId = all.get(i).getExpressId();
            //保存快递
            lists.add(getExpressInfoById(expressId, token));
        }
        return lists;
    }

    @Override
    public ExpressInfo getExpressInfoById(String id, String token) {
        if (!au.verify(token))
            return null;
        //返回快递对象实体
        ExpressInfo expressInfo = new ExpressInfo();
        //获取快递信息
        ExpressEntity expressEntity = expressDao.get(id);
        //发件人地址
        AddressEntity sendAddressEntity = addressDao.get(expressEntity.getSendAddressId());
        //收件人地址
        AddressEntity recvAddressEntity = addressDao.get(expressEntity.getAccAddressId());
        //收件人regin
        RegionEntity sendRegionEntity = regionDao.get(sendAddressEntity.getRegionId());
        CityEntity sendCityEntity = cityDao.get(sendRegionEntity.getCityid());
        ProvinceEntity sendProvinceEntity = provinceDao.get(sendCityEntity.getPid());
        //发件人regin
        RegionEntity recvRegionEntity = regionDao.get(sendAddressEntity.getRegionId());
        CityEntity recvCityEntity = cityDao.get(recvRegionEntity.getCityid());
        ProvinceEntity recvProvinceEntity = provinceDao.get(recvCityEntity.getPid());

        //塞数据。。。我日好长、、、
        expressInfo.setID(expressEntity.getId());
        expressInfo.setSname(sendAddressEntity.getName());
        expressInfo.setStel(sendAddressEntity.getTelephone());
        expressInfo.setSadd(sendProvinceEntity.getPname() + "-" + sendCityEntity.getCname() + "-" + sendRegionEntity.getArea());
        expressInfo.setSaddinfo(sendAddressEntity.getAddress());
        expressInfo.setRname(recvAddressEntity.getName());
        expressInfo.setRtel(recvAddressEntity.getTelephone());
        expressInfo.setRadd(recvProvinceEntity.getPname() + "-" + recvCityEntity.getCname() + "-" + recvRegionEntity.getArea());
        expressInfo.setRaddinfo(recvAddressEntity.getAddress());
        if (expressEntity.getGetTime() != null)
            expressInfo.setGetTime(expressEntity.getGetTime().toString());
        if (expressEntity.getOutTime() != null)
            expressInfo.setOutTime(expressEntity.getOutTime().toString());
        if (expressEntity.getWeight() != null)
            expressInfo.setWeight(expressEntity.getWeight());
        if (expressEntity.getTranFee() != null)
            expressInfo.setTranFee(expressEntity.getTranFee());
        if (expressEntity.getTranFee() != null)
            expressInfo.setInsuFee(expressEntity.getInsuFee());

        expressInfo.setAcc1(expressEntity.getAcc1());
        expressInfo.setAcc2(expressEntity.getAcc2());

        return expressInfo;
    }

    @Override
    public List<ExpressInfo> getExpressInfoByTel(String tel, String token) {
        if (!au.verify(token))
            return null;
        List<ExpressInfo> lists = new ArrayList<>();
        //用户信息
        List<CustomerEntity> customer = customerDao.findBy("telephone", true, Restrictions.eq("telephone", tel));
        //手机号相关的快递
        List<ExpressEntity> by = expressDao.findBy("customerId", true, Restrictions.eq("customerId", customer.get(0).getId()));

        for (int i = 0; i < by.size(); ++i) {
            ExpressInfo expressInfo = getExpressInfoById(by.get(i).getId(), token);
            lists.add(expressInfo);
        }
        return lists;
    }

    @Override
    public List<ExpressInfo> getSendExpressInfoByCustomerId(Integer CustomerId, String token) {
        if (!au.verify(token))
            return null;
        List<ExpressInfo> lists = new ArrayList<>();
        List<ExpressEntity> by = expressDao.findBy("customerId", true, Restrictions.eq("customerId", CustomerId));

        for (int i = 0; i < by.size(); ++i) {
            ExpressInfo expressInfo = getExpressInfoById(by.get(i).getId(), token);
            lists.add(expressInfo);
        }
        return lists;
    }

    @Override
    public List<ExpressInfo> getDncRercvExpressInfoByCustomerId(Integer CustomerId, String token) {
        if (!au.verify(token))
            return null;
        List<ExpressInfo> lists = new ArrayList<>();

        //相同的电话默认为同一个用户
        List<CustomerEntity> cusBy = customerDao.findBy("id", true, Restrictions.eq("id", CustomerId));
        List<AddressEntity> addrBy = addressDao.findBy("telephone", true, Restrictions.eq("telephone", cusBy.get(0).getTelephone()));
        //查询用户的收件
        for (int i = 0; i < addrBy.size(); ++i) {
            //获取同一个地点的用户的快递
            List<ExpressEntity> by = expressDao.findBy("accAddressId", true, Restrictions.eq("accAddressId", addrBy.get(i).getId()));
            for (int j = 0; j < by.size(); ++j) {
                ExpressInfo expressInfo = getExpressInfoById(by.get(i).getId(), token);
                if (expressInfo.getGetTime() == null)
                    lists.add(expressInfo);
            }
        }
        return lists;
    }

    @Override
    public List<ExpressInfo> getAccRercvExpressInfoByCustomerId(Integer CustomerId, String token) {
        if (!au.verify(token))
            return null;
        List<ExpressInfo> lists = new ArrayList<>();

        //相同的电话默认为同一个用户
        List<CustomerEntity> cusBy = customerDao.findBy("id", true, Restrictions.eq("id", CustomerId));
        List<AddressEntity> addrBy = addressDao.findBy("telephone", true, Restrictions.eq("telephone", cusBy.get(0).getTelephone()));
        //查询用户的收件
        for (int i = 0; i < addrBy.size(); ++i) {
            //获取同一个地点的用户的快递
            List<ExpressEntity> by = expressDao.findBy("accAddressId", true, Restrictions.eq("accAddressId", addrBy.get(i).getId()));
            for (int j = 0; j < by.size(); ++j) {
                ExpressInfo expressInfo = getExpressInfoById(by.get(i).getId(), token);
                if (expressInfo.getGetTime() != null)
                    lists.add(expressInfo);
            }
        }
        return lists;
    }

    @Override
    public PackageEntity findAPackageById(String PackageId, String token) {
        if (!au.verify(token))
            return null;
        //直接返回包裹对象实体
        return packageDao.get(PackageId);
    }

    @Override
    public List<PackageEntity> searchPackageInPackageById(String PackageId, String token) {
        if (!au.verify(token))
            return null;
        List<PackageEntity> lists = new ArrayList<>();
        //按照条件查找相应的包裹里所有包裹
        List<PackandpackEntity> by = packAndpackDao.findBy("parentId", true, Restrictions.eq("parentId", PackageId));
        if (by != null) {
            for (int i = 0; i < by.size(); ++i) {
                String expressId = by.get(i).getPackageId();
                //拿出来所有的快递列表
                if (by.get(i).getIsHistory() == 0)
                    lists.add(packageDao.get(expressId));
            }
        }
        return lists;
    }

    @Override
    public String saveExpress(ExpressEntity obj) {
        try {
            //保存快递并返回状态
            expressDao.save(obj);
            return "{\"state\":\"" + 1 + "\"}";
        } catch (Exception e) {
            return "{\"state\":\"" + 0 + "\"}";
        }
    }

    @Override
    public List<ExpressEntity> getWork(Integer employeeId, String starttime, Integer days, String token) {
        if (!au.verify(token))
            return null;
        //获取时间段
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = sdf.parse(starttime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endDate = (Date) startDate.clone();
        endDate.setTime(endDate.getTime() + days * 86400000);

        List<ExpressEntity> lists = new ArrayList<>();
        //查找符合条件的包裹
        List<PackageEntity> by = packageDao.findBy("id", true, Restrictions.eq("employeesId", employeeId), Restrictions.between("time", startDate, endDate));

        //递归查找包裹里的快递并存放到lists中
        for (int i = 0; i < by.size(); ++i) {
            findAllWork(lists, by.get(i).getId(), token);
        }
        return lists;
    }


    //递归方法

    public void findAllWork(List<ExpressEntity> lists, String PackageId, String token) {

        //获得包裹中的快递
        List<ExpressEntity> expressEntities = new ArrayList<>();
        //按照条件查找相应的包裹里所有快件
        List<ExpressandpackageEntity> all = expressAndPackageDao.findBy("packageId", true, Restrictions.eq("packageId", PackageId));
        for (int i = 0; i < all.size(); ++i) {
            String expressId = all.get(i).getExpressId();
            //保存快递
            lists.add(expressDao.get(expressId));
        }
        //包裹
        List<PackageEntity> packageEntities = searchPackageInPackageById(PackageId, token);
        if (packageEntities != null) {
            //如果存在包裹则遍历包裹再进行一遍查询包裹中包裹和快递的操作
            for (int i = 0; i < packageEntities.size(); ++i)
                findAllWork(lists, packageEntities.get(i).getId(), token);
        }
    }

    /////////////////////////////用户的接口////////////////////////////

    //通过用户id获得用户信息
    @Override
    public CustomerEntity getCustomerInfoById(int id, String token) {
        if (!au.verify(token))
            return null;
        return customerDao.get(id);
    }

    //通过用户手机号获得用户信息
    @Override
    public CustomerEntity getCustomerInfoByTel(String tel, String token) {
        if (!au.verify(token))
            return null;

        if (tel == null || tel.length() != 11)
            return null;
        List<CustomerEntity> list = customerDao.getByTel(tel);
        if (list.size() != 0) {
            return list.get(0);
        }
        return null;
    }

    //注册，并在注册过程中检查手机号是否注册过
    @Override
    public String registerByCus(CustomerEntity obj) {
        if (obj.getName() == null || obj.getTelephone() == null || obj.getPassword() == null)
            return "{\"registerstate\":\"null\"}";

        if (obj.getTelephone().length() != 11)
            return "{\"registerstate\":\"deny\"}";

        List<CustomerEntity> list = null;
        CustomerEntity customerEntity = new CustomerEntity();

        try {
            list = customerDao.getByTel(obj.getTelephone());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (list.size() == 0) {
            try {
                customerDao.save(obj);
                list = customerDao.getByTel(obj.getTelephone());
                customerEntity = list.get(0);
                String token = au.addToken(obj.getTelephone());
                return "{\"registerstate\":\"true\", \"id\":" + customerEntity.getId() + ", \"token\":\"" + token + "\"}";
            } catch (Exception e) {
                e.printStackTrace();
                return "{\"registerstate\":\"false\"}";
            }
        } else {
            return "{\"registerstate\":\"deny\"}";
        }
    }

    //更新用户信息
    @Override
    public String updateCustomerInfo(CustomerEntity obj) {
        if (obj.getName() == null || obj.getPassword() == null || obj.getTelephone() == null)
            return "{\"updateCustomerInfo\":\"null\"}";

        if (obj.getTelephone().length() != 11)
            return "{\"updateCustomerInfo\":\"deny\"}";

        try {
            customerDao.save(obj);
            return "{\"updateCustomerInfo\":\"true\"}";
        } catch (Exception e) {
            return "{\"updateCustomerInfo\":\"false\"}";
        }
    }

    //根据用户id删除用户信息
    @Override
    public String deleteCustomerInfo(int id, String token) {
        if (!au.verify(token))
            return null;

        try {
            customerDao.removeById(id);
            return "{\"deleteCustomerInfo\":\"true\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"deleteCustomerInfo\":\"false\"}";
        }
    }

    //用户登陆post方法
    @Override
    public String login(CustomerEntity obj) {
        CustomerEntity customerEntity = new CustomerEntity();
        if (obj.getTelephone() == null || obj.getPassword() == null)
            return "{\"loginstate\":\"null\"}";
        if (obj.getTelephone().length() != 11)
            return "{\"loginstate\":\"deny\"}";

        List<CustomerEntity> list = null;
        try {
            list = customerDao.getByTel(obj.getTelephone());
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"loginstate\":\"false\"}";
        }
        if (list.size() == 1) {
            customerEntity = list.get(0);
            if (customerEntity.getPassword().equals(obj.getPassword())) {
                Authentication au = Authentication.getInstance();
                String token = au.addToken(obj.getTelephone());
                return "{\"id\":" + customerEntity.getId() + ", \"name\":\"" + customerEntity.getName() + "\", \"loginstate\":\"true\", \"token\":\"" + token + "\"}";
            }
        }
        return "{\"loginstate\":\"false\"}";
    }

    //注销登陆
    @Override
    public void doLogOut(String token) {
        au.removeToken(token);
    }

    //修改手机号
    @Override
    public String changeTel(String telold, String telnew, String token) {
        if (!au.verify(token))
            return "{\"changetel\":\"authen_false\"}";

        if (telold == null || telnew == null)
            return "{\"changetel\":\"null\"}";

        if (telnew.length() != 11 || telold.length() != 11)
            return "{\"changetel\":\"deny\"}";

        List<CustomerEntity> listold = new ArrayList<>();
        List<CustomerEntity> listnew = new ArrayList<>();

        try {
            listold = customerDao.getByTel(telold);
            listnew = customerDao.getByTel(telnew);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"changetel\":\"false\"}";
        }

        if (listnew.size() != 0) {
            return "{\"changetel\":\"deny1\"}";   //修改的手机号已注册
        }
        if (listold.size() != 1) {
            return "{\"changetel\":\"deny2\"}";   //未找到该用户信息
        }

        CustomerEntity customerEntity = listold.get(0);
        customerEntity.setTelephone(telnew);

        try {
            customerDao.save(customerEntity);
            return "{\"changetel\":\"true\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"changetel\":\"false\"}";
        }
    }


    //修改密码
    @Override
    public String changePwd(String tel, String pwdold, String pwdnew, String token) {
        if (!au.verify(token))
            return "{\"changepwd\":\"authen_false\"}";     //返回认证失败的消息

        if (tel == null || pwdnew == null || pwdold == null)
            return "{\"changepwd\":\"null\"}";

        List<CustomerEntity> list = null;
        try {
            list = customerDao.getByTel(tel);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"changepwd\":\"false\"}";
        }

        if (list.size() != 1) {
            return "{\"changepwd\":\"deny1\"}";
        }
        CustomerEntity customerEntity = list.get(0);
        if (customerEntity.getPassword().equals(pwdold)) {
            customerEntity.setPassword(pwdnew);
            try {
                customerDao.save(customerEntity);
                return "{\"changepwd\":\"true\"}";
            } catch (Exception e) {
                e.printStackTrace();
                return "{\"changepwd\":\"deny2\"}";
            }
        }
        return "{\"changepwd\":\"false\"}";
    }

    @Override
    public Response createExpress(String id, int cid) {
        return null;
    }

    /////////////////////////////工作人员的公共接口////////////////////////////

    //通过工作人员id查找工作人员信息
    @Override
    public EmployeesEntity getEmployeeInfoById(int id, String token) {
        if (!au.verify(token))
            return null;
        return employeesDao.get(id);
    }

    //增加一个新的员工
    @Override
    public String newEmployee(EmployeesEntity obj) {
        try {
            employeesDao.save(obj);
            String token = au.addToken(obj.getTelephone());
            return "{\"newEmployee\":\"true\", " +
                    "\"id\":\"" + obj.getId() + "\", " +
                    "\"name\":\"" + obj.getName() + "\", " +
                    "\"job\":\"" + obj.getJob() + "\", " +
                    "\"jobText\":\"" + obj.getJobText() + "\", " +
                    "\"status\":\"" + obj.getStatus() + "\", " +
                    "\"outletsId\":\"" + obj.getOutletsId() + "\", " +
                    "\"token\":\"" + token + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"newEmployee\":\"false\"}";
        }
    }

    //修改员工信息
    @Override
    public String changeEmployeeInfo(EmployeesEntity obj) {
        try {
            employeesDao.update(obj);
            return "{\"changeEmployeeInfo\":\"true\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"changeEmployeeInfo\":\"false\"}";
        }
    }


    //删除员工信息
    @Override
    public String deleteEmployee(int id, String token) {
        if (!au.verify(token))
            return null;

        try {
            employeesDao.removeById(id);
            return "{\"deleteEmployee\":\"true\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"deleteEmployee\":\"false\"}";
        }
    }

    //员工通过手机号和密码登陆
    @Override
    public String doLoginByEmployee(EmployeesEntity obj) {
        if (obj.getTelephone() == null || obj.getPassword() == null) {
            return "{\"loginstate\":\"null\"}";
        }

        if (obj.getTelephone().length() != 11)
            return "{\"loginstate\":\"deny\"}";

        List<EmployeesEntity> list = null;
        try {
            list = employeesDao.getByTel(obj.getTelephone());
        } catch (Exception e) {
            e.printStackTrace();
        }

        EmployeesEntity ee = new EmployeesEntity();

        if (list.size() == 1) {
            ee = list.get(0);
            if (ee.getPassword().equals(obj.getPassword())) {
                String token = au.addToken(obj.getTelephone());
                return "{\"loginstate\":\"true\", " +
                        "\"id\":\"" + ee.getId() + "\", " +
                        "\"name\":\"" + ee.getName() + "\", " +
                        "\"job\":\"" + ee.getJob() + "\", " +
                        "\"jobText\":\"" + ee.getJobText() + "\", " +
                        "\"status\":\"" + ee.getStatus() + "\", " +
                        "\"outletsId\":\"" + ee.getOutletsId() + "\", " +
                        "\"token\":\"" + token + "\"}";
            }
        }
        return "{\"loginstate\":\"false\"}";
    }

    //员工注销登陆
    @Override
    public void doLogOutByEmployee(String token) {
        au.removeToken(token);
    }

    //员工修改手机号
    @Override
    public String changeTelByEmp(String telold, String telnew, String token) {
        if (!au.verify(token))
            return "{\"changetel\":\"authen_false\"}";

        if (telold == null || telnew == null)
            return "{\"changetel\":\"null\"}";


        if (telnew.length() != 11 || telold.length() != 11)
            return "{\"changetel\":\"deny\"}";

        List<EmployeesEntity> listold = new ArrayList<>();
        List<EmployeesEntity> listnew = new ArrayList<>();

        try {
            listold = employeesDao.getByTel(telold);
            listnew = employeesDao.getByTel(telnew);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"changetel\":\"false\"}";
        }

        if (listnew.size() != 0) {
            return "{\"changetel\":\"deny1\"}";   //修改的手机号已注册
        }
        if (listold.size() != 1) {
            return "{\"changetel\":\"deny2\"}";   //未找到该用户信息
        }

        EmployeesEntity employeesEntity = listold.get(0);
        employeesEntity.setTelephone(telnew);

        try {
            employeesDao.update(employeesEntity);
            return "{\"changetel\":\"true\"}";
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"changetel\":\"false\"}";
        }
    }

    //员工修改密码
    @Override
    public String changePwdByEmp(String tel, String pwdold, String pwdnew, String token) {
        if (!au.verify(token))
            return "{\"changetel\":\"authen_false\"}";     //返回认证失败的消息

        if (tel == null || pwdnew == null || pwdold == null)
            return "{\"changepwd\":\"null\"}";

        if (tel.length() != 11)
            return "{\"changepwd\":\"deny\"}";

        List<EmployeesEntity> list = null;
        try {
            list = employeesDao.getByTel(tel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list.size() != 1) {
            return "{\"changepwd\":\"deny1\"}";
        }
        EmployeesEntity employeesEntity = list.get(0);
        if (employeesEntity.getPassword().equals(pwdold)) {
            employeesEntity.setPassword(pwdnew);
            try {
                employeesDao.update(employeesEntity);
                return "{\"changepwd\":\"true\"}";
            } catch (Exception e) {
                e.printStackTrace();
                return "{\"changepwd\":\"deny2\"}";
            }
        }
        return "{\"changepwd\":\"false\"}";
    }

    @Override
    public String savePackage(PackageEntity obj) {
        try {
            packageDao.save(obj);
            return "{\"state\":\"" + 1 + "\"}";
        } catch (Exception e) {
            return "{\"state\":\"" + 0 + "\"}";
        }
    }

    @Override
    public ExpressEntity getPackageById(String pid, String token) {
        if (!au.verify(token))
            return null;
        return expressDao.get(pid);
    }

}
