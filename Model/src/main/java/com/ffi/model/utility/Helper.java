package com.ffi.model.utility;

import java.util.ArrayList;
import java.util.List;

import com.ffi.model.annotation.IdentifiedBy;
import com.ffi.model.domain.Address;
import com.ffi.model.domain.Customer;

public class Helper {

	public static Identifer[] getPath(Object obj) {
		List<Identifer> identifers = new ArrayList<Identifer>();
		if (obj instanceof Customer) {
			Identifer identifer = new Identifer();
			Customer customer = (Customer) obj;
			identifer.setFqdn(customer.getClass().getAnnotation(IdentifiedBy.class).domainName());
			identifer.setId(String.valueOf(customer.getId()));
			identifers.add(identifer);
		} else if (obj instanceof Address) {
			Address address = (Address) obj;
			identifers
					.add(new Identifer(address.getCustomer().getClass().getAnnotation(IdentifiedBy.class).domainName(),
							String.valueOf(address.getCustomer().getId())));
			Identifer identifer = new Identifer();
			identifer.setFqdn(address.getClass().getAnnotation(IdentifiedBy.class).domainName());
			identifer.setId(String.valueOf(address.getId()));
			identifers.add(identifer);
		}

		return identifers.toArray(new Identifer[identifers.size()]);
	}

	public static ValueType<String> getValueTypeOfProperty(Object obj, String property) {
		ValueType<String> valueType = new ValueType<>();
		try {
			if (obj instanceof Customer) {
				Customer customer = (Customer) obj;
				valueType.setProperty(
						customer.getClass().getDeclaredField(property).getAnnotation(IdentifiedBy.class).property());
				valueType.setData(property.equalsIgnoreCase("name") ? customer.getName()
						: property.equalsIgnoreCase("email") ? customer.getEmail()
								: property.equalsIgnoreCase("age") ? String.valueOf(customer.getAge())
										: String.valueOf(customer.getId()));
			} else if (obj instanceof Address) {
				Address address = (Address) obj;
				valueType.setProperty(
						address.getClass().getDeclaredField(property).getAnnotation(IdentifiedBy.class).property());
				valueType.setData(property.equalsIgnoreCase("addressLine") ? address.getAddressline()
						: property.equalsIgnoreCase("city") ? address.getCity()
								: property.equalsIgnoreCase("state") ? address.getState()
										: String.valueOf(address.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return valueType;
	}
}
