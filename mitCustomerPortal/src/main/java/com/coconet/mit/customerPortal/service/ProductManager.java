package com.coconet.mit.customerPortal.service;

import com.coconet.mit.commons.model.Product;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */
public interface ProductManager {
    public List<Product> products();
    Product findById(int id);
}
