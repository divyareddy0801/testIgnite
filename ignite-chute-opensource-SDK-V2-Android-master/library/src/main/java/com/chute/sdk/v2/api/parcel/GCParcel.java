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
package com.chute.sdk.v2.api.parcel;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.ParcelModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * Helper class that contains static methods for getting album and asset
 * parcels.
 * 
 */
public class GCParcel {

  public static final String TAG = GCParcel.class.getSimpleName();

  public GCParcel() {
  }

  /**
   * Gets parcel info.
   * 
   * @param parcel
   *          The parcel to be retrieved.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<ParcelModel>}.
   * @return {@link ParcelGetRequest}.
   */
  public static HttpRequest get(
      final ParcelModel parcel,
      final HttpCallback<ResponseModel<ParcelModel>> callback) {
    return new ParcelGetRequest(parcel, callback);
  }

  /**
   * Returns a complete list of all parcels in an album.
   * 
   * 
   * @param album
   *          Album containing parcels.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ListResponseModel<ParcelModel>}.
   * @return {@link ParcelAlbumsRequest}.
   */
  public static HttpRequest albums(
      final AlbumModel album,
      final HttpCallback<ListResponseModel<ParcelModel>> callback) {
    return new ParcelAlbumsRequest(album, callback);
  }

  /**
   * Pulls a list of all assets in a specific parcel.
   * 
   * @param parcel
   *          Parcel containing list of assets.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ListResponseModel<ParcelModel>}.
   * @return {@link ParcelAssetsRequest}.
   */
  public static HttpRequest assets(
      final ParcelModel parcel,
      final HttpCallback<ListResponseModel<AssetModel>> callback) {
    return new ParcelAssetsRequest(parcel, callback);
  }
}
