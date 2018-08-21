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
package com.chute.sdk.v2.api.search;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.GeoLocationModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * {@link GCSearch} class is a helper class that performs various search actions
 * using the following API methods:
 * <ul>
 * <li>Get list of assets containing a specific exif info
 * <li>Get list of assets within a radius around a specific GeoLocation
 * <li>Get list of assets containing specific tags
 * </ul>
 */
public class GCSearch {

  public static final String TAG = GCSearch.class.getSimpleName();

  /**
   * Default non-args constructor
   */
  public GCSearch() {
    super();
  }

  /**
   * Gets a list of all assets with a specific EXIF info attached.
   * 
   * @param album
   *          The search will include assets belonging to this album only.
   * @param exif
   *          The EXIF information used in the query.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ListResponseModel<AssetModel>}.
   * @return {@link SearchExifRequest}.
   */
  public static HttpRequest exif(
      final AlbumModel album, final HashMap<String, String> exif,
      final HttpCallback<ListResponseModel<AssetModel>> callback) {
    return new SearchExifRequest(album, exif, callback);
  }

  /**
   * Performs a search for all assets in a radius around a specific GeoLocation.
   * 
   * @param album
   *          The search will include assets belonging to this album only.
   * @param geoLocation
   *          GPS latitude and longitude.
   * @param radius
   *          Radius in meters.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ListResponseModel<AssetModel>}.
   * @return {@link SearchLocationRequest}.
   */
  public static HttpRequest location(
      final AlbumModel album, final GeoLocationModel geoLocation,
      final int radius,
      final HttpCallback<ListResponseModel<AssetModel>> callback) {
    return new SearchLocationRequest(album, geoLocation, radius,
        callback);
  }

  /**
   * Lists all assets containing specific tags.
   * 
   * @param album
   *          The search will include assets belonging to this album only.
   * @param tags
   *          List of tags needed for the query.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ListResponseModel<AssetModel>}.
   * @return {@link com.chute.sdk.v2.api.search.SearchTagsRequest}.
   */
  public static HttpRequest tags(
      final AlbumModel album, final ArrayList<String> tags,
      final HttpCallback<ListResponseModel<AssetModel>> callback) {
    return new SearchTagsRequest(album, tags, callback);
  }

}
