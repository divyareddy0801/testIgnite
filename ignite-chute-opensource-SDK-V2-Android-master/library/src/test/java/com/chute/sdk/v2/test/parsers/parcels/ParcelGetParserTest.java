package com.chute.sdk.v2.test.parsers.parcels;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.ParcelModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class ParcelGetParserTest extends TestCase {

	public void testParcelGetParser() {

		ResponseParser<ParcelModel> parser = new ResponseParser<ParcelModel>(
				ParcelModel.class);
		try {
			ResponseModel<ParcelModel> responseModel = parser.parse(TestUtil
					.readResourceAsStream("parser/parcel/ParcelGet.json"));
			ParcelModel parcel = responseModel.getData();
			assertEquals(parcel.getId(), "738289");
			assertNotNull(parcel.getLinks());
			assertEquals(parcel.getCreatedAt(), "2013-09-26T15:24:16Z");
			assertEquals(parcel.getUpdatedAt(), "2013-09-26T15:24:16Z");
			assertEquals(parcel.getShortcut(), "363Tuyvh");
		} catch (Exception e) {
			fail();
		}
	}

}
