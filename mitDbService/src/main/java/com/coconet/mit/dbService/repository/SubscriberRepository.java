package com.coconet.mit.dbService.repository;

import com.coconet.mit.commons.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Prithu on 9/2/18.
 */
@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
    Subscriber findByEmail(String email);
}
