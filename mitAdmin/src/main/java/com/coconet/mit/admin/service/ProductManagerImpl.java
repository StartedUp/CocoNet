package com.coconet.mit.admin.service;

import com.coconet.mit.appService.service.ProductService;
import com.coconet.mit.commons.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by root on 16/10/17.
 */
@Service
@Transactional
public class ProductManagerImpl implements ProductManager {
    @Autowired
    ProductService productService;

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<Product> findAll() {
        return productService.products();
    }
    @Override
    public Product save(Product product){
        return product;

    }

}
