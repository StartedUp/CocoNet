package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.SubscriptionPlan;
import com.coconet.mit.dbService.repository.SubscriptionPlanRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */
@Repository
public class SubscriptionPlanDaoImpl implements SubscriptionPlanDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    @Override
    public List<SubscriptionPlan> subscriptionPlans() {
        return sessionFactory.getCurrentSession().createQuery("from SubscriptionPlan").list();
    }

    @Override
    public SubscriptionPlan getSubscriptionPlan(int id) {
        return subscriptionPlanRepository.findOne(id);
    }
}
