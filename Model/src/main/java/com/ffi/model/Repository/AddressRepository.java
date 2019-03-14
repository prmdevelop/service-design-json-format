package com.ffi.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffi.model.domain.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
