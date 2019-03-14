package com.ffi.model.dto;

import java.util.Arrays;

import com.ffi.model.utility.Identifer;
import com.ffi.model.utility.ValueType;

public class AddressDto {
	
	public Identifer[] path;
	
	public ValueType<String> addressline;
	
	public ValueType<String> city;
	
	public ValueType<String> state;

	@Override
	public String toString() {
		return "AddressDto [path=" + Arrays.toString(path) + ", addressline=" + addressline + ", city=" + city
				+ ", state=" + state + "]";
	}
	
}
