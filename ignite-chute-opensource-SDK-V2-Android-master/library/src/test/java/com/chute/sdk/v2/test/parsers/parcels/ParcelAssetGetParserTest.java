package com.chute.sdk.v2.test.parsers.parcels;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class ParcelAssetGetParserTest extends TestCase {

	public void testParcelAssetGetParser() {

		ListResponseParser<AssetModel> parser = new ListResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ListResponseModel<AssetModel> assets = parser
					.parse(TestUtil
							.readResourceAsStream("parser/parcel/ParcelAssetList.json"));
			AssetModel asset = assets.getData().get(0);
			assertEquals(asset.getId(), "669433756");
			assertNotNull(asset.getLinks());
			assertEquals(asset.getCreatedAt(), "2013-09-26T15:24:16Z");
			assertEquals(asset.getUpdatedAt(), "2013-09-26T15:24:16Z");
			assertEquals(asset.getShortcut(), "JiSiEhsat");
			assertEquals(asset.getType(), "image");
			assertEquals(asset.getCaption(), "caption");
			assertNotNull(asset.getLocation());
			assertNotNull(asset.getSource());
			assertEquals(asset.getService(), "uploaded");
			assertEquals(asset.getUsername(), "username");
			assertEquals(asset.getThumbnail(),
					"http://media.getchute.com/media/JiSiEhsat/75x75");
			assertEquals(asset.getUrl(),
					"http://media.getchute.com/media/JiSiEhsat");
			assertNotNull(asset.getDimensions());
			assertNotNull(asset.getUser());
		} catch (Exception e) {
			fail();
		}
	}

}
