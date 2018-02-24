package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.Product;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */
public interface ProductDao {
    List<Product> products();

    Product findById(int id);

    void save(Product product);
}
