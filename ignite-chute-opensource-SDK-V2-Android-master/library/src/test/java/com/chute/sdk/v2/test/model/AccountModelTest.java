package com.chute.sdk.v2.test.model;

import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.test.utils.JsonTestUtil;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.TestUtil;

import junit.framework.TestCase;

import org.json.JSONException;

import java.io.IOException;

public class AccountModelTest extends TestCase {

	String testModel = TestUtil.readResourceAsString("model/AccountModel.json");

	public void testAccountModel() throws IOException, JSONException {
		AccountModel initialModel = JsonUtil.getMapper().readValue(testModel,
				AccountModel.class);
		AccountModel secondModel = AccountModel.fromJSON(initialModel.toJSON());
		assertTrue(JsonTestUtil.compare(initialModel.toJSON(), secondModel.toJSON()));
	}

}
