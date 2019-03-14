package com.ffi.financial.service;

import com.ffi.financial.domain.Asset;

public interface IAsset {
	
	public Asset getAsset(String assetId);

	public void validate(Asset asset);

	public void totalValue(Asset asset);

}
