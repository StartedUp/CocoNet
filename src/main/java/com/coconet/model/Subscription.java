package com.coconet.model;

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
    @Column(name = "quantity_per_day")
    private double quantityPerDay;
    @Column(name = "total_number_of_days")
    private int totalNumberOfDays;
    @Column(name = "actual_price")
    private double actualPrice;
    @Column(name = "total_price")
    private double totalPrice;

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
}
