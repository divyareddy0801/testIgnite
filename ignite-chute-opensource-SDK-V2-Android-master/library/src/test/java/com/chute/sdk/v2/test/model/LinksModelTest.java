package com.chute.sdk.v2.test.model;

import com.chute.sdk.v2.model.LinkModel;
import com.chute.sdk.v2.test.factories.models.LinksBluePrint;
import com.chute.sdk.v2.test.utils.JsonTestUtil;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import junit.framework.TestCase;

import org.json.JSONException;

public class LinksModelTest extends TestCase {

	public void testLinksModel() throws JsonProcessingException, JSONException {
		LinkModel model = LinksBluePrint.create();
		FilterProvider filter = new SimpleFilterProvider().addFilter(
				"linksModelFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("self"));
		String result = JsonUtil.getMapper().writer(filter)
				.writeValueAsString(model);
		String expected = TestUtil
				.readResourceAsString("model/LinksModel.json");
		assertTrue(JsonTestUtil.compare(expected,result));
	}

}
