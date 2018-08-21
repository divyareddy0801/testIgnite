package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.DimensionsModel;

public class DimensionsBlueprint {

	public static DimensionsModel create() {
		DimensionsModel model = new DimensionsModel();
		model.setWidth("75");
		model.setHeight("75");
		return model;
	}
}