package com.chute.sdk.v2.test.model;

import com.chute.sdk.v2.model.SourceModel;
import com.chute.sdk.v2.test.factories.models.SourceBlueprint;
import com.chute.sdk.v2.test.utils.JsonTestUtil;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import junit.framework.TestCase;

import org.json.JSONException;

public class SourceModelTest extends TestCase {

	public void testSourceModel() throws JsonProcessingException, JSONException {
		SourceModel model = SourceBlueprint.create();
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
				"sourceModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("source", "source_id",
								"source_url", "service", "import_id",
								"import_url"));
		String result = JsonUtil.getMapper().writer(filterProvider)
				.writeValueAsString(model);
		String expected = TestUtil.readResourceAsString("model/SourceModel.json");
		assertTrue(JsonTestUtil.compare(expected, result));
	}

}
