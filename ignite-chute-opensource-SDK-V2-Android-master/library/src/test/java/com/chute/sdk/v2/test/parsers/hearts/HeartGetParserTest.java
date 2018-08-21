package com.chute.sdk.v2.test.parsers.hearts;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.HeartModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class HeartGetParserTest extends TestCase {

	public void testHeartGetParser() {

		ResponseParser<HeartModel> parser = new ResponseParser<HeartModel>(
				HeartModel.class);
		try {
			ResponseModel<HeartModel> flag = parser.parse(TestUtil
					.readResourceAsStream("parser/heart/HeartGet.json"));
			assertEquals(flag.getData().getCount(), 1);
		} catch (Exception e) {
			fail();
		}

	}

}
