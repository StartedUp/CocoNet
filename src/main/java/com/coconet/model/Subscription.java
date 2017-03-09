package com.coconet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

/**
 * Created by Prithu on 04-03-2017.
 */
@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "start_date")
    private Date startDate;
    @NotNull
    @Column(name = "end_date")
    private Date endDate;
    @NotNull
    @Column(name = "preferred_delivery_time")
    private Time preferredDeliveryTime;
    @NotNull
    @Column(name = "quantity_per_day")
    private double quantityPerDay;
    @NotNull
    @Column(name = "total_quantity")
    private double totalQuantity;
    @Column(name = "discount_percentage")
    private int discountPercentage;
    @Column(name = "discount")
    private double discount;
    @NotNull
    @Column(name = "total_number_of_days")
    private int totalNumberOfDays;
    @NotNull
    @Column(name = "actual_price")
    private double actualPrice;
    @NotNull
    @Column(name = "total_price")
    private double totalPrice;
    @NotNull
    @Column(name = "payment_status")
    private String paymentStatus;
    @NotEmpty
    @Column(name = "payment_type")
    private String paymentType;
    @NotEmpty
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;
    @NotEmpty
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "subscription_plan_id")
    private SubscriptionPlan subscriptionPlan;
    @NotEmpty
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_address")
    private Address deliveryAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getPreferredDeliveryTime() {
        return preferredDeliveryTime;
    }

    public void setPreferredDeliveryTime(Time preferredDeliveryTime) {
        this.preferredDeliveryTime = preferredDeliveryTime;
    }

    public double getQuantityPerDay() {
        return quantityPerDay;
    }

    public void setQuantityPerDay(double quantityPerDay) {
        this.quantityPerDay = quantityPerDay;
    }

    public int getTotalNumberOfDays() {
        return totalNumberOfDays;
    }

    public void setTotalNumberOfDays(int totalNumberOfDays) {
        this.totalNumberOfDays = totalNumberOfDays;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Subscriber getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", preferredDeliveryTime=" + preferredDeliveryTime +
                ", quantityPerDay=" + quantityPerDay +
                ", totalQuantity=" + totalQuantity +
                ", totalNumberOfDays=" + totalNumberOfDays +
                ", actualPrice=" + actualPrice +
                ", totalPrice=" + totalPrice +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", subscriber=" + subscriber +
                ", subscriptionPlan=" + subscriptionPlan +
                '}';
    }
    @Override
    public int hashCode() {
        return this.id+"".hashCode();
    }
}
