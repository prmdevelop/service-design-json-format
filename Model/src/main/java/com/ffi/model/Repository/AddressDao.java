package com.ffi.model.Repository;

import java.util.List;

import com.ffi.model.domain.Address;

public interface AddressDao {
	
	public List<Address> getAllAddress();
	public Address save(Address address);
	public Address getAddress(int addressId);

}
