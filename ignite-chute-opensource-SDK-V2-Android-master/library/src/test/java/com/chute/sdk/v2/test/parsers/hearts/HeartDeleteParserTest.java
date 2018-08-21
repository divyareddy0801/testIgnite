package com.chute.sdk.v2.test.parsers.hearts;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.HeartModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class HeartDeleteParserTest extends TestCase {

	public void testHeartDeleteParser() {
		ResponseParser<HeartModel> parser = new ResponseParser<HeartModel>(
				HeartModel.class);
		try {
			ResponseModel<HeartModel> heart = parser.parse(TestUtil.readResourceAsStream("parser/heart/HeartDelete.json"));
			assertEquals(heart.getResponse().getTitle(), "Heart Deleted");
		} catch (Exception e) {
			fail();
		}

	}

}
