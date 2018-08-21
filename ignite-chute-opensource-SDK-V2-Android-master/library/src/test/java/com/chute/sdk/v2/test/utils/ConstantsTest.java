package com.chute.sdk.v2.test.utils;

import junit.framework.TestCase;

import com.chute.sdk.v2.utils.Constants;

public class ConstantsTest extends TestCase{

	public void testCurrentUserId() {
		assertEquals(Constants.CURRENT_USER_ID, "me");
	}
}
