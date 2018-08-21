package com.chute.sdk.v2.test.parsers.assets;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AssetDeleteParserTest extends TestCase {

	public void testAssetDeleteParser() {

		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> reponse = parser.parse(TestUtil
					.readResourceAsStream("parser/asset/AssetDelete.json"));
			assertEquals(reponse.getResponse().getTitle(), "Asset Deleted");
		} catch (Exception e) {
			fail();
		}
	}

}
