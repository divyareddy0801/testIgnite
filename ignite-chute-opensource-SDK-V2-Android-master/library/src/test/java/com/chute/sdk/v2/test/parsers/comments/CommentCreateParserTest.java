package com.chute.sdk.v2.test.parsers.comments;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class CommentCreateParserTest extends TestCase {

	public void testCommentCreateParser() {

		ResponseParser<CommentModel> parser = new ResponseParser<CommentModel>(
				CommentModel.class);
		try {
			ResponseModel<CommentModel> response = parser.parse(TestUtil
					.readResourceAsStream("parser/comment/CommentCreate.json"));
			CommentModel comment = response.getData();
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
