package com.chute.sdk.v2.test.parsers.albums;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AlbumImportAssetsParserTest extends TestCase {

	public void testAlbumImportAssetsParser() {

		ListResponseParser<AssetModel> parser = new ListResponseParser<AssetModel>(
				AssetModel.class);
		try {
			ListResponseModel<AssetModel> response = parser.parse(TestUtil.readResourceAsStream("parser/album/AlbumImportAssets.json"));
			AssetModel asset = response.getData().get(0);
			assertEquals(asset.getId(), "745149604");
			assertNotNull(asset.getLinks());
			assertEquals(asset.getCreatedAt(), "2013-12-09T13:33:59Z");
			assertEquals(asset.getUpdatedAt(), "2013-12-09T13:33:59Z");
			assertEquals(asset.getShortcut(), "Oqzs0uijx");
			assertEquals(asset.getType(), "image");
			assertEquals(asset.getCaption(), "caption");
			assertNotNull(asset.getLocation());
			assertNotNull(asset.getSource());
			assertEquals(asset.getService(), "uploaded");
			assertEquals(asset.getUsername(), "username");
			assertEquals(asset.getThumbnail(),
					"http://media.getchute.com/media/Oqzs0uijx/75x75");
			assertEquals(asset.getUrl(),
					"http://media.getchute.com/media/Oqzs0uijx");
			assertNotNull(asset.getDimensions());
			assertNotNull(asset.getUser());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

	}

}
