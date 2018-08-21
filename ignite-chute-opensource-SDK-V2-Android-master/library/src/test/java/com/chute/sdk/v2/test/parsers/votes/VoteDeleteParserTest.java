package com.chute.sdk.v2.test.parsers.votes;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.VoteModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class VoteDeleteParserTest extends TestCase {

	public void testVoteDeleteParser() {

		ResponseParser<VoteModel> parser = new ResponseParser<VoteModel>(
				VoteModel.class);
		try {
			ResponseModel<VoteModel> vote = parser.parse(TestUtil.readResourceAsStream("parser/vote/VoteDelete.json"));
			assertEquals(vote.getResponse().getTitle(), "Heart Deleted");
		} catch (Exception e) {
			fail();
		}

	}

}
