package com.chute.sdk.v2.test.api.album;

import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import junit.framework.TestCase;

public class AlbumImportRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString() throws JsonProcessingException {
		String[] urls = new String[] { "http://www.getchute.com",
				"http://www.google.com", "http://www.android.com" };
		String result = null;
		try {
			result = JsonUtil.getMapper().writer().withRootName("urls")
					.writeValueAsString(urls);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			fail("Serialization threw an exception: " + e.getMessage());
		}
		String expected = TestUtil
				.readResourceAsString("request/AlbumImport.json");
		assertEquals(expected, result);
	}
}
