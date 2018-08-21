package com.chute.sdk.v2.test.parsers.flags;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.FlagModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class FlagDeleteParserTest extends TestCase {

	public void testFlagDeleteParser() {

		ResponseParser<FlagModel> parser = new ResponseParser<FlagModel>(
				FlagModel.class);
		try {
			ResponseModel<FlagModel> flag = parser.parse(TestUtil
					.readResourceAsStream("parser/flag/FlagDelete.json"));
			assertEquals(flag.getResponse().getTitle(), "Flag Removed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

	}

}
