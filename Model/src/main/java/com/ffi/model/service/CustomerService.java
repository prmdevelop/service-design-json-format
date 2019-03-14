package com.ffi.model.service;

import com.ffi.model.dto.CustomerDto;

public interface CustomerService {

	public CustomerDto getCustomer(int id);
	
	public void modifyCustomer(CustomerDto customerDto);

}
