package com.ffi.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ffi.model.Repository.AddressDao;
import com.ffi.model.annotation.IdentifiedBy;
import com.ffi.model.domain.Address;
import com.ffi.model.dto.AddressDto;
import com.ffi.model.mapper.AddressMapper;
import com.ffi.model.utility.Identifer;
import com.ffi.model.utility.ValueType;

public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressDao addressDao;

	public static Identifer[] getAddressPath(Address address) {
		List<Identifer> identifers = new ArrayList<Identifer>();
		identifers.add(new Identifer(address.getCustomer().getClass().getAnnotation(IdentifiedBy.class).domainName(),
				String.valueOf(address.getCustomer().getId())));
		Identifer identifer = new Identifer();
		identifer.setFqdn(address.getClass().getAnnotation(IdentifiedBy.class).domainName());
		identifer.setId(String.valueOf(address.getId()));
		identifers.add(identifer);
		return identifers.toArray(new Identifer[identifers.size()]);
	}

	public static ValueType<String> getValueTypeOfAddressProperty(Address address, String property) {
		ValueType<String> valueType = new ValueType<>();
		try {
			valueType.setProperty(
					address.getClass().getDeclaredField(property).getAnnotation(IdentifiedBy.class).property());
			valueType.setData(property.equalsIgnoreCase("addressLine") ? address.getAddressline()
					: property.equalsIgnoreCase("city") ? address.getCity()
							: property.equalsIgnoreCase("state") ? address.getState()
									: String.valueOf(address.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valueType;
	}
	
	@Override
	public AddressDto getAddress(int id) {
		Address address = addressDao.getAddress(id);
		AddressDto addressDto = AddressMapper.ADDRESS_MAPPER_INSTANCE.convertAddressToDTO(address);
		return addressDto;
	}

	@Override
	public void modifyAddress(Address address) {
		addressDao.save(address);
		
	}

}
