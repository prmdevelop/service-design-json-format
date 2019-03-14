package com.ffi.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ffi.model.annotation.IdentifiedBy;

@Entity
@Table(name = "Address")
@IdentifiedBy(domainName = "com.ffi.model.domain.Address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@IdentifiedBy(property = "Id")
	public int id;

	@Column(name = "addressLine")
	@IdentifiedBy(property = "Addressline")
	public String addressline;

	@Column(name = "city")
	@IdentifiedBy(property = "City")
	public String city;

	@Column(name = "state")
	@IdentifiedBy(property = "State")
	public String state;
	
	@OneToOne(mappedBy = "address",fetch = FetchType.EAGER,optional = false)
	public Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressline() {
		return addressline;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
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
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressline=" + addressline + ", city=" + city + ", state=" + state + "]";
	}
}
