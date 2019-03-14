package com.ffi.financial.service;

import org.springframework.stereotype.Service;

import com.ffi.financial.domain.Asset;

@Service
public class NonCurrentAssetImpl implements IAsset {

	AbstractAssetActor abstractAssetActor = new AbstractAssetActor();

	@Override
	public Asset getAsset(String assetId) {
		return abstractAssetActor.getAsset(assetId);
	}

	@Override
	public void validate(Asset asset) {
		abstractAssetActor.validate(asset);

	}

	@Override
	public void totalValue(Asset asset) {
		abstractAssetActor.totalValue(asset);

	}

	private class AbstractAssetActor extends AbstractAsset {

		@Override
		public void totalValue(Asset asset) {
			System.out.println("In NonCurrentAsset Abstract method");
		}

	}

}
