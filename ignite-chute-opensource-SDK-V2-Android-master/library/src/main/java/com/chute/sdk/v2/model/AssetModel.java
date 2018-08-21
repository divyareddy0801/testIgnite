// Copyright (c) 2011, Chute Corporation. All rights reserved.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
// * Redistributions of source code must retain the above copyright notice, this
// list of conditions and the following disclaimer.
// * Redistributions in binary form must reproduce the above copyright notice,
// this list of conditions and the following disclaimer in the documentation
// and/or other materials provided with the distribution.
// * Neither the name of the Chute Corporation nor the names
// of its contributors may be used to endorse or promote products derived from
// this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
// ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
// WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
// IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
// INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
// BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
// LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
// OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.
//
package com.chute.sdk.v2.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.chute.sdk.v2.utils.JsonUtil;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * An asset represents a single media item and all information connected to it,
 * viewed by everyone or privileged users.
 * <p>
 * Each asset consists of links, thumbnail, URL, type, caption, dimensions,
 * source and the user which the asset belongs to.
 * 
 */
@JsonFilter("assetModelFilter")
public class AssetModel implements Parcelable {

	public static final String TAG = AssetModel.class.getSimpleName();

	/**
	 * Unique identifier.
	 */
	@JsonProperty("id")
	private String id;

	/**
	 * Asset links.
	 */
	@JsonProperty("links")
	private LinkModel links;

	/**
	 * Thumbnail of the asset.
	 */
	@JsonProperty("thumbnail")
	private String thumbnail;

	/**
	 * Asset URL.
	 */
	@JsonProperty("url")
	private String url;

	@JsonProperty("video_url")
	private String videoUrl;

	/**
	 * Asset type.
	 * <p>
	 * It can be image or video.
	 */
	@JsonProperty("type")
	private String type;

	/**
	 * Asset caption information.
	 */
	@JsonProperty("caption")
	private String caption;

	/**
	 * Width and height of the asset.
	 */
	@JsonProperty("dimensions")
	private DimensionsModel dimensions;

	/**
	 * Asset source information.
	 */
	@JsonProperty("source")
	private SourceModel source;

	/**
	 * The user the asset belongs to.
	 */
	@JsonProperty("user")
	private UserModel user;

	/**
	 * Number of asset votes.
	 */
	@JsonProperty("votes")
	private int votes;

	/**
	 * Number of asset hearts.
	 */
	@JsonProperty("hearts")
	private int hearts;

	/**
	 * Asset tags.
	 */
	@JsonProperty("tags")
	private List<String> tags;

	/**
	 * Time and date of creating the asset.
	 */
	@JsonProperty("created_at")
	private String createdAt;

	/**
	 * Time and date of updating the asset.
	 */
	@JsonProperty("updated_at")
	private String updatedAt;

	/**
	 * Asset shortcut.
	 */
	@JsonProperty("shortcut")
	private String shortcut;

	/**
	 * Asset location.
	 */
	@JsonProperty("location")
	private LocationModel location;

	/**
	 * Asset origins.
	 */
	@JsonProperty("service")
	private String service;

	/**
	 * Chute asset ID.
	 */
	@JsonProperty("chute_asset_id")
	private String chuteAssetId;

	/**
	 * Flag indicating whether the asset is in portrait.
	 */
	@JsonProperty("is_portrait")
	private boolean isPortrait;

	/**
	 * Username of the user.
	 */
	@JsonProperty("username")
	private String username;

	/**
	 * Default non-args constructor.
	 */
	public AssetModel() {
	}

