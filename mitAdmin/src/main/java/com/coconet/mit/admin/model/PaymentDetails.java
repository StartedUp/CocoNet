package com.coconet.mit.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Prithu on 18-03-2017.
 */
@Entity
@Table(name = "payment_details")
public class PaymentDetails {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "payment_id")
    private String paymentId;
    @NotNull
    @Column(name = "payment_type")
    private String paymentType;
    @Column(name = "paid_date")
    private Date paidDate;
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "transaction_id")
    private String transactionId;
    @Column(name = "payment_request_id")
    private String paymentRequestId;
    @Column(name = "payment_request_status")
    private String paymentRequestStatus;
    @NotNull
    @Column(name = "payment_status")
    private String paymentStatus;
    @NotNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentRequestId() {
        return paymentRequestId;
    }

    public void setPaymentRequestId(String paymentRequestId) {
        this.paymentRequestId = paymentRequestId;
    }

    public String getPaymentRequestStatus() {
        return paymentRequestStatus;
    }

    public void setPaymentRequestStatus(String paymentRequestStatus) {
        this.paymentRequestStatus = paymentRequestStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
