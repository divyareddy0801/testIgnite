package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.LinkModel;

public class LinksBluePrint {

	public static LinkModel create() {
		LinkModel model = new LinkModel();
		model.setSelf(LinkInfoBluePrint.create());
		return model;
	}

}
