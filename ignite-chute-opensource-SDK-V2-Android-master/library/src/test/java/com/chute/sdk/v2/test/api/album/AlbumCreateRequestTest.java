package com.chute.sdk.v2.test.api.album;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.test.factories.models.AlbumBlueprint;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import junit.framework.TestCase;

public class AlbumCreateRequestTest extends TestCase {

	public void testObjectSerializeToPostBodyString()
		throws JsonProcessingException {
		AlbumModel album = AlbumBlueprint.create();
		FilterProvider filters = new SimpleFilterProvider().addFilter(
				"albumModelFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name", "moderate_comments", "moderate_media"));
		String result = JsonUtil.getMapper().writer(filters).writeValueAsString(album);
		String expected = TestUtil.readResourceAsString("request/AlbumCreate.json");
		assertEquals(expected, result);
	}
}
