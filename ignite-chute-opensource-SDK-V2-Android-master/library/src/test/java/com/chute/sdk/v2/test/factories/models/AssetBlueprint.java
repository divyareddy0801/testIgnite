package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.AssetModel;

public class AssetBlueprint {

	public static AssetModel create() {
		AssetModel model = new AssetModel();
		model.setCaption("sunset");
		model.setVotes(0);
		model.setHearts(0);
		return model;
	}
}