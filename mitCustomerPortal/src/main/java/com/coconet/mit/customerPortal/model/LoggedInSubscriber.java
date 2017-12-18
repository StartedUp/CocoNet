package com.coconet.mit.customerPortal.model;

import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Prithu on 07-03-2017.
 */
public class LoggedInSubscriber extends User{
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public LoggedInSubscriber(String username, String password, boolean enabled,
                              boolean accountNonExpired, boolean credentialsNonExpired,
                              boolean accountNonLocked,
                              Collection authorities){
        super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
