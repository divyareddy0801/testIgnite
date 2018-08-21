package com.chute.sdk.v2.test.api.album;

import junit.framework.TestCase;

import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

public class AlbumsAddAssetsRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString() {
		String[] assetIds = new String[] { "1", "2", "3", "4" };
		String result = null;
		try {
			result = JsonUtil.getMapper().writer().withRootName("asset_ids")
					.writeValueAsString(assetIds);
			System.out.println(result);
		} catch (JsonProcessingException e) {
			fail("Serialization threw an exception: " + e.getMessage());
		}
		String expected = TestUtil
				.readResourceAsString("request/AlbumAddAssets.json");
		assertEquals(expected, result);
	}
}
