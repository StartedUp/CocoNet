package com.coconet.service;

import com.coconet.model.Subscriber;

import java.util.List;

/**
 * Created by Admin on 06-02-2017.
 */
public interface SubscriberManager {
    public List<Subscriber> list();

    public Subscriber get(int id);

    public void saveOrUpdate(Subscriber user);

    public void delete(int id);

    public Subscriber findByEmail(String email);
}
