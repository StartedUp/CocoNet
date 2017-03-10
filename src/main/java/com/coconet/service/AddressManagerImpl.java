package com.coconet.service;

import com.coconet.dao.AddressDao;
import com.coconet.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prithu on 10-03-2017.
 */
@Service
@Transactional
public class AddressManagerImpl implements AddressManager{
    @Autowired
    private AddressDao addressDao;

    @Override
    public Address getAddress(int addressId) {
        return addressDao.getAddress(addressId);
    }
}
