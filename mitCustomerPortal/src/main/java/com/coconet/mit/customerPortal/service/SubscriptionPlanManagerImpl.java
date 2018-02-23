package com.coconet.mit.customerPortal.service;

import com.coconet.mit.appService.service.SubscriptionPlanService;
import com.coconet.mit.commons.model.SubscriptionPlan;
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
    private SubscriptionPlanService subscriptionPlanService;

    @Override
    public List<SubscriptionPlan> subscriptionPlans() {
        return subscriptionPlanService.subscriptionPlans();
    }

    @Override
    public SubscriptionPlan getSubscriptionPlan(int id) {
        return subscriptionPlanService.getSubscriptionPlan(id);
    }
}
