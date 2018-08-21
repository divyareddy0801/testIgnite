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
package com.chute.sdk.v2.api.geo;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.GeoLocationModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCGeoLocation} class contains methods for getting geo-location
 * info for an asset.
 */
public class GCGeoLocation {

  public static final String TAG = GCGeoLocation.class.getSimpleName();

  /**
   * Gets the coordinates attached to an asset marking the position where the
   * actual file (image for example) was created.
   * <p>
   * Coordinates will be presented as decimal degrees in the response.
   * 
   * @param album
   *          Album holding the asset with geo-location info.
   * @param asset
   *          Asset containing geo-location info.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<GeoLocationModel>}.
   * @return {@link GeoLocationGetRequest}.
   */
  public static HttpRequest get(
      final AlbumModel album, final AssetModel asset,
      final HttpCallback<ResponseModel<GeoLocationModel>> callback) {
    return new GeoLocationGetRequest(album, asset, callback);
  }

  /**
   * Gets a list of assets within a specified radius around a GPS location.
   * 
   * @param asset
   *          Asset containing geo-location info.
   * @param latitude
   *          GPS latitude.
   * @param longitude
   *          GPS longitude.
   * @param radius
   *          Radius in meters.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ListResponseModel<AssetModel>}.
   * @return {@link GeoLocationGetAssetsRequest}.
   */
  public static HttpRequest assets(
      final AssetModel asset, final String latitude,
      final String longitude, final String radius,
      final HttpCallback<ListResponseModel<AssetModel>> callback) {
    return new GeoLocationGetAssetsRequest(asset, latitude,
        longitude, radius, callback);
  }
}
