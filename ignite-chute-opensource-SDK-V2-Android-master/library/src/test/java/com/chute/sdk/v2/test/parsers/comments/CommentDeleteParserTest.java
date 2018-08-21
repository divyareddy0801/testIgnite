package com.chute.sdk.v2.test.parsers.comments;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class CommentDeleteParserTest extends TestCase {

	public void testCommentDeleteParser() {
		ResponseParser<CommentModel> parser = new ResponseParser<CommentModel>(
				CommentModel.class);
		try {
			ResponseModel<CommentModel> comment = parser.parse(TestUtil
					.readResourceAsStream("parser/comment/CommentDelete.json"));
			assertEquals(comment.getResponse().getTitle(), "Comment Deleted");
		} catch (Exception e) {
			fail();
		}

	}

}
