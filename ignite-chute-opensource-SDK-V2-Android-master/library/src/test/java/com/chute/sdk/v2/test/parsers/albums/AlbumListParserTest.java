package com.chute.sdk.v2.test.parsers.albums;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AlbumListParserTest extends TestCase {

	public void testAlbumsListParser() {
		ListResponseParser<AlbumModel> parser = new ListResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ListResponseModel<AlbumModel> model = parser.parse(TestUtil
					.readResourceAsStream("parser/album/AlbumList.json"));
			AlbumModel album =  model.getData().get(0);
			assertEquals(album.getId(), "2489813");
			assertNotNull(album.getLinks());
			assertEquals(album.getCreatedAt(), "2013-12-09T13:24:27Z");
			assertEquals(album.getUpdatedAt(), "2013-12-09T13:24:27Z");
			assertEquals(album.getShortcut(), "arIhoqkp");
			assertEquals(album.getName(), "new");
			assertEquals(album.getDescription(), "description");
			assertNotNull(album.getUser());
			assertEquals(album.isModerateMedia(), false);
			assertEquals(album.isModerateComments(), false);
			assertEquals(album.getParentId(), "23");
		} catch (Exception e) {
			fail();
		}
	}

}
