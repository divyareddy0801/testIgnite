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
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * Albums represent a collection of assets which can be created by a single
 * user, viewed by everyone or privileged users.
 * <p>
 * Each album contains links, counters, shortcut, name, which user it belongs
 * to, media and comments moderators and time and date of creation.
 */
@JsonFilter("albumModelFilter")
public class AlbumModel implements Parcelable {

	private static final String TAG = AlbumModel.class.getSimpleName();
	/**
	 * Unique identifier.
	 */
	@JsonProperty("id")
	private String id;

	/**
	 * Album links.
	 */
	@JsonProperty("links")
	private LinkModel links;

	/**
	 * Album counters.
	 */
	@JsonProperty("counters")
	private CounterModel counters;

	/**
	 * Album Shortcut.
	 */
	@JsonProperty("shortcut")
	private String shortcut;

	/**
	 * Album name.
	 */
	@JsonProperty("name")
	private String name;

	/**
	 * The user the album belongs to.
	 */
	@JsonProperty("user")
	private UserModel user;

	/**
	 * Flag indicating whether media is moderated.
	 */
	@JsonProperty("moderate_media")
	private boolean moderateMedia = false;

	/**
	 * Flag indicating whether comments are moderated.
	 */
	@JsonProperty("moderate_comments")
	private boolean moderateComments = false;

	/**
	 * Time and date of creating the album.
	 */
	@JsonProperty("created_at")
	private String createdAt;

	/**
	 * Time and date of updating the album.
	 */
	@JsonProperty("updated_at")
	private String updatedAt;

	/**
	 * Album description.
	 */
	@JsonProperty("description")
	private String description;

	/**
	 * Parent ID of the album.
	 */
	@JsonProperty("parent_id")
	private String parentId;

	/**
	 * Number of images in the album
	 */
	@JsonProperty("images_count")
	private int imagesCount;

	/**
	 * Album's first asset
	 */
	private AssetModel asset;

	/**
	 * Default non-args constructor
	 */
	public AlbumModel() {
	}

	/**
	 * Getters and setters
	 */
	public String getId() {
		return id;
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

	public CounterModel getCounters() {
		return counters;
	}

	public void setCounters(CounterModel counters) {
		this.counters = counters;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public boolean isModerateMedia() {
		return moderateMedia;
	}

	public void setModerateMedia(boolean moderateMedia) {
		this.moderateMedia = moderateMedia;
	}

	public boolean isModerateComments() {
		return moderateComments;
	}

	public void setModerateComments(boolean moderateComments) {
		this.moderateComments = moderateComments;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public int getImagesCount() {
		return imagesCount;
	}

	public void setImagesCount(int imagesCount) {
		this.imagesCount = imagesCount;
	}

	@JsonProperty("asset")
	public AssetModel getAsset() {
		return asset;
	}

	public void setAsset(AssetModel asset) {
		this.asset = asset;
	}

	@JsonSetter("cover_asset")
	private void setCoverAsset(AssetModel coverAsset) {
		this.asset = coverAsset;
	}

	/**
	 * Method used for serializing Album object as a String.
	 */
	public String serializeAlbum() {
		FilterProvider filters = new SimpleFilterProvider().addFilter(
				"albumModelFilter", SimpleBeanPropertyFilter
						.filterOutAllExcept("name", "moderate_comments",
								"moderate_media"));
		String result = null;
		try {
			result = JsonUtil.getMapper().writer(filters)
					.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			Log.d(TAG, e.getMessage(), e);
		}
		return result;
	}

	public AlbumModel(Parcel in) {
		this();
		id = in.readString();
		links = in.readParcelable(LinkModel.class.getClassLoader());
		counters = in.readParcelable(CounterModel.class.getClassLoader());
		shortcut = in.readString();
		name = in.readString();
		user = in.readParcelable(UserModel.class.getClassLoader());
		moderateMedia = in.readInt() == 1;
		moderateComments = in.readInt() == 1;
		createdAt = in.readString();
		updatedAt = in.readString();
		description = in.readString();
		parentId = in.readString();
		imagesCount = in.readInt();
		asset = in.readParcelable(AssetModel.class.getClassLoader());
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
		dest.writeParcelable(counters, flags);
		dest.writeString(shortcut);
		dest.writeString(name);
		dest.writeParcelable(user, flags);
		dest.writeInt(moderateMedia ? 1 : 0);
		dest.writeInt(moderateComments ? 1 : 0);
		dest.writeString(createdAt);
		dest.writeString(updatedAt);
		dest.writeString(description);
		dest.writeString(parentId);
		dest.writeInt(imagesCount);
		dest.writeParcelable(asset, flags);
	}

	public static final Creator<AlbumModel> CREATOR = new Creator<AlbumModel>() {

		@Override
		public AlbumModel createFromParcel(Parcel in) {
			return new AlbumModel(in);
		}

		@Override
		public AlbumModel[] newArray(int size) {
			return new AlbumModel[size];
		}

	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asset == null) ? 0 : asset.hashCode());
		result = prime * result
				+ ((counters == null) ? 0 : counters.hashCode());
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + imagesCount;
		result = prime * result + ((links == null) ? 0 : links.hashCode());
		result = prime * result + (moderateComments ? 1231 : 1237);
		result = prime * result + (moderateMedia ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result
				+ ((shortcut == null) ? 0 : shortcut.hashCode());
		result = prime * result
				+ ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		AlbumModel other = (AlbumModel) obj;
		if (asset == null) {
			if (other.asset != null)
				return false;
		} else if (!asset.equals(other.asset))
			return false;
		if (counters == null) {
			if (other.counters != null)
				return false;
		} else if (!counters.equals(other.counters))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imagesCount != other.imagesCount)
			return false;
		if (links == null) {
			if (other.links != null)
				return false;
		} else if (!links.equals(other.links))
			return false;
		if (moderateComments != other.moderateComments)
			return false;
		if (moderateMedia != other.moderateMedia)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (shortcut == null) {
			if (other.shortcut != null)
				return false;
		} else if (!shortcut.equals(other.shortcut))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AlbumModel [id=");
		builder.append(id);
		builder.append(", links=");
		builder.append(links);
		builder.append(", counters=");
		builder.append(counters);
		builder.append(", shortcut=");
		builder.append(shortcut);
		builder.append(", name=");
		builder.append(name);
		builder.append(", user=");
		builder.append(user);
		builder.append(", moderateMedia=");
		builder.append(moderateMedia);
		builder.append(", moderateComments=");
		builder.append(moderateComments);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append(", description=");
		builder.append(description);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append(", imagesCount=");
		builder.append(imagesCount);
		builder.append(", asset=");
		builder.append(asset);
		builder.append("]");
		return builder.toString();
	}

}