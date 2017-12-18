package com.coconet.mit.customerPortal.dao;

import com.coconet.mit.customerPortal.model.Product;
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
        return sessionFactory.getCurrentSession().createQuery("from product").list();
    }
}
