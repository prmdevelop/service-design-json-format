package com.ffi.financial.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.ffi.financial.domain.Asset;

public class AssetDaoImpl implements AssetDao {

	@Autowired
	AssetRepository assetRepository;

	@Override
	public Asset getAsset(int assetId) {
		Asset asset = assetRepository.findById(assetId).get();
		return asset;
	}

}
