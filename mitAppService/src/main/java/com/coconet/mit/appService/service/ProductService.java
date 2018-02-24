package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.Product;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */
public interface ProductService {
    List<Product> products();

    Product findById(int id);

    //void delete(int id);

    //Product save(Product product);
}

