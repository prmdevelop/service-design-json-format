package com.ffi.financial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ffi.financial.domain.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset,Integer>{

}
