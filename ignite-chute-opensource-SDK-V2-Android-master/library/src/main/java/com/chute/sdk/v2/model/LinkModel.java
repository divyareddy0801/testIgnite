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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link LinkModel} class holds self, asset and exif links.
 * 
 */
public class LinkModel implements Parcelable {

	/**
	 * Self data links.
	 */
	@JsonProperty("self")
	private LinkInfoModel self;

	/**
	 * Asset links.
	 */
	@JsonProperty("assets")
	private LinkInfoModel assets;

	/**
	 * Exif data links.
	 */
	@JsonProperty("exif")
	private LinkInfoModel exif;

	/**
	 * Geo location links.
	 */
	@JsonProperty("geo")
	private LinkInfoModel geo;

	/**
	 * Hearting info links.
	 */
	@JsonProperty("heart")
	private LinkInfoModel heart;

	/**
	 * Vote info links.
	 */
	@JsonProperty("vote")
	private LinkInfoModel vote;

	/**
	 * Parcel links.
	 */
	@JsonProperty("parcels")
	private LinkInfoModel parcels;

	/**
	 * Media links.
	 */
	@JsonProperty("media")
	private LinkInfoModel media;

	/**
	 * Default non-args constructor.
	 */
	public LinkModel() {
	}

	/**
	 * Getters and setters
	 */
	public LinkInfoModel getSelf() {
		return self;
	}

	public void setSelf(LinkInfoModel self) {
		this.self = self;
	}

	public LinkInfoModel getAssets() {
		return assets;
	}

	public void setAssets(LinkInfoModel assets) {
		this.assets = assets;
	}

	public LinkInfoModel getExif() {
		return exif;
	}

	public void setExif(LinkInfoModel exif) {
		this.exif = exif;
	}

	public LinkInfoModel getGeo() {
		return geo;
	}

	public void setGeo(LinkInfoModel geo) {
		this.geo = geo;
	}

	public LinkInfoModel getHeart() {
		return heart;
	}

	public void setHeart(LinkInfoModel heart) {
		this.heart = heart;
	}

	public LinkInfoModel getVote() {
		return vote;
	}

	public void setVote(LinkInfoModel vote) {
		this.vote = vote;
	}

	public LinkInfoModel getParcels() {
		return parcels;
	}

	public void setParcels(LinkInfoModel parcels) {
		this.parcels = parcels;
	}

	public LinkInfoModel getMedia() {
		return media;
	}

	public void setMedia(LinkInfoModel media) {
		this.media = media;
	}

	public LinkModel(Parcel in) {
		self = in.readParcelable(LinkInfoModel.class.getClassLoader());
		assets = in.readParcelable(LinkInfoModel.class.getClassLoader());
		exif = in.readParcelable(LinkInfoModel.class.getClassLoader());
		geo = in.readParcelable(LinkInfoModel.class.getClassLoader());
		heart = in.readParcelable(LinkInfoModel.class.getClassLoader());
		vote = in.readParcelable(LinkInfoModel.class.getClassLoader());
		parcels = in.readParcelable(LinkInfoModel.class.getClassLoader());
		media = in.readParcelable(LinkInfoModel.class.getClassLoader());
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
		dest.writeParcelable(self, flags);
		dest.writeParcelable(assets, flags);
		dest.writeParcelable(exif, flags);
		dest.writeParcelable(geo, flags);
		dest.writeParcelable(heart, flags);
		dest.writeParcelable(vote, flags);
		dest.writeParcelable(parcels, flags);
		dest.writeParcelable(media, flags);
	}

	public static final Creator<LinkModel> CREATOR = new Creator<LinkModel>() {

		@Override
		public LinkModel createFromParcel(Parcel in) {
			return new LinkModel(in);
		}

		@Override
		public LinkModel[] newArray(int size) {
			return new LinkModel[size];
		}

	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assets == null) ? 0 : assets.hashCode());
		result = prime * result + ((exif == null) ? 0 : exif.hashCode());
		result = prime * result + ((geo == null) ? 0 : geo.hashCode());
		result = prime * result + ((heart == null) ? 0 : heart.hashCode());
		result = prime * result + ((media == null) ? 0 : media.hashCode());
		result = prime * result + ((parcels == null) ? 0 : parcels.hashCode());
		result = prime * result + ((self == null) ? 0 : self.hashCode());
		result = prime * result + ((vote == null) ? 0 : vote.hashCode());
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
		LinkModel other = (LinkModel) obj;
		if (assets == null) {
			if (other.assets != null)
				return false;
		} else if (!assets.equals(other.assets))
			return false;
		if (exif == null) {
			if (other.exif != null)
				return false;
		} else if (!exif.equals(other.exif))
			return false;
		if (geo == null) {
			if (other.geo != null)
				return false;
		} else if (!geo.equals(other.geo))
			return false;
		if (heart == null) {
			if (other.heart != null)
				return false;
		} else if (!heart.equals(other.heart))
			return false;
		if (media == null) {
			if (other.media != null)
				return false;
		} else if (!media.equals(other.media))
			return false;
		if (parcels == null) {
			if (other.parcels != null)
				return false;
		} else if (!parcels.equals(other.parcels))
			return false;
		if (self == null) {
			if (other.self != null)
				return false;
		} else if (!self.equals(other.self))
			return false;
		if (vote == null) {
			if (other.vote != null)
				return false;
		} else if (!vote.equals(other.vote))
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
		builder.append("LinkModel [self=");
		builder.append(self);
		builder.append(", assets=");
		builder.append(assets);
		builder.append(", exif=");
		builder.append(exif);
		builder.append(", geo=");
		builder.append(geo);
		builder.append(", heart=");
		builder.append(heart);
		builder.append(", vote=");
		builder.append(vote);
		builder.append(", parcels=");
		builder.append(parcels);
		builder.append(", media=");
		builder.append(media);
		builder.append("]");
		return builder.toString();
	}

}