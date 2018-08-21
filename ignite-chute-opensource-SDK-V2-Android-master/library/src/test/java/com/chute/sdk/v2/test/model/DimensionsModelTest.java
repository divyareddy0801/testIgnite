package com.chute.sdk.v2.test.model;

import com.chute.sdk.v2.model.DimensionsModel;
import com.chute.sdk.v2.test.factories.models.DimensionsBlueprint;
import com.chute.sdk.v2.test.utils.JsonTestUtil;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import junit.framework.TestCase;

import org.json.JSONException;

public class DimensionsModelTest extends TestCase {

	public void testDimensionsModel() throws JsonProcessingException, JSONException {
		DimensionsModel model = DimensionsBlueprint.create();
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
				"dimensionsModelFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("width", "height"));
		String result = JsonUtil.getMapper().writer(filterProvider)
				.writeValueAsString(model);
		String expected = TestUtil.readResourceAsString("model/DimensionsModel.json");
		assertTrue(JsonTestUtil.compare(expected, result));
	}

}
