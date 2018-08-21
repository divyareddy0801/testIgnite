package com.chute.sdk.v2.test.parsers.parcels;

import junit.framework.TestCase;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.ParcelModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class ParcelAlbumGetParserTest extends TestCase {

	public void testParcelAlbumGetParser() {

		ListResponseParser<ParcelModel> parser = new ListResponseParser<ParcelModel>(
				ParcelModel.class);
		try {
			ListResponseModel<ParcelModel> parcels = parser
					.parse(TestUtil
							.readResourceAsStream("parser/parcel/ParcelAlbumList.json"));
			ParcelModel parcel = parcels.getData().get(0);
			assertEquals(parcel.getId(), "738290");
			assertNotNull(parcel.getLinks());
			assertEquals(parcel.getCreatedAt(), "2013-09-26T15:26:56Z");
			assertEquals(parcel.getUpdatedAt(), "2013-09-26T15:26:57Z");
			assertEquals(parcel.getShortcut(), "363Udjoi");
		} catch (Exception e) {
			fail();
		}
	}

}
