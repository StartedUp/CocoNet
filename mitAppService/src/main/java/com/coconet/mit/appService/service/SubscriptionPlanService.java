package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.SubscriptionPlan;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */
public interface SubscriptionPlanService {
    public List<SubscriptionPlan> subscriptionPlans();
    public SubscriptionPlan getSubscriptionPlan(int id);
}
