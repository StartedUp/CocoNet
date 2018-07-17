package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.Address;
import com.coconet.mit.dbService.repository.AddressRepository;
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

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address getAddress(int addressId) {
        return addressRepository.findOne(addressId);
    }
}
