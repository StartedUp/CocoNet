package com.coconet.service;

import com.coconet.dao.ProductDao;
import com.coconet.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */@Service
@Transactional
public class ProductManagerImpl implements ProductManager {
    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> products() {
        return productDao.products();
    }
}
