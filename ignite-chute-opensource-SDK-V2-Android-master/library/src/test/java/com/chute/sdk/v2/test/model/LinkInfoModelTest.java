package com.chute.sdk.v2.test.model;

import com.chute.sdk.v2.model.LinkInfoModel;
import com.chute.sdk.v2.test.factories.models.LinkInfoBluePrint;
import com.chute.sdk.v2.test.utils.JsonTestUtil;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import junit.framework.TestCase;

import org.json.JSONException;

public class LinkInfoModelTest extends TestCase {

	public void testLinkInfoModel() throws JsonProcessingException, JSONException {
		LinkInfoModel model = LinkInfoBluePrint.create();
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
				"linkInfoModelFilter",
				SimpleBeanPropertyFilter.filterOutAllExcept("href", "title"));
		String result = JsonUtil.getMapper().writer(filterProvider)
				.writeValueAsString(model);
		String expected = TestUtil.readResourceAsString("model/LinkInfoModel.json");
		assertTrue(JsonTestUtil.compare(expected, result));
	}

}
