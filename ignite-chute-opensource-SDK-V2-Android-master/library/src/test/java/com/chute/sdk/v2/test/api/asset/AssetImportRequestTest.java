package com.chute.sdk.v2.test.api.asset;

import com.chute.sdk.v2.test.utils.JsonTestUtil;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.TestCase;

import org.json.JSONException;

public class AssetImportRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString()
      throws JsonProcessingException, JSONException {
		String[] urls = new String[] { "http://goo.gl/gLeZX",
				"http://goo.gl/qFaiz" };
		String result = null;
		try {
			result = JsonUtil.getMapper().writer().withRootName("urls")
					.writeValueAsString(urls);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			fail("Serialization threw an exception: " + e.getMessage());
		}
		String expected = TestUtil
				.readResourceAsString("request/AssetImport.json");
		assertTrue(JsonTestUtil.compare(expected, result));
	}
}
