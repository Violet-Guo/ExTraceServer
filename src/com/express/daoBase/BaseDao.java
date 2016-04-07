package com.express.daoBase;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

/**
 * Created by violet on 2016/3/28.
 */
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
public class BaseDao<T, PK extends Serializable> extends HibernateDaoSupport implements com.express.daoBase.IBaseDao<T, PK> {
    protected Class<T> entityClass;			// DAO所管理的Entity类型.

    /**
     *让spring提供构造函数注入
     */
    public BaseDao(Class<T> type) {
        this.entityClass = type;
    }

    public BaseDao(){
    }

    protected Class<T> getEntityClass() {
        return entityClass;
    }

    @Override
    public T get(PK id) {
        return getHibernateTemplate().load(getEntityClass(), id);
    }

    @Override
    public List<T> getAll() {
        return (List<T>)(getHibernateTemplate().loadAll(getEntityClass()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll(String orderBy, boolean isAsc) {
        Assert.hasText(orderBy);
        if (isAsc)
            return (List<T>) getHibernateTemplate().findByCriteria(
                    DetachedCriteria.forClass(getEntityClass()).addOrder(Order.asc(orderBy)));
        else
            return (List<T>) getHibernateTemplate().findByCriteria(
                    DetachedCriteria.forClass(getEntityClass()).addOrder(Order.desc(orderBy)));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> findBy(String orderBy, boolean isAsc, Criterion... criterions) {
        DetachedCriteria criteria = DetachedCriteria.forClass(getEntityClass());
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        if (isAsc)
            criteria.addOrder(Order.asc(orderBy));
        else
            criteria.addOrder(Order.desc(orderBy));

        return (List<T>) getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public List<T> findBy(String propertyName, Object value, String orderBy, boolean isAsc) {
        Assert.hasText(propertyName);
        Assert.hasText(orderBy);
        return findBy(orderBy, isAsc, Restrictions.eq(propertyName, value));
        //return createCriteria(orderBy, isAsc, Restrictions.eq(propertyName, value)).list();
    }

    @Override
    public List<T> findLike(String propertyName, Object value, String orderBy, boolean isAsc) {
        Assert.hasText(propertyName);
        Assert.hasText(orderBy);
        return findBy(orderBy, isAsc, Restrictions.like(propertyName, value));
        //return createCriteria(orderBy, isAsc, Restrictions.eq(propertyName, value)).list();
    }

    @Override
    public void save(T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void remove(T entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void removeById(PK id) {
        remove(get(id));
    }

    @Override
    public void evit(T entity) {
        getHibernateTemplate().evict(entity);
    }

    @Override
    public void flush() {
        getHibernateTemplate().flush();
    }

    @Override
    public void clear() {
        getHibernateTemplate().clear();
    }
}
