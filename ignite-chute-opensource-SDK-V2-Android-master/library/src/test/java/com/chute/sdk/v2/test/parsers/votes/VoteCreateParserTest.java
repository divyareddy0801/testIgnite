package com.chute.sdk.v2.test.parsers.votes;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.VoteModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class VoteCreateParserTest extends TestCase {

	public void testVoteCreateParser() {

		ResponseParser<VoteModel> parser = new ResponseParser<VoteModel>(
				VoteModel.class);
		try {
			ResponseModel<VoteModel> response = parser.parse(TestUtil
					.readResourceAsStream("parser/vote/VoteCreate.json"));
			VoteModel vote = response.getData();
			assertEquals(vote.getId(), "948");
			assertNotNull(vote.getLinks());
			assertEquals(vote.getCreatedAt(), "2013-12-09T17:41:48Z");
			assertEquals(vote.getUpdatedAt(), "2013-12-09T17:41:48Z");
			assertEquals(vote.getIdentifier(), "ojwpsakwjgwlebhjyhkf1386610908");
			assertEquals(vote.getAlbumId(), "2476863");
			assertEquals(vote.getAssetId(), "669437128");
		} catch (Exception e) {
			fail();
		}

	}

}
