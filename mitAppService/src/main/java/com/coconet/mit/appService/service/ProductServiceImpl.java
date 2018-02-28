package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.Product;
import com.coconet.mit.dbService.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> products() {
        return productDao.products();
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public Product save(Product product) {
        productDao.save(product);
        return product;
    }
}

