package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.Product;
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

    @Override
    public List<Product> products() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public Product findById(int id) {
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }
}
