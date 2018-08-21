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
package com.chute.sdk.v2.api.accounts;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.PreferenceUtil;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.RequestMethod;
import com.dg.libs.rest.requests.RestClientRequest;

import java.io.InputStream;

public class CurrentUserAccountsRequest extends
  RestClientRequest<ListResponseModel<AccountModel>> {

  public static final String TAG = CurrentUserAccountsRequest.class.getSimpleName();

  public CurrentUserAccountsRequest(final HttpCallback<ListResponseModel<AccountModel>> callback) {
    setRequestMethod(RequestMethod.GET);
    setParser(new CurrentAccountsUserResponseParser());
    setCallback(callback);
    setUrl(RestConstants.URL_USER_ACCOUNTS);
  }

  private static class CurrentAccountsUserResponseParser extends
    ListResponseParser<AccountModel> {

    public CurrentAccountsUserResponseParser() {
      super(AccountModel.class);
    }

    @Override
    public ListResponseModel<AccountModel> parse(final InputStream responseBody)
      throws Exception {
      final ListResponseModel<AccountModel> responseModel = super.parse(responseBody);
      if (PreferenceUtil.isInitialized()) {
        for (final AccountModel account : responseModel.getData()) {
          PreferenceUtil.get().saveAccount(account);
        }
      }
      return responseModel;
    }

  }
}
