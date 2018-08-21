package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.SourceModel;

public class SourceBlueprint {

	public static SourceModel create() {
		SourceModel model = new SourceModel();
		model.setSource("chute");
		model.setSourceId("123bg");
		model.setSourceUrl("http://media.getchute.com.s3.amazonaws.com/assets/images/364003199/364003199-oDjRlukgv.jpg");
		model.setService("uploaded");
		model.setImportId("3213asd");
		model.setImportUrl("http://media.getchute.com.s3.amazonaws.com/assets/images/364003199/364003199-oDjRlukgv.jpg");
		return model;
	}
}