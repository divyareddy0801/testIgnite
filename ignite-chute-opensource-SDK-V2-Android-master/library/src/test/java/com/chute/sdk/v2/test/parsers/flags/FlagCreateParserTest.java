package com.chute.sdk.v2.test.parsers.flags;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.FlagModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class FlagCreateParserTest extends TestCase {

	public void testFlagCreateParser() {

		ResponseParser<FlagModel> parser = new ResponseParser<FlagModel>(
				FlagModel.class);
		try {
			ResponseModel<FlagModel> response = parser.parse(TestUtil
					.readResourceAsStream("parser/flag/FlagCreate.json"));
			FlagModel flag = response.getData();
			assertEquals(flag.getId(), "125");
			assertNotNull(flag.getLinks());
			assertEquals(flag.getCreatedAt(), "2013-12-09T16:49:00Z");
			assertEquals(flag.getUpdatedAt(), "2013-12-09T16:49:00Z");
			assertEquals(flag.getIdentifier(), "ryntgxfbtdvxuncveznv1386607740");
			assertEquals(flag.getAlbumId(), "2476863");
			assertEquals(flag.getAssetId(), "669437128");
		} catch (Exception e) {
			fail();
		}

	}

}
