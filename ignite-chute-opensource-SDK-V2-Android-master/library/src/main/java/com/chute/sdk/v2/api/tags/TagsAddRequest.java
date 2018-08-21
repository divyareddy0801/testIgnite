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
package com.chute.sdk.v2.api.tags;

import android.text.TextUtils;
import android.util.Log;

import com.chute.sdk.v2.api.parsers.ListResponseParser;
import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.utils.JsonUtil;
import com.chute.sdk.v2.utils.MediaTypes;
import com.chute.sdk.v2.utils.RestConstants;
import com.dg.libs.rest.callbacks.HttpCallback;
import com.dg.libs.rest.client.RequestMethod;
import com.dg.libs.rest.requests.RestClientRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.squareup.okhttp.RequestBody;

import java.util.List;

public class TagsAddRequest extends
	RestClientRequest<ListResponseModel<String>> {

	public static final String TAG = TagsAddRequest.class.getSimpleName();

	public TagsAddRequest(AlbumModel album, AssetModel asset,
			List<String> tags, HttpCallback<ListResponseModel<String>> callback) {
		if (asset == null || TextUtils.isEmpty(asset.getId())) {
			throw new IllegalArgumentException("Need to provide asset ID");
		}
		if (album == null || TextUtils.isEmpty(album.getId())) {
			throw new IllegalArgumentException("Need to provide album ID");
		}
		if (tags.size() == 0) {
			throw new IllegalArgumentException(
					"Need to provide tags for updating the asset");
		}
		setParser(new ListResponseParser<String>(String.class));
		setCallback(callback);
		setUrl(String.format(RestConstants.URL_ASSETS_TAGS, album.getId(), asset.getId()));
		setRequestMethod(RequestMethod.POST, RequestBody.create(MediaTypes.JSON, bodyContents(tags)));
	}

	public String bodyContents(List<String> tags) {
		try {
			return JsonUtil.getMapper().writer().withRootName("tags")
					.writeValueAsString(tags);
		} catch (JsonProcessingException e) {
			Log.e(TAG, "", e);
		}
		return null;
	}

}
