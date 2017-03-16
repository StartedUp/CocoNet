package com.coconet.dao;

import com.coconet.model.SubscriptionPlan;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */
public interface SubscriptionPlanDao {
    public List<SubscriptionPlan> subscriptionPlans();
    public SubscriptionPlan getSubscriptionPlan(int id);
}
