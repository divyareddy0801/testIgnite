package com.chute.sdk.v2.test.parsers.geo;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.GeoLocationModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class GeoGetParserTest extends TestCase {

	public void testGeoGetParser() {

		ResponseParser<GeoLocationModel> parser = new ResponseParser<GeoLocationModel>(
				GeoLocationModel.class);
		try {
			ResponseModel<GeoLocationModel> geo = parser.parse(TestUtil.readResourceAsStream("parser/geo/GeoGet.json"));
			assertNotNull(geo.getData());
		} catch (Exception e) {
			fail();
		}
	}

}
