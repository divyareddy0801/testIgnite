package com.chute.sdk.v2.test.parsers.assets;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AssetExifParserTest extends TestCase {

	public void testAssetExifParser() {

		// deprecated
		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> asset = parser.parse(TestUtil
					.readResourceAsStream("parser/asset/AssetExif.json"));
			assertEquals(asset.getResponse().getTitle(), "Exif Details");
			assertNotNull(asset.getData());
		} catch (Exception e) {
			fail();
		}
	}

}
