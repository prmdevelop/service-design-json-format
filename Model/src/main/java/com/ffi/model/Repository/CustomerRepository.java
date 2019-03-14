package com.ffi.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffi.model.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
