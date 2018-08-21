package com.chute.sdk.v2.test.factories.models;

import com.chute.sdk.v2.model.LinkInfoModel;

public class LinkInfoBluePrint {
	
	public static LinkInfoModel create() {
		LinkInfoModel model = new LinkInfoModel();
		model.setHref("http://api.getchute.com/v2/assets/364003199");
		model.setTitle("Asset Details");
		return model;
	}

}
