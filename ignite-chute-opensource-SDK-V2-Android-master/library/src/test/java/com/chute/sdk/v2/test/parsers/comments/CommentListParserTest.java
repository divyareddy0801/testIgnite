package com.chute.sdk.v2.test.parsers.comments;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class CommentListParserTest extends TestCase {

	public void testCommentListParser() {

		ListResponseParser<CommentModel> parser = new ListResponseParser<CommentModel>(
				CommentModel.class);
		try {
			ListResponseModel<CommentModel> commentList = parser.parse(TestUtil.readResourceAsStream("parser/comment/CommentList.json"));
			CommentModel comment = commentList.getData().get(0);
			assertEquals(comment.getId(), "779");
			assertNotNull(comment.getLinks());
			assertEquals(comment.getCreatedAt(), "2013-12-09T16:25:12Z");
			assertEquals(comment.getUpdatedAt(), "2013-12-09T16:25:12Z");
			assertEquals(comment.getCommentText(), "awesome");
			assertEquals(comment.getName(), "olga");
			assertEquals(comment.getEmail(), "olga@getchute.com");
			assertNotNull(comment.getUser());
		} catch (Exception e) {
			fail();
		}
	}

}
