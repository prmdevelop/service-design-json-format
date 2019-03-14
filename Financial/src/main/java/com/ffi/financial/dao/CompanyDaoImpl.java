package com.ffi.financial.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ffi.financial.domain.Company;

@Component
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Company getCompany(int customerId) {
		Company company = companyRepository.findById(customerId).get();
		return company;
	}

}
