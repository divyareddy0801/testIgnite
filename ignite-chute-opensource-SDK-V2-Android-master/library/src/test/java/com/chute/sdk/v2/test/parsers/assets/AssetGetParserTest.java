package com.chute.sdk.v2.test.parsers.assets;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AssetGetParserTest extends TestCase {

	public void testAssetGetParser() {

		ResponseParser<AssetModel> parser = new ResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ResponseModel<AssetModel> asset = parser.parse(TestUtil
					.readResourceAsStream("parser/asset/AssetGet.json"));
			assertEquals(asset.getData().getId(), "669437128");
			assertNotNull(asset.getData().getLinks());
			assertEquals(asset.getData().getCreatedAt(), "2013-09-26T15:26:56Z");
			assertEquals(asset.getData().getUpdatedAt(), "2013-09-26T15:26:56Z");
			assertEquals(asset.getData().getShortcut(), "JiTb2fble");
			assertEquals(asset.getData().getType(), "image");
			assertEquals(asset.getData().getCaption(), "caption");
			assertNotNull(asset.getData().getLocation());
			assertNotNull(asset.getData().getSource());
			assertEquals(asset.getData().getService(), "uploaded");
			assertEquals(asset.getData().getUsername(), "username");
			assertEquals(asset.getData().getThumbnail(),
					"http://media.getchute.com/m/JiTb2fble/c/2476863/75x75");
			assertEquals(asset.getData().getUrl(),
					"http://media.getchute.com/m/JiTb2fble/c/2476863");
			assertNotNull(asset.getData().getDimensions());
			assertNotNull(asset.getData().getUser());
			assertEquals(asset.getData().getVotes(), 3);
			assertEquals(asset.getData().getHearts(), 3);
			assertNotNull(asset.getData().getTags());
			assertEquals(asset.getData().getChuteAssetId(), "1027295339");
		} catch (Exception e) {
			fail();
		}
	}

}
