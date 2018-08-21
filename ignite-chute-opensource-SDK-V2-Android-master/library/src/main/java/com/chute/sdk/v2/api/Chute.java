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
package com.chute.sdk.v2.api;

import android.content.Context;

import com.chute.sdk.v2.api.authentication.AuthConstants;
import com.chute.sdk.v2.api.authentication.AuthenticationFactory;
import com.chute.sdk.v2.api.authentication.TokenAuthenticationProvider;
import com.chute.sdk.v2.utils.PreferenceUtil;
import com.dg.libs.rest.RestClientConfiguration;

public class Chute {

  public static final String TAG = Chute.class.getSimpleName();

  /**
   * @param context
   *          The application context.
   * @param constants
   *          Contains the Client ID and Client Secret listed in your Chute app.
   */
  public static void init(Context context, AuthConstants constants) {
    init(context, constants, null);
  }

  /**
   * @param context
   *          The application context.
   * @param constants
   *          Needs to contain both the Client ID and Secret of your Chute app.
   * @param token
   *          can be included if the app shouldn't have user specific
   *          authentication to chute or any of the other services.
   */
  public static void init(Context context, AuthConstants constants, String token) {
    PreferenceUtil.init(context);
    TokenAuthenticationProvider.init(context);
    if (token != null) {
      TokenAuthenticationProvider.getInstance().setToken(token);
    }
    AuthenticationFactory.getInstance().setAuthConstants(constants);
    RestClientConfiguration.init(context, new RestClientConfiguration.
        ConfigurationBuilder().
        setAuthenticationProvider(TokenAuthenticationProvider.getInstance()).
        create());
  }
}
