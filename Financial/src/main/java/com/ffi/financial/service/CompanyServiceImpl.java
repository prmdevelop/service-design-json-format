package com.ffi.financial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffi.financial.dao.CompanyDao;
import com.ffi.financial.domain.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companyDao;

	@Override
	public Company getCompany(String customerId) {
		Company company = companyDao.getCompany(Integer.parseInt(customerId));
		return company;
	}
}
