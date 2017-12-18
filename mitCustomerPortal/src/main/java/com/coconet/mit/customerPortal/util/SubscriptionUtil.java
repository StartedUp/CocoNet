package com.coconet.mit.customerPortal.util;

import com.coconet.mit.customerPortal.model.PaymentDetails;
import com.coconet.mit.customerPortal.model.Subscription;
import com.coconet.mit.customerPortal.model.SubscriptionDeliveryRecord;
import com.coconet.mit.customerPortal.model.SubscriptionPlan;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by Prithu on 05-03-2017.
 */
public class SubscriptionUtil {
    private static BigDecimal instamojoCommissionPercentage=new BigDecimal(0.02);
    private static BigDecimal instamojoCommissionValue=new BigDecimal(3);
    private static BigDecimal taxPercentage=new BigDecimal(0.15);
    public static Subscription startAndEndDateSetter(Subscription subscription, SubscriptionPlan subscriptionPlan, Date customStartDate) {
        /*Required Date variable declaration*/
        Calendar startDateCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();

        /*StartDate Calculation*/
        startDateCal.setTime(customStartDate);
        startDateCal.set(Calendar.HOUR, 0);
        startDateCal.set(Calendar.MINUTE, 0);
        startDateCal.set(Calendar.SECOND, 0);
        if (subscriptionPlan.getRoutinePattern().equals("weekdays"))
            startDateCal = getNextWeekdayIfWeekend(startDateCal);
        subscription.setStartDate(startDateCal.getTime());

        /*EndDate Calculation*/
        endDateCal.setTime(startDateCal.getTime());
        if (subscriptionPlan.getSubscriptionDurationType().equals("month"))
            endDateCal.add(Calendar.MONTH,1);
        if (subscriptionPlan.getSubscriptionDurationType().equals("week"))
            endDateCal.add(Calendar.DATE,7);;
        if (subscriptionPlan.getRoutinePattern().equals("weekdays"))
            endDateCal = getNextWeekdayIfWeekend(endDateCal);
        subscription.setEndDate(endDateCal.getTime());
        int numberOfDays = 0;
        while (startDateCal.before(endDateCal)||startDateCal.equals(endDateCal)) {
            if (subscriptionPlan.getRoutinePattern().equals("weekdays")) {
                if ((Calendar.SATURDAY != startDateCal.get(Calendar.DAY_OF_WEEK))
                        && (Calendar.SUNDAY != startDateCal.get(Calendar.DAY_OF_WEEK))) {
                    numberOfDays++;
                }
            }else
                numberOfDays++;
            startDateCal.add(Calendar.DATE,1);
        }
        subscription.setTotalNumberOfDays(numberOfDays);
        return subscription;
    }
    public static Calendar getNextWeekdayIfWeekend(Calendar calendar){
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            calendar.add(Calendar.DATE, 2);
            return calendar;
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DATE, 1);
            return calendar;
        }
        return calendar;
    }

    public static BigDecimal priceCalculator(BigDecimal totalQuantity, BigDecimal pricePerUnit){
        BigDecimal price=pricePerUnit.multiply(totalQuantity).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        BigDecimal instamojoCommission = price.multiply(instamojoCommissionPercentage).add(instamojoCommissionValue).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        BigDecimal VAT=instamojoCommission.multiply(taxPercentage).setScale(2,BigDecimal.ROUND_HALF_EVEN);
        BigDecimal totalPrice=price.add(instamojoCommission).add(VAT);
        return totalPrice;
    }

    public static Subscription setPaymentDetails(Subscription subscription, PaymentOrderDetailsResponse paymentOrderDetailsResponse, String paymentId){
        String paymentType = subscription.getPaymentType();
        Set<PaymentDetails> paymentDetailsSet=new HashSet<PaymentDetails>();
        subscription.setPaymentDetailsSet(paymentDetailsSet);
        PaymentDetails paymentDetails = new PaymentDetails();
        if (paymentType.equals("cod")){
            paymentDetails.setPaymentStatus("pending");
            paymentDetails.setAmount(subscription.getTotalPrice());
            paymentDetails.setPaymentType(paymentType);
            paymentDetails.setSubscription(subscription);
            subscription.getPaymentDetailsSet().add(paymentDetails);
            return subscription;
        }else {
            paymentDetails.setSubscription(subscription);
            paymentDetails.setPaymentType(subscription.getPaymentType());
            paymentDetails.setPaymentStatus(paymentOrderDetailsResponse.getStatus());
            paymentDetails.setAmount(new BigDecimal(paymentOrderDetailsResponse.getAmount()));
            paymentDetails.setPaidDate(new Date());
            paymentDetails.setPaymentRequestId(paymentOrderDetailsResponse.getId());
            paymentDetails.setPaymentId(paymentId);
            paymentDetails.setPaymentStatus(paymentOrderDetailsResponse.getStatus());
            paymentDetails.setTransactionId(paymentOrderDetailsResponse.getTransactionId());
            subscription.getPaymentDetailsSet().add(paymentDetails);
            return subscription;
        }
    }

    public static Subscription setSubscriptionDeliveryRecords(Subscription subscription){
        Calendar startDateCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();
        Set<SubscriptionDeliveryRecord> subscriptionDeliveryRecords = new LinkedHashSet<SubscriptionDeliveryRecord>();
        startDateCal.setTime(subscription.getStartDate());
        endDateCal.setTime(subscription.getEndDate());
        SubscriptionPlan subscriptionPlan =subscription.getSubscriptionPlan();
        while (startDateCal.before(endDateCal)||startDateCal.equals(endDateCal)) {
            SubscriptionDeliveryRecord subscriptionDeliveryRecord =new SubscriptionDeliveryRecord();
            if (subscriptionPlan.getRoutinePattern().equals("weekdays")) {
                if ((Calendar.SATURDAY != startDateCal.get(Calendar.DAY_OF_WEEK))
                        && (Calendar.SUNDAY != startDateCal.get(Calendar.DAY_OF_WEEK))) {
                    subscriptionDeliveryRecord.setSubscription(subscription);
                    subscriptionDeliveryRecord.setDate(startDateCal.getTime());
                    subscriptionDeliveryRecord.setQuantityDelivered(new BigDecimal(0));
                    subscriptionDeliveryRecords.add(subscriptionDeliveryRecord);
                }
            }else {
                subscriptionDeliveryRecord.setSubscription(subscription);
                subscriptionDeliveryRecord.setDate(startDateCal.getTime());
                subscriptionDeliveryRecord.setQuantityDelivered(new BigDecimal(0));
                subscriptionDeliveryRecords.add(subscriptionDeliveryRecord);
            }
            startDateCal.add(Calendar.DATE,1);
        }
        subscription.setSubscriptionDeliveryRecords(subscriptionDeliveryRecords);
        return subscription;
    }

}
