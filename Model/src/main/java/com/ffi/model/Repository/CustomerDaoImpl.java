package com.ffi.model.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ffi.model.domain.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllLead() {
		return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		customer = customerRepository.save(customer);
		return customer;
	}
	
	@Override
	public Customer getCustomer(int customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		return customer;
	}

}
