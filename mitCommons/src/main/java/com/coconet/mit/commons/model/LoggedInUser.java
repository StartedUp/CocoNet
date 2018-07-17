package com.coconet.mit.commons.model;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Prithu on 22-03-2017.
 */
public class LoggedInUser extends org.springframework.security.core.userdetails.User{
    private int id;
    private String username;
    private String email;
    private Set<Role> roles;

    public LoggedInUser(String username, String password, boolean enabled,
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

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
