package com.ffi.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ffi.model.annotation.IdentifiedBy;

@Entity
@Table(name="Customer")
@IdentifiedBy(domainName = "com.ffi.model.domain.Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@IdentifiedBy(property = "Id")
	public int id;

	@Column(name = "name")
	@IdentifiedBy(property = "Name")
	public String name;

	@Column(name = "email")
	@IdentifiedBy(property = "Email")
	public String email;

	@Column(name = "age")
	@IdentifiedBy(property = "Age")
	public int age;
	
	@Column(name = "mobile")
	@IdentifiedBy(property = "Mobile")
	@ElementCollection  
	public List<Integer> mobile=new ArrayList<Integer>();  

	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "address_id", nullable = false)
	@IdentifiedBy(property = "getAddress()")
	public Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Integer> getMobile() {
		return mobile;
	}

	public void setMobile(List<Integer> mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", mobile=" + mobile
				+ ", address=" + address + "]";
	}

}
