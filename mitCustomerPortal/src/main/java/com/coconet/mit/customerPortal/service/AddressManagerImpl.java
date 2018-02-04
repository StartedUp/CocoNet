package com.coconet.mit.customerPortal.service;

import com.coconet.mit.customerPortal.dao.AddressDao;
import com.coconet.mit.commons.model.Address;
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
