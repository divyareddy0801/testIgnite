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
package com.chute.sdk.v2.api.votes;

import com.chute.sdk.v2.model.AlbumModel;
import com.chute.sdk.v2.model.AssetModel;
import com.chute.sdk.v2.model.VoteModel;
import com.chute.sdk.v2.model.response.ResponseModel;
import com.dg.libs.rest.HttpRequest;
import com.dg.libs.rest.callbacks.HttpCallback;

/**
 * The {@link GCVotes} class is a helper class that contains methods for
 * getting, deleting and creating asset votes.
 * 
 */
public class GCVotes {

  public static final String TAG = GCVotes.class.getSimpleName();

  /**
   * Default non-args constructor
   */
  public GCVotes() {
    super();
  }

  /**
   * Creates a vote for a specific asset within an album.
   * <p>
   * The vote will be marked for the current user making the request.
   * 
   * @param album
   *          Album containing the voted asset.
   * @param asset
   *          Asset containing the created vote.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<AssetModel>}.
   * @return {@link VoteRequest}.
   */
  public static HttpRequest vote(
      final AlbumModel album, final AssetModel asset,
      final HttpCallback<ResponseModel<VoteModel>> callback) {
    return new VoteRequest(album, asset, callback);
  }

  /**
   * Gets number of votes for a specific asset within an album.
   * 
   * @param album
   *          Album containing the voted asset.
   * @param asset
   *          Asset whose votes are counted.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<AssetModel>}.
   * @return {@link VotesGetRequest}.
   */
  public static HttpRequest get(
      final AlbumModel album, final AssetModel asset,
      final HttpCallback<ResponseModel<VoteModel>> callback) {
    return new VotesGetRequest(album, asset, callback);
  }

  /**
   * Deletes an existing heart from an asset.
   * <p>
   * The vote will be marked for the current user making the requests.
   * 
   * @param album
   *          Album containing asset whose vote is going to be deleted.
   * @param asset
   *          Asset containing the vote to be deleted.
   * @param callback
   *          Instance of {@link HttpCallback} interface. If successful, the
   *          callback returns {@link ResponseModel<AssetModel>}.
   * @return {@link UnvoteRequest}.
   */
  public static HttpRequest unvote(
      final AlbumModel album, final AssetModel asset,
      final HttpCallback<ResponseModel<AssetModel>> callback) {
    return new UnvoteRequest(album, asset, callback);
  }
}
