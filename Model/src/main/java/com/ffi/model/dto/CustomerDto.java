package com.ffi.model.dto;

import java.util.Arrays;

import com.ffi.model.utility.Identifer;
import com.ffi.model.utility.ValueType;

public class CustomerDto {

	public Identifer[] path;

	public ValueType<String> name;

	public ValueType<String> email;

	public ValueType<String> age;
	
	public ValueType<String> mobile;

	public AddressDto address;

	@Override
	public String toString() {
		return "CustomerDto [path=" + Arrays.toString(path) + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", mobile=" + mobile + ", address=" + address + "]";
	}

}
