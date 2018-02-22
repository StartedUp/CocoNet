package com.coconet.mit.dbService.dao;

import com.coconet.mit.commons.model.Subscriber;
import com.coconet.mit.dbService.repository.SubscriberRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Admin on 04-02-2017.
 */
@Repository
public class SubscriberDaoImpl implements SubscriberDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String FETCH_SUBSCRIBER_BY_EMAIL = "select * from subscriber where email = ?";

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
        subscriberRepository.save(subscriber);
    }

    @Override
    public void update(Subscriber subscriber) {
        this.sessionFactory.getCurrentSession().update(subscriber);
    }

    @Override
    public Subscriber findByEmail(String email) {
        String queryByEmail = "from Subscriber where email=:email";
        Session session= sessionFactory.openSession();
        /*Subscriber subscriber= (Subscriber) session.createQuery(queryByEmail)
                .setParameter("email", email).uniqueResult();*/
        session.close();
        Subscriber subscriber = null;
        try {
            subscriber = jdbcTemplate.queryForObject(FETCH_SUBSCRIBER_BY_EMAIL, new SubscriberMapper(), email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return subscriber;
    }

    @Override
    public Subscriber findByEmailAndToken(String email, String token) {
        String queryByEmailAndToken = "from Subscriber where email=:email and registration_token=:token";
        return (Subscriber) this.sessionFactory.getCurrentSession().createQuery(queryByEmailAndToken)
                .setParameter("email",email).setParameter("token",token).uniqueResult();
    }

    @Override
    public Subscriber findByToken(String token) {
        String queryByToken = "from Subscriber where registration_token=:token";
        return (Subscriber) this.sessionFactory.getCurrentSession().createQuery(queryByToken).setParameter("token",token).uniqueResult();
    }

    class SubscriberMapper implements RowMapper<Subscriber> {
        @Override
        public Subscriber mapRow(ResultSet rs, int i) throws SQLException {
            Subscriber subscriber = new Subscriber();
            subscriber.setId(rs.getInt("id"));
            subscriber.setFirstName(rs.getString("firstname"));
            subscriber.setLastName(rs.getString("lastname"));
            subscriber.setPassword(rs.getString("password"));
            subscriber.setEmail(rs.getString("email"));
            subscriber.setMobile(rs.getString("mobile"));
            subscriber.setActive(rs.getBoolean("is_active"));
            subscriber.setRegistrationToken(rs.getString("registration_token"));
            return subscriber;
        }
    }


}
