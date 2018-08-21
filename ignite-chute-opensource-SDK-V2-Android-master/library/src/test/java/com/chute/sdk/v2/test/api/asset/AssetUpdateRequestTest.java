package com.chute.sdk.v2.test.api.asset;

import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.test.factories.models.AssetBlueprint;
import com.chute.sdk.v2.test.utils.JsonTestUtil;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import junit.framework.TestCase;

import org.json.JSONException;

public class AssetUpdateRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString()
      throws JsonProcessingException, JSONException {
		AssetModel asset = AssetBlueprint.create();
		FilterProvider filter = new SimpleFilterProvider().addFilter(
				"assetModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("caption", "votes", "hearts"));
		String result = JsonUtil.getMapper().writer(filter)
				.writeValueAsString(asset);
		String expected = TestUtil
				.readResourceAsString("request/AssetUpdate.json");
		assertTrue(JsonTestUtil.compare(expected, result));
	}
}
