package com.coconet.dao;

import com.coconet.model.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Prithu on 10-03-2017.
 */
@Repository
public class AddressDaoImpl implements AddressDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Address getAddress(int addressId) {
        return (Address)this.sessionFactory.getCurrentSession().createQuery("from Address where id =:id").setParameter("id",addressId).uniqueResult();
    }
}
