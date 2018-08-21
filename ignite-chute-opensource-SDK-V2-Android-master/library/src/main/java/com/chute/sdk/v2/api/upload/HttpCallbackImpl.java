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
package com.chute.sdk.v2.api.upload;

import org.apache.http.HttpStatus;

import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.domain.ResponseStatus;

public abstract class HttpCallbackImpl<T> implements HttpCallback<T> {

  public static final String TAG = HttpCallbackImpl.class.getSimpleName();

  @Override
  public abstract void onSuccess(T responseData, ResponseStatus status);

  /**
   * This method is always triggered when an error occurs.
   * <p>
   * For connection problems the status code is
   * {@link HttpStatus#SC_REQUEST_TIMEOUT}, while the other codes are standard
   * HTTPStatus messages.
   * 
   * @param responseCode
   *          The {@link HttpStatus} code for the error.
   * @param message
   *          Message containing the reason the error occurred.
   */
  public void onGeneralError(int responseCode, String message) {

  }

  @Override
  public void onHttpError(ResponseStatus responseStatus) {
    onGeneralError(
        HttpStatus.SC_REQUEST_TIMEOUT,
        "Request Timeout, Connection problem: "
            + responseStatus.getStatusMessage());
  }
}
