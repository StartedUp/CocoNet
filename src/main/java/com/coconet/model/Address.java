package com.coconet.model;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="address")
public class Address {
	@Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
	@NotEmpty
	@Column(name = "address_line1", nullable=false)
	private String addressLine1;
	@NotEmpty
	@Column(name = "address_line2", nullable=false)
	private String addressLine2;
	@NotEmpty
	@Column(name = "city", nullable=false)
	private String city="Chennai";
	@NotEmpty
	@Column(name = "state", nullable=false)
	private String state="TamilNadu";
	@NotEmpty
	@Column(name = "country", nullable=false)
	private String country="India";
	@NotEmpty
	@Column(name = "pincode", nullable=false)
	private String pincode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	}
