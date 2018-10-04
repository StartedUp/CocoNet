package com.coconet.mit.customerPortal.service;

import com.coconet.mit.commons.model.Product;
import com.coconet.mit.commons.model.Subscriber;
import com.coconet.mit.commons.model.Subscription;
import com.coconet.mit.commons.model.SubscriptionPlan;
import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prithu on 17-03-2017.
 */
@Service
@Transactional
public class OnlinePaymentProcessor {
    @Value("${payment.online.instamojo.api.endpoint}")
    private String instamojoApiEndpoint;
    @Value("${payment.online.instamojo.auth.endpoint}")
    private String instamojoAuthEndpoint;
    @Value("${payment.online.instamojo.client.id}")
    private String instamojoClientId;
    @Value("${payment.online.instamojo.client.secret}")
    private String instamojoClientSecret;
    @Value("${domain.name}")
    private String domainName;
    public String placeOrder(Subscription subscription){
        System.err.println("Subscription "+subscription);
        PaymentOrder order = new PaymentOrder();
        Subscriber subscriber = subscription.getSubscriber();
        Product product=subscription.getProduct();
        SubscriptionPlan subscriptionPlan =subscription.getSubscriptionPlan();
        order.setName(subscriber.getFirstName()+" "+subscriber.getLastName());
        order.setEmail(subscriber.getEmail());
        order.setPhone(subscriber.getMobile());
        order.setCurrency("INR");
        order.setAmount(subscription.getTotalPrice().doubleValue());
        order.setDescription(product.getProductName());
        order.setRedirectUrl(domainName+"/subscriber/subscription/paymentStatus");
        //order.setWebhookUrl("http://www.google.com/");
        order.setTransactionId(subscription.getOrderId());

        Instamojo api = null;
        String longUrl = null;

        try {
            // gets the reference to the instamojo api
            api = InstamojoImpl.getApi(instamojoClientId, instamojoClientSecret, instamojoApiEndpoint, instamojoAuthEndpoint);
        } catch (ConnectionException e) {
            //LOGGER.log(Level.SEVERE, e.toString(), e);
            e.printStackTrace();
        }

        boolean isOrderValid = order.validate();

        if (isOrderValid) {
            try {
                System.out.println("Order details "+order);
                CreatePaymentOrderResponse createPaymentOrderResponse = api.createNewPaymentOrder(order);
                // print the status of the payment order.
                longUrl = createPaymentOrderResponse.getPaymentOptions().getPaymentUrl();
                System.out.println(" print the status of the payment order. "+createPaymentOrderResponse.getPaymentOptions().getPaymentUrl());
            } catch (InvalidPaymentOrderException e) {
                //LOGGER.log(Level.SEVERE, e.toString(), e);

                if (order.isTransactionIdInvalid()) {
                    System.out.println("Transaction id is invalid. This is mostly due to duplicate  transaction id.");
                }
                if (order.isCurrencyInvalid()) {
                    System.out.println("Currency is invalid.");
                }
            } catch (ConnectionException e) {
                //LOGGER.log(Level.SEVERE, e.toString(), e);
            }
            return longUrl!=null?longUrl.replace("?embed=form",""):null;
        } else {
            // inform validation errors to the user.
            if (order.isTransactionIdInvalid()) {
                System.out.println("Transaction id is invalid.");
            }
            if (order.isAmountInvalid()) {
                System.out.println("Amount cannot be less than 9.00.");
            }
            if (order.isCurrencyInvalid()) {
                System.out.println("Please provide the currency.");
            }
            if (order.isDescriptionInvalid()) {
                System.out.println("Description can not be greater than 255 characters.");
            }
            if (order.isEmailInvalid()) {
                System.out.println("Please provide valid Email Address.");
            }
            if (order.isNameInvalid()) {
                System.out.println("Name can not be greater than 100 characters.");
            }
            if (order.isPhoneInvalid()) {
                System.out.println("Phone is invalid.");
            }
            if (order.isRedirectUrlInvalid()) {
                System.out.println("Please provide valid Redirect url.");
            }

            if (order.isWebhookInvalid()) {
                System.out.println("Provide a valid webhook url");
            }
            return longUrl;
        }
    }
}
