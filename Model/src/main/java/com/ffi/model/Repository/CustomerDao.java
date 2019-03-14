package com.ffi.model.Repository;

import java.util.List;

import com.ffi.model.domain.Customer;

public interface CustomerDao {
	
	public List<Customer> getAllLead();
	public Customer save(Customer Customer);
	public Customer getCustomer(int customerId);
}
