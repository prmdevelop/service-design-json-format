package com.ffi.model.service;

import com.ffi.model.domain.Address;
import com.ffi.model.dto.AddressDto;

public interface AddressService {

	public AddressDto getAddress(int id);

	public void modifyAddress(Address address);

}
