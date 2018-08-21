package com.chute.sdk.v2.test.parsers.hearts;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.HeartModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class HeartCreateParserTest extends TestCase {

	public void testHeartCreateParser() {

		ResponseParser<HeartModel> parser = new ResponseParser<HeartModel>(
				HeartModel.class);
		try {
			ResponseModel<HeartModel> response = parser.parse(TestUtil
					.readResourceAsStream("parser/heart/HeartCreate.json"));
			HeartModel heart = response.getData();
			assertEquals(heart.getId(), "1116014");
			assertNotNull(heart.getLinks());
			assertEquals(heart.getCreatedAt(), "2013-12-09T17:30:25Z");
			assertEquals(heart.getUpdatedAt(), "2013-12-09T17:30:25Z");
			assertEquals(heart.getIdentifier(),
					"yigxwqyrnzugevfphvey1386610225");
			assertEquals(heart.getAlbumId(), "2476863");
			assertEquals(heart.getAssetId(), "669437128");
		} catch (Exception e) {
			fail();
		}

	}

}
