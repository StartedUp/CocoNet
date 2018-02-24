package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.Product;
import com.coconet.mit.dbService.repository.ProductRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Prithu on 04-03-2017.
 */
@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> products() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findOne(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }


}
