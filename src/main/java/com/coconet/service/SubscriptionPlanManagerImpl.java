package com.coconet.service;

import com.coconet.dao.SubscriptionPlanDao;
import com.coconet.model.SubscriptionPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */
@Service
@Transactional
public class SubscriptionPlanManagerImpl implements SubscriptionPlanManager{
    @Autowired
    private SubscriptionPlanDao subscriptionPlanDao;

    @Override
    public List<SubscriptionPlan> subscriptionPlans() {
        return subscriptionPlanDao.subscriptionPlans();
    }

    @Override
    public SubscriptionPlan getSubscriptionPlan(int id) {
        return subscriptionPlanDao.getSubscriptionPlan(id);
    }
}
