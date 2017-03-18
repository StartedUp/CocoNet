package com.coconet.util;

import com.coconet.model.Subscription;
import com.coconet.model.SubscriptionPlan;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Prithu on 05-03-2017.
 */
public class SubscriptionUtil {
    private static BigDecimal instamojoCommissionPercentage=new BigDecimal(0.02);
    private static BigDecimal instamojoCommissionValue=new BigDecimal(3);
    private static BigDecimal taxPercentage=new BigDecimal(0.15);
    public static Subscription startAndEndDateSetter(Subscription subscription, SubscriptionPlan subscriptionPlan) {
        /*Required Date variable declaration*/
        Calendar startDateCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();

        /*StartDate Calculation*/
        startDateCal.set(2017,2,26);
        startDateCal.add(Calendar.DATE,1);
        if (subscriptionPlan.getRoutinePattern().equals("weekdays"))
            startDateCal = getNextWeekdayIfWeekend(startDateCal);
        subscription.setStartDate(startDateCal.getTime());

        /*EndDate Calculation*/
        endDateCal.setTime(startDateCal.getTime());
        endDateCal.add(Calendar.MONTH,1);
        if (subscriptionPlan.getRoutinePattern().equals("weekdays"))
            endDateCal = getNextWeekdayIfWeekend(endDateCal);
        subscription.setEndDate(endDateCal.getTime());
        int numberOfDays = 0;
        while (startDateCal.before(endDateCal)) {
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
}
