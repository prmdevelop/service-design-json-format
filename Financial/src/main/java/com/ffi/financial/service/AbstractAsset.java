package com.ffi.financial.service;

import com.ffi.financial.domain.Asset;

public abstract class AbstractAsset implements IAsset {
	
	public Asset getAsset(String assetId){
		System.out.println("In validate Abstract AssetImpl");
		return null;
	}

	public void validate(Asset asset) {
		System.out.println("In validate Abstract AssetImpl");
	}
}