	/**
	 * Getters and setters
	 */
	public String getId() {
		return id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public LocationModel getLocation() {
		return location;
	}

	public void setLocation(LocationModel location) {
		this.location = location;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getChuteAssetId() {
		return chuteAssetId;
	}

	public void setChuteAssetId(String chuteAssetId) {
		this.chuteAssetId = chuteAssetId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LinkModel getLinks() {
		return links;
	}

	public void setLinks(LinkModel links) {
		this.links = links;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public DimensionsModel getDimensions() {
		return dimensions;
	}

	public void setDimensions(DimensionsModel dimensions) {
		this.dimensions = dimensions;
	}

	public SourceModel getSource() {
		return source;
	}

	public void setSource(SourceModel source) {
		this.source = source;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public int getHearts() {
		return hearts;
	}

	public void setHearts(int hearts) {
		this.hearts = hearts;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	public boolean isPortrait() {
		return isPortrait;
	}

	public void setPortrait(boolean isPortrait) {
		this.isPortrait = isPortrait;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@SuppressWarnings("unchecked")
	public AssetModel(Parcel in) {
		this();
		id = in.readString();
		links = in.readParcelable(LinkModel.class.getClassLoader());
		thumbnail = in.readString();
		url = in.readString();
		videoUrl = in.readString();
		type = in.readString();
		caption = in.readString();
		dimensions = in.readParcelable(DimensionsModel.class.getClassLoader());
		source = in.readParcelable(SourceModel.class.getClassLoader());
		user = in.readParcelable(UserModel.class.getClassLoader());
		votes = in.readInt();
		hearts = in.readInt();
		createdAt = in.readString();
		updatedAt = in.readString();
		shortcut = in.readString();
		location = in.readParcelable(LocationModel.class.getClassLoader());
		service = in.readString();
		chuteAssetId = in.readString();
		tags = in.readArrayList(String.class.getClassLoader());
		isPortrait = in.readInt() == 1;
		username = in.readString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#describeContents()
	 */
	@Override
	public int describeContents() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeParcelable(links, flags);
		dest.writeString(thumbnail);
		dest.writeString(url);
		dest.writeString(videoUrl);
		dest.writeString(type);
		dest.writeString(caption);
		dest.writeParcelable(dimensions, flags);
		dest.writeParcelable(source, flags);
		dest.writeParcelable(user, flags);
		dest.writeInt(votes);
		dest.writeInt(hearts);
		dest.writeString(createdAt);
		dest.writeString(updatedAt);
		dest.writeString(shortcut);
		dest.writeParcelable(location, flags);
		dest.writeString(service);
		dest.writeString(chuteAssetId);
		dest.writeStringList(tags);
		dest.writeInt(isPortrait ? 1 : 0);
		dest.writeString(username);
	}

	public static final Creator<AssetModel> CREATOR = new Creator<AssetModel>() {

		@Override
		public AssetModel createFromParcel(Parcel in) {
			return new AssetModel(in);
		}

		@Override
		public AssetModel[] newArray(int size) {
			return new AssetModel[size];
		}

	};

	/**
	 * Method used for serializing Asset object as a String
	 */
	public String serializeAsset() {
		String result = null;
		FilterProvider filter = new SimpleFilterProvider().addFilter(
				"assetModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("caption", "votes", "hearts",
								"tags"));
		try {
			result = JsonUtil.getMapper().writer(filter)
					.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			Log.d(TAG, e.getMessage(), e);
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result
				+ ((chuteAssetId == null) ? 0 : chuteAssetId.hashCode());
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((dimensions == null) ? 0 : dimensions.hashCode());
		result = prime * result + hearts;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isPortrait ? 1231 : 1237);
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result
				+ ((shortcut == null) ? 0 : shortcut.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result
				+ ((thumbnail == null) ? 0 : thumbnail.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result
				+ ((videoUrl == null) ? 0 : videoUrl.hashCode());
		result = prime * result + votes;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetModel other = (AssetModel) obj;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (chuteAssetId == null) {
			if (other.chuteAssetId != null)
				return false;
		} else if (!chuteAssetId.equals(other.chuteAssetId))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (dimensions == null) {
			if (other.dimensions != null)
				return false;
		} else if (!dimensions.equals(other.dimensions))
			return false;
		if (hearts != other.hearts)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isPortrait != other.isPortrait)
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (shortcut == null) {
			if (other.shortcut != null)
				return false;
		} else if (!shortcut.equals(other.shortcut))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (thumbnail == null) {
			if (other.thumbnail != null)
				return false;
		} else if (!thumbnail.equals(other.thumbnail))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (videoUrl == null) {
			if (other.videoUrl != null)
				return false;
		} else if (!videoUrl.equals(other.videoUrl))
			return false;
		if (votes != other.votes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AssetModel [id=");
		builder.append(id);
		builder.append(", links=");
		builder.append(links);
		builder.append(", thumbnail=");
		builder.append(thumbnail);
		builder.append(", url=");
		builder.append(url);
		builder.append(", videoUrl=");
		builder.append(videoUrl);
		builder.append(", type=");
		builder.append(type);
		builder.append(", caption=");
		builder.append(caption);
		builder.append(", dimensions=");
		builder.append(dimensions);
		builder.append(", source=");
		builder.append(source);
		builder.append(", user=");
		builder.append(user);
		builder.append(", votes=");
		builder.append(votes);
		builder.append(", hearts=");
		builder.append(hearts);
		builder.append(", tags=");
		builder.append(tags);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", shortcut=");
		builder.append(shortcut);
		builder.append(", location=");
		builder.append(location);
		builder.append(", service=");
		builder.append(service);
		builder.append(", chuteAssetId=");
		builder.append(chuteAssetId);
		builder.append(", isPortrait=");
		builder.append(isPortrait);
		builder.append(", username=");
		builder.append(username);
		builder.append("]");
		return builder.toString();
	}

}
