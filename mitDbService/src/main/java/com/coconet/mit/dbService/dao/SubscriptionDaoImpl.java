package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.Subscription;
import com.coconet.mit.dbService.repository.SubscriptionRepository;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Prithu on 10-03-2017.
 */
@Repository
public class SubscriptionDaoImpl implements  SubscriptionDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Override
    public void saveOrUpdate(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription getSubscription(Subscription subscription) {
        return (Subscription)this.sessionFactory.getCurrentSession().createQuery("from Subscription where id=:id").setParameter("id",subscription.getId()
        ).uniqueResult();
    }

    @Override
    public Subscription getSubscriptionById(int id) {
        return subscriptionRepository.findOne(id);
    }

    @Override
    public Subscription getSubscriptionByIdEager(int id){
        Subscription subscription = subscriptionRepository.findOne(id);
//       Subscription subscription= (Subscription)this.sessionFactory.getCurrentSession().get(Subscription.class,id);
        Hibernate.initialize(subscription.getSubscriptionDeliveryRecords());
        return subscription;
    }

    @Override
    public List<Subscription> findBySubscriptionStatus(String subscriptionStatus) {
        return null;
    }

    @Override
    public List<Subscription> findBySubscriptionStatusAndPaymentType(String subscriptionStatus, String paymentType) {
        return null;
    }

    @Override
    public Subscription getSubscriptionByOrderId(String orderId) {
        return subscriptionRepository.findByOrderId(orderId);
    }
}
