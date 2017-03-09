package com.coconet.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Prithu on 04-03-2017.
 */
@Entity
@Table(name = "subscription_plan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @NotEmpty
    @Column(name="plan_name", nullable=false)
    private String planName;
    @NotEmpty
    @Column(name = "subscription_duration_type")
    private String subscriptionDurationType;
    @NotEmpty
    @Column(name = "subscription_duration_number")
    private int subscriptionDurationNumber;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @NotEmpty
    @Column(name = "routine_pattern")
    private String routinePattern;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getSubscriptionDurationType() {
        return subscriptionDurationType;
    }

    public void setSubscriptionDurationType(String subscriptionDurationType) {
        this.subscriptionDurationType = subscriptionDurationType;
    }

    public int getSubscriptionDurationNumber() {
        return subscriptionDurationNumber;
    }

    public void setSubscriptionDurationNumber(int subscriptionDurationNumber) {
        this.subscriptionDurationNumber = subscriptionDurationNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getRoutinePattern() {
        return routinePattern;
    }

    public void setRoutinePattern(String routinePattern) {
        this.routinePattern = routinePattern;
    }

    @Override
    public String toString() {
        return "SubscriptionPlan{" +
                "id=" + id +
                ", planName='" + planName + '\'' +
                ", subscriptionDurationType='" + subscriptionDurationType + '\'' +
                ", subscriptionDurationNumber=" + subscriptionDurationNumber +
                ", product=" + product +
                ", routinePattern='" + routinePattern + '\'' +
                '}';
    }
}
