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


import com.chute.sdk.v2.model.AccountBaseModel;
import com.chute.sdk.v2.model.AccountModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCAccounts} is a helper class that contains static methods for:
 * <ul>
 * <li>Getting all user accounts
 * <li>Getting a list of albums for a specific account
 * <li>Getting a list of media items from an album
 * </ul>
 */
public class GCAccounts {

  public static final String TAG = GCAccounts.class.getSimpleName();

  /**
   * Method used for getting all accounts for the currently authenticated user.
   * <p>
   * Returns list of accounts using given callback.
   * 
   * @param callback
   *          Instance of {@link GCHttpCallback} interface. Returns
   *          {@link ListResponseModel} containing list of accounts.
   * @return Instance of {@link CurrentUserAccountsRequest}, class that
   *         implements {@link GCHttpRequest}.
   */
  public static HttpRequest allUserAccounts(
      final HttpCallback<ListResponseModel<AccountModel>> callback) {
    return new CurrentUserAccountsRequest(callback);
  }

  /**
   * Unlinks all accounts for the currently authenticated user.
   * <p>
   * Returns list of accounts using given callback.
   * 
   * @param accountId
   *          {@link AccountModel} ID
   * @param callback
   *          Instance of {@link GCHttpCallback} interface. Returns
   *          {@link ListResponseModel} containing list of accounts.
   * @return Instance of {@link CurrentUserAccountsRequest}, class that
   *         implements {@link GCHttpRequest}.
   */
  public static HttpRequest unlinkUserAccounts(
      final String accountId,
      final HttpCallback<ListResponseModel<AccountModel>> callback) {
    return new CurrentUserUnlinkAccountsRequest(accountId, callback);
  }

  /**
   * Gets list of albums and media items for a specific account.
   * 
   * @param accountName
   *          Account name.
   *          <p>
   *          It can be: facebook, flickr, instagram, picasa, google,
   *          googledrive, skydrive or dropbox
   * @param accountId
   *          Account ID.
   * @param callback
   *          Instance of {@link GCHttpCallback} interface. Returns
   *          {@link ResponseModel} containing {@link AccountBaseModel}.
   * @return Instance of {@link AccountRootRequest}, class that implements
   *         {@link GCHttpRequest}.
   */
  public static HttpRequest accountRoot(final String accountName,
      final String accountId,
      final HttpCallback<ResponseModel<AccountBaseModel>> callback) {
    return new AccountRootRequest(accountName, accountId, callback);
  }

  /**
   * Returns all immediate subfolders and items of the parent folder.
   * 
   * @param accountName
   *          Account name.
   *          <p>
   *          It can be: facebook, flickr, instagram, picasa, google,
   *          googledrive, skydrive or dropbox
   * @param accountId
   *          Account ID.
   * @param folderId
   *          Account album ID.
   * @param callback
   *          Instance of {@link GCHttpCallback} interface. Returns
   *          {@link ResponseModel} containing {@link AccountBaseModel}.
   * @return Instance of {@link AccountSingleRequest}, class that implements
   *         {@link GCHttpRequest}.
   */
  public static HttpRequest accountSingle(final String accountName, final String accountId,
      final String folderId, final HttpCallback<ResponseModel<AccountBaseModel>> callback) {
    return new AccountSingleRequest(accountName, accountId, folderId, callback);
  }
}
