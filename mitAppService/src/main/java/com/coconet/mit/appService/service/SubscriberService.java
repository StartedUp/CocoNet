package com.coconet.mit.appService.service;

import com.coconet.mit.commons.model.Subscriber;

import java.util.List;

/**
 * Created by Admin on 06-02-2017.
 */
public interface SubscriberService {
    public List<Subscriber> list();

    public Subscriber get(int id);

    public void saveOrUpdate(Subscriber subscriber);

    public void update(Subscriber subscriber);

    public Subscriber findByEmail(String email);

    public Subscriber findByEmailAndToken(String email, String token);

    public Subscriber findByToken(String token);
}
