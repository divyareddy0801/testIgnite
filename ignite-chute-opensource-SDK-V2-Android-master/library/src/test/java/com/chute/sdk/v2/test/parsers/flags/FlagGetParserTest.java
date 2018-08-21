package com.chute.sdk.v2.test.parsers.flags;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.FlagModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class FlagGetParserTest extends TestCase {

	public void testFlagGetParser() {

		ResponseParser<FlagModel> parser = new ResponseParser<FlagModel>(
				FlagModel.class);
		try {
			ResponseModel<FlagModel> flag = parser.parse(TestUtil.readResourceAsStream("parser/flag/FlagGet.json"));
			assertEquals(flag.getData().getCount(), 1);
		} catch (Exception e) {
			fail();
		}

	}

}
