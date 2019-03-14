package com.ffi.model.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffi.model.Repository.CustomerDao;
import com.ffi.model.annotation.IdentifiedBy;
import com.ffi.model.domain.Address;
import com.ffi.model.domain.Customer;
import com.ffi.model.dto.CustomerDto;
import com.ffi.model.mapper.CustomerMapper;
import com.ffi.model.utility.Identifer;
import com.ffi.model.utility.ValueType;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public CustomerDto getCustomer(int id) {
		Customer customer = customerDao.getCustomer(id);
		CustomerDto customerDto = CustomerMapper.CUSOTMER_MAPPER_INSTANCE.convertCustomerToDTO(customer);
		return customerDto;
	}

	@Override
	public void modifyCustomer(CustomerDto customerDto) {
		Customer customer = null;
		try {
			if (customerDto.path != null) {
				List<Identifer> path = new ArrayList<Identifer>(Arrays.asList(customerDto.path));
				Object obj = Class.forName(path.get(0).fqdn).newInstance();
				if (obj instanceof Customer) {
					customer = customerDao.getCustomer(Integer.parseInt(path.get(0).id));
					if (customerDto.name != null) {
						if (customer.getClass().getDeclaredField("name").getAnnotation(IdentifiedBy.class).property()
								.equalsIgnoreCase(customerDto.name.property)) {
							Field f1 = customer.getClass().getField("customerDto.name.property".toLowerCase());
							f1.set(customer, customerDto.name.data);
						}
					}

					if (customerDto.email != null) {
						if (customer.getClass().getDeclaredField("email").getAnnotation(IdentifiedBy.class).property()
								.equalsIgnoreCase(customerDto.email.property)) {
							Field f1 = customer.getClass().getField("customerDto.email.property".toLowerCase());
							f1.set(customer, customerDto.email.data);
						}
					}

					if (customerDto.age != null) {
						if (customer.getClass().getDeclaredField("age").getAnnotation(IdentifiedBy.class).property()
								.equalsIgnoreCase(customerDto.age.property)) {
							Field f1 = customer.getClass().getField("customerDto.age.property".toLowerCase());
							f1.set(customer, customerDto.age.data);
						}
					}

					if (customerDto.mobile != null) {
						if (customer.getClass().getDeclaredField("mobile").getAnnotation(IdentifiedBy.class).property()
								.equalsIgnoreCase(customerDto.mobile.property)) {
							Field f1 = customer.getClass().getField("customerDto.mobile.property".toLowerCase());
							f1.set(customer, customerDto.mobile.data);
						}
					}
				}
			}
			if (customerDto.address != null) {
				List<Identifer> addressPath = new ArrayList<Identifer>(Arrays.asList(customerDto.address.path));
				if (addressPath.get(0).fqdn != null && addressPath.get(1).fqdn != null) {
					Object object = Class.forName(addressPath.get(0).fqdn).newInstance();
					if (object instanceof Customer) {
						if (null == customer) {
							customer = customerDao.getCustomer(Integer.parseInt(addressPath.get(0).id));
						}
						Address address = customer.getAddress();
						if (customerDto.address.addressline != null) {
							if (address.getClass().getDeclaredField("addressline").getAnnotation(IdentifiedBy.class)
									.property().equalsIgnoreCase(customerDto.address.addressline.property)) {
								Field f1 = address.getClass()
										.getField(customerDto.address.addressline.property.toLowerCase());
								f1.set(address, customerDto.address.addressline.data);
							}
						}

						if (customerDto.address.city != null) {
							if (address.getClass().getDeclaredField("city").getAnnotation(IdentifiedBy.class).property()
									.equalsIgnoreCase(customerDto.address.city.property)) {
								Field f1 = address.getClass().getField(customerDto.address.city.property.toLowerCase());
								f1.set(address, customerDto.address.city.data);
							}
						}

						if (customerDto.address.state != null) {
							if (address.getClass().getDeclaredField("state").getAnnotation(IdentifiedBy.class)
									.property().equalsIgnoreCase(customerDto.address.state.property)) {
								Field f1 = address.getClass()
										.getField(customerDto.address.state.property.toLowerCase());
								f1.set(address, customerDto.address.state.data);
							}
						}
					}
				}
			}
			customerDao.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Identifer[] getCustomerPath(Customer customer) {
		Identifer identifer = new Identifer();
		identifer.setFqdn(customer.getClass().getAnnotation(IdentifiedBy.class).domainName());
		identifer.setId(String.valueOf(customer.getId()));
		return new Identifer[] { identifer };
	}

	public static ValueType<String> getValueTypeOfCustomerProperty(Customer customer, String property) {
		ValueType<String> valueType = new ValueType<String>();
		try {
			valueType.setProperty(
					customer.getClass().getDeclaredField(property).getAnnotation(IdentifiedBy.class).property());
			valueType.setData(property.equalsIgnoreCase("name") ? customer.getName()
					: property.equalsIgnoreCase("email") ? customer.getEmail()
							: property.equalsIgnoreCase("age") ? String.valueOf(customer.getAge())
									: customer.getMobile().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valueType;
	}

}
