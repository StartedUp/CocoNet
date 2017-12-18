package com.coconet.mit.commons.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Prithu on 18-03-2017.
 */
@Entity
@Table(name = "subscription_delivery_record")
public class SubscriptionDeliveryRecord {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @NotNull
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
    @NotNull
    @Column(name = "date")
    private Date date;
    @Column(name = "updated_at")
    private Date updatedAt;
    @NotNull
    @Column(name = "is_delivered")
    private boolean delivered;
    @NotNull
    @Column(name = "quantity_delivered")
    private BigDecimal quantityDelivered;
    @Column(name = "delivered_by")
    private String deliveredBy ="MadeInTreesTeam";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public BigDecimal getQuantityDelivered() {
        return quantityDelivered;
    }

    public void setQuantityDelivered(BigDecimal quantityDelivered) {
        this.quantityDelivered = quantityDelivered;
    }

    public String getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(String deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "SubscriptionDeliveryRecord{" +
                "id=" + id +
                ", subscription=" + subscription +
                ", date=" + date +
                ", updatedAt=" + updatedAt +
                ", delivered=" + delivered +
                ", quantityDelivered=" + quantityDelivered +
                ", deliveredBy='" + deliveredBy + '\'' +
                '}';
    }
}
