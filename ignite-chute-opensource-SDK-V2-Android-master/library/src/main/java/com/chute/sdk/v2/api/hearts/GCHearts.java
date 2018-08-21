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
package com.chute.sdk.v2.api.hearts;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.HeartModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCHearts} class is a helper class which contains the following
 * static methods for manipulating with asset hearts:
 * <ul>
 * <li>Get asset heart
 * <li>Delete asset heart
 * <li>Create asset heart
 * </ul>
 */
public class GCHearts {

  public static final String TAG = GCHearts.class.getSimpleName();

  /**
   * Default non-args constructor
   */
  public GCHearts() {
    super();
  }

  /**
   * Hearts a specific asset in an album.
   * <p>
   * The heart will be marked for the current user executing the requests.
   * 
   * @param album
   *          Album that holds the hearted asset.
   * @param asset
   *          Asset to be hearted.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<HeartModel>}.
   * @return {@link HeartRequest}.
   */
  public static HttpRequest heart(
      final AlbumModel album, final AssetModel asset,
      final HttpCallback<ResponseModel<HeartModel>> callback) {
    return new HeartRequest(album, asset, callback);
  }

  /**
   * Gets a number of all hearts associated with an asset in a specific album.
   * 
   * @param album
   *          -Album that holds the hearted asset.
   * @param asset
   *          Hearted asset.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<HeartModel>}.
   * @return {@link HeartGetRequest}.
   */
  public static HttpRequest get(
      final AlbumModel album, final AssetModel asset,
      final HttpCallback<ResponseModel<HeartModel>> callback) {
    return new HeartGetRequest(album, asset, callback);
  }

  /**
   * Removes an existing heart from an asset.
   * <p>
   * The heart will be marked for the current user executing the requests.
   * 
   * @param album
   *          Album containing the hearted asset.
   * @param asset
   *          Hearted asset.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<HeartModel>}.
   * @return {@link UnheartRequest}.
   */
  public static HttpRequest unheart(
      final AlbumModel album, final AssetModel asset,
      final HttpCallback<ResponseModel<HeartModel>> callback) {
    return new UnheartRequest(album, asset, callback);
  }
}
