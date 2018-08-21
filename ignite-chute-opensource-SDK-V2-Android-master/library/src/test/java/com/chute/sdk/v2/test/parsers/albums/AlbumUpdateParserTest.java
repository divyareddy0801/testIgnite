package com.chute.sdk.v2.test.parsers.albums;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class AlbumUpdateParserTest extends TestCase {

	public void testAlbumCreateParser() {
		
		
		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			ResponseModel<AlbumModel> response = parser.parse(TestUtil.readResourceAsStream("parser/album/AlbumUpdate.json"));
			AlbumModel album = response.getData();
			assertEquals(album.getId(), "2400518");
			assertNotNull(album.getLinks());
			assertEquals(album.getCreatedAt(), "2013-03-27T12:03:35Z");
			assertEquals(album.getUpdatedAt(), "2013-06-27T23:05:38Z");
			assertEquals(album.getShortcut(), "a4u2dyif");
			assertEquals(album.getName(), "Environment");
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
