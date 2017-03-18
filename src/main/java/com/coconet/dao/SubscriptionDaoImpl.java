package com.coconet.dao;

import com.coconet.model.Subscription;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Prithu on 10-03-2017.
 */
@Repository
public class SubscriptionDaoImpl implements  SubscriptionDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void saveOrUpdate(Subscription subscription) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(subscription);
    }

    @Override
    public Subscription getSubscription(Subscription subscription) {
        return (Subscription)this.sessionFactory.getCurrentSession().createQuery("from Subscription where id=:id").setParameter("id",subscription.getId()
        ).uniqueResult();
    }

    @Override
    public Subscription getSubscriptionById(int id) {
        return (Subscription)this.sessionFactory.getCurrentSession().createQuery("from Subscription where id=:id").setParameter("id",id
        ).uniqueResult();
    }
}
