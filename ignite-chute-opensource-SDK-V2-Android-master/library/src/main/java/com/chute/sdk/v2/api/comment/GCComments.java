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
package com.chute.sdk.v2.api.comment;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.CommentModel;
import com.chute.sdk.v2.model.response.ListResponseModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCComments} class is a helper class consisting solely of static
 * methods used for {@link CommentModel} manipulation.
 * <p>
 * The API enables you to use the following methods:
 * <ul>
 * <li>Get comments
 * <li>Add a comment
 * <li>Delete a specific comment
 * </ul>
 */
public class GCComments {

  public static final String TAG = GCComments.class.getSimpleName();

  /**
   * Default non-args constructor
   */
  public GCComments() {
    super();
  }

  /**
   * Pulls a complete list of all comments associated with an asset in an album.
   * 
   * @param album
   *          Album containing assets with comments.
   * @param asset
   *          -Asset containing a list of comments.
   * @param callback
   *          -Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ListResponseModel<CommentModel>}.
   * @return {@link CommentsListRequest}.
   */
  public static HttpRequest list(
      final AlbumModel album, final AssetModel asset,
      final HttpCallback<ListResponseModel<CommentModel>> callback) {
    return new CommentsListRequest(album, asset, callback);

  }

  /**
   * Creates new comments for an asset in a specific album.
   * 
   * @param album
   *          Album containing asset the comment belongs to.
   * @param asset
   *          Asset the comment belongs to.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<CommentModel>}.
   * @return {@link CommentsCreateRequest}.
   */
  public static HttpRequest create(
      final AlbumModel album, final AssetModel asset,
      final CommentModel comment,
      final HttpCallback<ResponseModel<CommentModel>> callback) {
    return new CommentsCreateRequest(album, asset, comment,
        callback);
  }

  /**
   * Deletes comments from an asset by using its ID.
   * 
   * @param comment
   *          The comment to be deleted.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<CommentModel>}.
   * @return {@link CommentsDeleteRequest}.
   */
  public static HttpRequest delete(
      final CommentModel comment,
      final HttpCallback<ResponseModel<CommentModel>> callback) {
    return new CommentsDeleteRequest(comment, callback);
  }
}
