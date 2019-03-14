package com.ffi.model.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ffi.model.domain.Address;

@Component
public class AddressDaoImpl implements AddressDao{
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<Address> getAllAddress() {
		return addressRepository.findAll();
	}

	@Override
	public Address save(Address address) {
		address = addressRepository.save(address);
		return address;
	}

	@Override
	public Address getAddress(int addressId) {
		Address address = addressRepository.findById(addressId).get();
		return address;
	}

}
