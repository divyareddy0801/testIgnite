package com.chute.sdk.v2.test.api.comment;

import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.test.factories.models.CommentBlueprint;
import com.chute.sdk.v2.test.utils.JsonTestUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.TestCase;

import org.json.JSONException;

public class CommentCreateRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString()
      throws JsonProcessingException, JSONException {
		CommentModel comment = CommentBlueprint.create();
		String result = comment.serializeComment();
		String expected = TestUtil
				.readResourceAsString("request/CommentCreate.json");
		assertTrue(JsonTestUtil.compare(expected, result));

	}
}
