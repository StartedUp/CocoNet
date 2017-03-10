package com.coconet.dao;

import com.coconet.model.Subscriber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 04-02-2017.
 */
@Repository
public class SubscriberDaoImpl implements SubscriberDao {
    @Autowired
    private SessionFactory sessionFactory;

    private static final Log _log = LogFactory.getLog(SubscriberDaoImpl.class);

    @Override
    public List<Subscriber> list() {
        return null;
    }

    @Override
    public Subscriber get(int id) {
        return null;
    }

    @Override
    public void saveOrUpdate(Subscriber subscriber) {
        _log.info("subscriber in daoImpl = " + subscriber);
        this.sessionFactory.getCurrentSession().saveOrUpdate(subscriber);
    }

    @Override
    public void update(Subscriber subscriber) {
        this.sessionFactory.getCurrentSession().update(subscriber);
    }

    @Override
    public Subscriber findByEmail(String email) {
        String queryByEmail = "from Subscriber where email=:email";
        Session session= sessionFactory.openSession();
        Subscriber subscriber= (Subscriber) session.createQuery(queryByEmail)
                .setParameter("email", email).uniqueResult();
        subscriber.getAddresses();
        session.close();
        return subscriber;
    }

    @Override
    public Subscriber findByEmailAndToken(String email, String token) {
        String queryByEmailAndToken = "from Subscriber where email=:email and registration_token=:token";
        return (Subscriber) this.sessionFactory.getCurrentSession().createQuery(queryByEmailAndToken)
                .setParameter("email",email).setParameter("token",token).uniqueResult();
    }
}
