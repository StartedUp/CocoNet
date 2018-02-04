package com.coconet.mit.customerPortal.service;

import com.coconet.mit.customerPortal.dao.ProductDao;
import com.coconet.mit.commons.model.Product;
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
