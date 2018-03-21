package com.coconet.mit.dbService.repository;

import com.coconet.mit.commons.model.Address;
import com.coconet.mit.commons.model.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Balaji on 18/3/18.
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
