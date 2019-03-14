package com.ffi.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ffi.model.domain.Address;
import com.ffi.model.dto.AddressDto;
import com.ffi.model.service.AddressServiceImpl;

@Mapper(imports=AddressServiceImpl.class)
public interface AddressMapper {

	AddressMapper ADDRESS_MAPPER_INSTANCE = Mappers.getMapper(AddressMapper.class);

	@Mappings({ @Mapping(target = "path", expression = "java(AddressServiceImpl.getAddressPath(address))"),
			@Mapping(target = "addressline", expression = "java(AddressServiceImpl.getValueTypeOfAddressProperty(address,\"addressline\"))"),
			@Mapping(target = "city", expression = "java(AddressServiceImpl.getValueTypeOfAddressProperty(address,\"city\"))"),
			@Mapping(target = "state", expression = "java(AddressServiceImpl.getValueTypeOfAddressProperty(address,\"state\"))") })
	AddressDto convertAddressToDTO(Address address);


}
