package com.ffi.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ffi.model.domain.Customer;
import com.ffi.model.dto.CustomerDto;
import com.ffi.model.service.CustomerServiceImpl;

@Mapper(uses = {AddressMapper.class},imports = CustomerServiceImpl.class)
public interface CustomerMapper {

	CustomerMapper CUSOTMER_MAPPER_INSTANCE = Mappers.getMapper(CustomerMapper.class);

	@Mappings({ @Mapping(target = "path", expression = "java(CustomerServiceImpl.getCustomerPath(customer))"),
			@Mapping(target = "name", expression = "java(CustomerServiceImpl.getValueTypeOfCustomerProperty(customer,\"name\"))"),
			@Mapping(target = "email", expression = "java(CustomerServiceImpl.getValueTypeOfCustomerProperty(customer,\"email\"))"),
			@Mapping(target = "age", expression = "java(CustomerServiceImpl.getValueTypeOfCustomerProperty(customer,\"age\"))"),
			@Mapping(target = "mobile", expression = "java(CustomerServiceImpl.getValueTypeOfCustomerProperty(customer,\"mobile\"))")})
	CustomerDto convertCustomerToDTO(Customer customer);
}
