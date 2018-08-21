package com.chute.sdk.v2.test.parsers.albums;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AlbumGetParserTest extends TestCase {

	public void testAlbumsGetParser() {
		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> album = parser.parse(TestUtil
					.readResourceAsStream("parser/album/AlbumGet.json"));
			assertEquals(album.getData().getId(), "2400518");
			assertNotNull(album.getData().getLinks());
			assertEquals(album.getData().getCreatedAt(), "2013-03-27T12:03:35Z");
			assertEquals(album.getData().getUpdatedAt(), "2013-06-27T23:05:38Z");
			assertEquals(album.getData().getShortcut(), "a4u2dyif");
			assertEquals(album.getData().getName(), "Environment");
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
