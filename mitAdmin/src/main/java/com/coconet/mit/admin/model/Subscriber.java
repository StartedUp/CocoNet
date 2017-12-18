package com.coconet.mit.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by ${Prithu} on 04-02-2017.
 */
@Entity
@Table(name = "subscriber")
public class Subscriber {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @NotEmpty
    @Column(name="firstname", nullable=false)
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @NotEmpty
    @Column(name="password", nullable=false)
    private String password;
    @Column(name="email", nullable=false)
    private String email;
    @NotEmpty
    @Column(name = "mobile", nullable=false)
    private String mobile;
    @JsonIgnore
    @OneToMany(targetEntity = Address.class,mappedBy = "subscriber",cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> addresses;
    @NotEmpty
    @Column(name = "registration_token", nullable = false)
    private String registrationToken;
    @Column(name = "is_active", nullable = false)
    private boolean active;
    @JsonIgnore
    @OneToMany(targetEntity = Subscription.class, mappedBy = "subscriber", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Subscription> subscriptions;
    @Column(name = "create_date")
    private Date createDate;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

    public String getRegistrationToken() {
        return registrationToken;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRegistrationToken(String registrationToken) {
        this.registrationToken = registrationToken;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    public int hashCode() {
        return this.id+"".hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (obj!=null && obj instanceof Subscriber){
           Subscriber subscriber = (Subscriber)obj;
           return (this.email).equals(subscriber.getEmail());
       }
       else
           return false;
    }
}
