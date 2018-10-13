package com.coconet.mit.customerPortal.service;

import com.coconet.mit.appService.service.ProductService;
import com.coconet.mit.commons.model.Product;
import com.coconet.mit.commons.model.Subscription;
import com.coconet.mit.customerPortal.util.SubscriptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */@Service
@Transactional
public class ProductManagerImpl implements ProductManager {
    @Autowired
    ProductService productService;

    @Override
    public List<Product> products() {
        return productService.products();
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }

    @Override
    public boolean validateSubscription(Subscription subscription) {
        Product product = productService.findById(subscription.getProduct().getId());
        BigDecimal quantity = subscription.getTotalQuantity();
        if((quantity.compareTo(product.getMinimumQuantity())==0 || quantity.compareTo(product.getMinimumQuantity())==1)  && quantity.remainder(product.getMinimumQuantity()).compareTo(BigDecimal.ZERO)==0){
            BigDecimal totalPrice = SubscriptionUtil.priceCalculator(quantity, product.getPricePerUnit());
            return (totalPrice.compareTo(subscription.getTotalPrice())==0);
        }
        return false;
    }
}
