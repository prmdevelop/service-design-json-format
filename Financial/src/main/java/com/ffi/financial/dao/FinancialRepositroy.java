package com.ffi.financial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ffi.financial.domain.Financial;

@Repository
public interface FinancialRepositroy extends JpaRepository<Financial, Integer>{

}