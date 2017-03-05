package com.coconet.util;

import com.coconet.model.Subscription;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Prithu on 05-03-2017.
 */
public class SubscriptionUtil {
    public static Subscription startAndEndDateSetter(Subscription subscription) {
        /*Required Date variable declaration*/
        Calendar startDateCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();

        /*StartDate Calculation*/
        startDateCal.setTime(new Date());
        startDateCal = getNextWeekdayIfWeekend(startDateCal);
        subscription.setStartDate(startDateCal.getTime());

        /*EndDate Calculation*/
        endDateCal.setTime(startDateCal.getTime());
        endDateCal.add(Calendar.MONTH,1);
        endDateCal = getNextWeekdayIfWeekend(endDateCal);
        subscription.setEndDate(endDateCal.getTime());
        int numberOfDays = 0;
        while (startDateCal.before(endDateCal)) {
            if ((Calendar.SATURDAY != startDateCal.get(Calendar.DAY_OF_WEEK))
                    &&(Calendar.SUNDAY != startDateCal.get(Calendar.DAY_OF_WEEK))) {
                numberOfDays++;
            }
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
}
