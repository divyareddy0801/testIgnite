// Copyright (c) 2011, Chute Corporation. All rights reserved.
//
//  Redistribution and use in source and binary forms, with or without modification,
//  are permitted provided that the following conditions are met:
//
//     * Redistributions of source code must retain the above copyright notice, this
//       list of conditions and the following disclaimer.
//     * Redistributions in binary form must reproduce the above copyright notice,
//       this list of conditions and the following disclaimer in the documentation
//       and/or other materials provided with the distribution.
//     * Neither the name of the  Chute Corporation nor the names
//       of its contributors may be used to endorse or promote products derived from
//       this software without specific prior written permission.
//
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
//  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
//  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
//  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
//  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
//  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
//  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
//  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
//  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
//  OF THE POSSIBILITY OF SUCH DAMAGE.
//
package com.chute.sdk.v2.api.user;

import android.text.TextUtils;
import android.util.Log;

import com.chute.sdk.v2.api.parsers.ResponseParser;
import com.chute.sdk.v2.model.UserModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.chute.sdk.v2.utils.MediaTypes;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.RequestMethod;
import com.dg.libs.rest.requests.RestClientRequest;
import com.squareup.okhttp.RequestBody;

import org.json.JSONException;
import org.json.JSONObject;

public class UsersUpdateRequest extends
  RestClientRequest<ResponseModel<UserModel>> {

  public static final String TAG = UsersUpdateRequest.class.getSimpleName();

  public UsersUpdateRequest(UserModel user,
                            HttpCallback<ResponseModel<UserModel>> callback) {
    if (user == null || TextUtils.isEmpty(user.getId())) {
      throw new IllegalArgumentException(
        "Need to provide user ID for editing");
    }
    setParser(new ResponseParser<UserModel>(UserModel.class));
    setCallback(callback);
    setUrl(String.format(RestConstants.URL_USERS_UPDATE, user.getId()));
    setRequestMethod(RequestMethod.PUT, RequestBody.create(MediaTypes.JSON, bodyContents(user)));
  }

  public String bodyContents(UserModel user) {
    JSONObject jsonUser = new JSONObject();
    try {
      jsonUser.putOpt("name", user.getName());
    } catch (JSONException e) {
      Log.e(TAG, "JSONException: " + e.getMessage(), e);
    }
    return jsonUser.toString();
  }

}
