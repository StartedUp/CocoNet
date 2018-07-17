package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.Address;
import com.coconet.mit.dbService.dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prithu on 10-03-2017.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public Address getAddress(int addressId) {
        return addressDao.getAddress(addressId);
    }
}
