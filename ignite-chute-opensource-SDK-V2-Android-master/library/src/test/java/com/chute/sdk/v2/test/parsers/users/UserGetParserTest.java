package com.chute.sdk.v2.test.parsers.users;

import junit.framework.TestCase;


import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.UserModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.TestUtil;

public class UserGetParserTest extends TestCase {

	public void testUserGetParser() {

		ResponseParser<UserModel> parser = new ResponseParser<UserModel>(
				UserModel.class);
		try {
			ResponseModel<UserModel> user = parser.parse(TestUtil.readResourceAsStream("parser/user/UserGet.json"));
			assertEquals(user.getData().getId(), "545");
			assertNotNull(user.getData().getLinks());
			assertEquals(user.getData().getName(), "darko1002001");
			assertEquals(user.getData().getUsername(), "darko1002001");
			assertEquals(user.getData().getAvatar(),
					"http://static.getchute.com/v1/images/avatar-100x100.png");
			assertEquals(user.getData().getCreated_at(), "2012-01-17T19:53:39Z");
			assertEquals(user.getData().getUpdated_at(), "2013-12-05T18:30:57Z");
//			assertNotNull(user.getData().getProfile());
		} catch (Exception e) {
			fail();
		}
	}

}
