package com.ffi.financial.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ffi.financial.domain.Financial;

@Component
public class FinancialDaoImpl implements FinancialDao{

	@Autowired
	FinancialRepositroy financialRepository;
	
	@Override
	public Financial getFinancial(int financialId) {
		Financial financial = financialRepository.findById(financialId).get();
		return financial;
	}
}
