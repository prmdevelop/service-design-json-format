package com.ffi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffi.model.dto.CustomerDto;
import com.ffi.model.service.CustomerService;

@SpringBootApplication
@RestController()
@RequestMapping("/model")
public class ModelApplication {

	@Autowired
	CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(ModelApplication.class, args);
	}

	@GetMapping("/get")
	public String getCustomerObject() {
		String json = null;
		try {
			ObjectMapper objMapper = new ObjectMapper();
			CustomerDto dto = customerService.getCustomer(1);
			json = objMapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	@PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
	public String updateCustomerObject(@RequestBody String jsonString) {
		try {
			ObjectMapper objMapper = new ObjectMapper();
			CustomerDto customerDto = objMapper.readValue(jsonString, CustomerDto.class);
			customerService.modifyCustomer(customerDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Updated";
	}
	
}
