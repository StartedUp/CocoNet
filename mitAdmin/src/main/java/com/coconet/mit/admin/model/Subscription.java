package com.coconet.mit.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

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
    private BigDecimal quantityPerDay;
    @NotNull
    @Column(name = "total_quantity")
    private BigDecimal totalQuantity;
    @Column(name = "discount_percentage")
    private int discountPercentage;
    @Column(name = "discount")
    private BigDecimal discount;
    @NotNull
    @Column(name = "total_number_of_days")
    private int totalNumberOfDays;
    @NotNull
    @Column(name = "actual_price")
    private BigDecimal actualPrice;
    @NotNull
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    @NotNull
    @Column(name = "payment_status")
    private String paymentStatus;
    @NotEmpty
    @Column(name = "payment_type")
    private String paymentType;
    @NotNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private Subscriber subscriber;
    @NotNull
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "subscription_plan_id",nullable = false)
    private SubscriptionPlan subscriptionPlan;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_address")
    private Address deliveryAddress;
    @Column(name = "subscription_status")
    private String subscriptionStatus;
    @Column(name = "create_date")
    private Date createDate;
    @JsonIgnore
    @OneToMany(targetEntity =SubscriptionDeliveryRecord.class,  mappedBy = "subscription", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("date")
    private Set<SubscriptionDeliveryRecord> subscriptionDeliveryRecords;
    @JsonIgnore
    @OneToMany(targetEntity =PaymentDetails.class, mappedBy = "subscription", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PaymentDetails> paymentDetailsSet;

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

    public BigDecimal getQuantityPerDay() {
        return quantityPerDay;
    }

    public void setQuantityPerDay(BigDecimal quantityPerDay) {
        this.quantityPerDay = quantityPerDay;
    }

    public int getTotalNumberOfDays() {
        return totalNumberOfDays;
    }

    public void setTotalNumberOfDays(int totalNumberOfDays) {
        this.totalNumberOfDays = totalNumberOfDays;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
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

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
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

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<SubscriptionDeliveryRecord> getSubscriptionDeliveryRecords() {
        return subscriptionDeliveryRecords;
    }

    public void setSubscriptionDeliveryRecords(Set<SubscriptionDeliveryRecord> subscriptionDeliveryRecords) {
        this.subscriptionDeliveryRecords = subscriptionDeliveryRecords;
    }

    public Set<PaymentDetails> getPaymentDetailsSet() {
        return paymentDetailsSet;
    }

    public void setPaymentDetailsSet(Set<PaymentDetails> paymentDetailsSet) {
        this.paymentDetailsSet = paymentDetailsSet;
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
                ", discountPercentage=" + discountPercentage +
                ", discount=" + discount +
                ", totalNumberOfDays=" + totalNumberOfDays +
                ", actualPrice=" + actualPrice +
                ", totalPrice=" + totalPrice +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", subscriber=" + subscriber +
                ", subscriptionPlan=" + subscriptionPlan +
                ", deliveryAddress=" + deliveryAddress +
                ", subscriptionStatus='" + subscriptionStatus + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.id+"".hashCode();
    }
}
