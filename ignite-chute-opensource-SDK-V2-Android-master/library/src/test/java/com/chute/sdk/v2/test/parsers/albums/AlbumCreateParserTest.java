package com.chute.sdk.v2.test.parsers.albums;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

import junit.framework.TestCase;

public class AlbumCreateParserTest extends TestCase {

	public void testAlbumCreateParser() {

		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> album = parser.parse(TestUtil
					.readResourceAsStream("parser/album/AlbumCreate.json"));
			assertEquals(album.getData().getId(), "2489813");
			assertNotNull(album.getData().getLinks());
			assertEquals(album.getData().getCreatedAt(), "2013-12-09T13:24:27Z");
			assertEquals(album.getData().getUpdatedAt(), "2013-12-09T13:24:27Z");
			assertEquals(album.getData().getShortcut(), "arIhoqkp");
			assertEquals(album.getData().getName(), "new");
			assertEquals(album.getData().getDescription(), "description");
			assertNotNull(album.getData().getUser());
			assertEquals(album.getData().isModerateMedia(), false);
			assertEquals(album.getData().isModerateComments(), false);
			assertEquals(album.getData().getParentId(), "23");
		} catch (Exception e) {
			fail();
		}
	}

}
