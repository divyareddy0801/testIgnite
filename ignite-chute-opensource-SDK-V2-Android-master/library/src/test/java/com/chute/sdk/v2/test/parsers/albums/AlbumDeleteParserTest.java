package com.chute.sdk.v2.test.parsers.albums;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

import junit.framework.TestCase;

public class AlbumDeleteParserTest extends TestCase {

	public void testAlbumDeleteParser() {

		ResponseParser<AlbumModel> parser = new ResponseParser<AlbumModel>(
				AlbumModel.class);
		try {
			System.out.println("RESPONSE " + TestUtil.readResourceAsStream("parser/album/AlbumDelete.json"));
			ResponseModel<AlbumModel> reponse = parser.parse(TestUtil.readResourceAsStream("parser/album/AlbumDelete.json"));
			assertEquals(reponse.getResponse().getTitle(), "Album Deleted");
		} catch (Exception e) {
			fail();
		}
	}

}
