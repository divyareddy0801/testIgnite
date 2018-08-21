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
package com.chute.sdk.v2.api.asset;

import com.chute.sdk.v2.api.base.PageRequest;
import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.api.upload.UploadProgressListener;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.PaginationModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.RequestMethod;

import java.util.HashMap;

/**
 * The {@link GCAssets} class is a helper class that consists static methods
 * used for managing {@link AssetModel}.
 * <p>
 * The API enables users and developers to access the following methods:
 * <ul>
 * <li>Get asset from a specific album
 * <li>Get list of assets from a specific album
 * <li>Update asset's caption
 * <li>Get asset's exif information
 * <li>Delete an asset
 * <li>Upload an asset
 * </ul>
 */
public class GCAssets {

	@SuppressWarnings("unused")
	private static final String TAG = GCAssets.class.getSimpleName();

	/**
	 * Private no-args default constructor.
	 */
	private GCAssets() {
		super();
	}

	/**
	 * Gets exif info for an asset.
	 * <p>
	 * Empty if there are no available exif parameters.
	 * 
	 * @param asset
	 *            Asset containing exif data to be retrieved.
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ResponseModel<AssetModel>}.
	 * @return {@link AssetsExifRequest}.
	 */
	public static HttpRequest exif(
			final AssetModel asset,
			final HttpCallback<ResponseModel<HashMap<String, String>>> callback) {
		return new AssetsExifRequest(asset, callback);
	}

	/**
	 * Deletes an asset using its ID.
	 * 
	 * @param asset
	 *            The asset to be removed.
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ResponseModel<AssetModel>}.
	 * @return {@link AssetsDeleteRequest}.
	 */
	public static HttpRequest delete(
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AssetsDeleteRequest(album, asset, callback);
	}

	/**
	 * Updates the caption (description text) on an asset.
	 * 
	 * @param asset
	 *            The asset to be updated.
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ResponseModel<AssetModel>}.
	 * @return {@link AssetsUpdateRequest}.
	 */
	public static HttpRequest update(
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AssetsUpdateRequest(album, asset, callback);
	}

	/**
	 * Gets a specific asset from a given album.
	 * 
	 * @param album
	 *            Album whose asset is demanded.
	 * @param asset
	 *            The requested asset.
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ResponseModel<AssetModel>}.
	 * @return {@link AlbumsGetAssetRequest}.
	 */
	public static HttpRequest get(
			final AlbumModel album, final AssetModel asset,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AlbumsGetAssetRequest(album, asset, callback);
	}

	/**
	 * Gets a list of assets from a specific album.
	 * 
	 * @param album
	 *            The album whose assets are being retrieved.
	 * @param pagination
	 *            Instance of {@link PaginationModel} indicating number of
	 *            assets per page.
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ListResponseModel<AssetModel>}.
	 * @return {@link AlbumsGetAssetListRequest}.
	 */
	public static HttpRequest list(
			final AlbumModel album, PaginationModel pagination,
			final HttpCallback<ListResponseModel<AssetModel>> callback) {
		return new AlbumsGetAssetListRequest(album, pagination,
				callback);
	}

	public static HttpRequest getNextPageOfAssets(
			PaginationModel model,
			final HttpCallback<ListResponseModel<AssetModel>> callback) {
		return new PageRequest<ListResponseModel<AssetModel>>(
			RequestMethod.GET, model.getNextPage(),
				new ListResponseParser<AssetModel>(AssetModel.class), callback);
	}

	/**
	 * Overloaded method
	 * 
	 * @see #list(AlbumModel, PaginationModel, HttpCallback)
	 * 
	 * @param album
	 * @param callback
	 * @return
	 */
	public static HttpRequest list(
			final AlbumModel album,
			final HttpCallback<ListResponseModel<AssetModel>> callback) {
		return new AlbumsGetAssetListRequest(album,
				new PaginationModel(), callback);
	}

	/**
	 * Uploads an asset.
	 * <p>
	 * The upload creates a file out of asset's path and returns the uploaded
	 * {@link AssetModel}.
	 * 
	 * @param uploadListener
	 *            Instance of {@link UploadProgressListener} used for tracking
	 *            the upload progress
	 * @param album
	 *            Album holding the uploaded asset.
	 * @param filePath
	 *            Asset's file path.
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ListResponseModel<AssetModel>}.
	 * @return {@link AssetsFileUploadRequest}.
	 */
	public static HttpRequest upload(
			final UploadProgressListener uploadListener,
			final AlbumModel album, final String filePath,
			final HttpCallback<ListResponseModel<AssetModel>> callback) {
		return new AssetsFileUploadRequest(filePath, album,
				uploadListener, callback);
	}

	/**
	 * Moves the specified asset from one album to another.
	 * 
	 * @param album
	 *            Album holding the asset to be moved.
	 * @param asset
	 *            Asset you wish to move to another album.
	 * @param newAlbum
	 *            Album that is going to store the moved asset.
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ResponseModel<AssetModel>}.
	 * @return {@link AssetsMoveRequest}
	 */
	public static HttpRequest move(
			final AlbumModel album, final AssetModel asset,
			final AlbumModel newAlbum,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AssetsMoveRequest(album, asset, newAlbum, callback);
	}

	/**
	 * Copies the specified asset from one album to another.
	 * 
	 * @param album
	 *            Album holding the asset to be copied.
	 * @param asset
	 *            Asset you wish to copy to another album
	 * @param newAlbum
	 *            Album that is going to store the copied asset.
	 * @param callback
	 *            Instance of {@link HttpCallback} interface. If successful, the
	 *            callback returns {@link ResponseModel<AssetModel>}.
	 * @return {@link AssetsCopyRequest}
	 */
	public static HttpRequest copy(
			final AlbumModel album, final AssetModel asset,
			final AlbumModel newAlbum,
			final HttpCallback<ResponseModel<AssetModel>> callback) {
		return new AssetsCopyRequest(album, asset, newAlbum, callback);
	}

}
