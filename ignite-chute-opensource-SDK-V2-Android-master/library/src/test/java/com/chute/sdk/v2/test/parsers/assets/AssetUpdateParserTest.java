package com.chute.sdk.v2.test.parsers.assets;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AssetUpdateParserTest extends TestCase {

	public void testAssetUpdateParser() {

		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> response = parser.parse(TestUtil
					.readResourceAsStream("parser/asset/AssetUpdate.json"));
			AssetModel asset = response.getData();
			assertEquals(asset.getId(), "669437128");
			assertNotNull(asset.getLinks());
			assertEquals(asset.getCreatedAt(), "2013-09-26T15:26:56Z");
			assertEquals(asset.getUpdatedAt(), "2013-09-26T15:26:56Z");
			assertEquals(asset.getShortcut(), "JiTb2fble");
			assertEquals(asset.getType(), "image");
			assertEquals(asset.getCaption(), "caption");
			assertNotNull(asset.getLocation());
			assertNotNull(asset.getSource());
			assertEquals(asset.getService(), "uploaded");
			assertEquals(asset.getUsername(), "username");
			assertEquals(asset.getThumbnail(),
					"http://media.getchute.com/m/JiTb2fble/c/2476863/75x75");
			assertEquals(asset.getUrl(),
					"http://media.getchute.com/m/JiTb2fble/c/2476863");
			assertNotNull(asset.getDimensions());
			assertNotNull(asset.getUser());
			assertEquals(asset.getVotes(), 3);
			assertEquals(asset.getHearts(), 3);
			assertNotNull(asset.getTags());
			assertEquals(asset.getChuteAssetId(), "1027295339");
		} catch (Exception e) {
			fail();
		}
	}

}
