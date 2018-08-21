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
 * The {@link SourceModel} class holds asset source information such as source
 * URL, service, import URL and original URL.
 * 
 */
public class SourceModel implements Parcelable {

	public static final String TAG = SourceModel.class.getSimpleName();

	/**
	 * Asset source.
	 */
	@JsonProperty("source")
	private String source;

	/**
	 * Source ID.
	 */
	@JsonProperty("source_id")
	private String sourceId;

	/**
	 * Source URL.
	 */
	@JsonProperty("source_url")
	private String sourceUrl;

	/**
	 * Source service.
	 */
	@JsonProperty("service")
	private String service;

	/**
	 * Import ID.
	 */
	@JsonProperty("import_id")
	private String importId;

	/**
	 * Import URL.
	 */
	@JsonProperty("import_url")
	private String importUrl;

	/**
	 * Original URL.
	 */
	@JsonProperty("original_url")
	private String originalUrl;

	/**
	 * Default non-args constructor.
	 */
	public SourceModel() {
	}

	/**
	 * Getters and setters.
	 */
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getImportId() {
		return importId;
	}

	public void setImportId(String importId) {
		this.importId = importId;
	}

	public String getImportUrl() {
		return importUrl;
	}

	public void setImportUrl(String importUrl) {
		this.importUrl = importUrl;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public SourceModel(Parcel in) {
		source = in.readString();
		sourceId = in.readString();
		sourceUrl = in.readString();
		service = in.readString();
		importId = in.readString();
		importUrl = in.readString();
		originalUrl = in.readString();
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
		dest.writeString(source);
		dest.writeString(sourceId);
		dest.writeString(sourceUrl);
		dest.writeString(service);
		dest.writeString(importId);
		dest.writeString(importUrl);
		dest.writeString(originalUrl);
	}

	public static final Creator<SourceModel> CREATOR = new Creator<SourceModel>() {

		@Override
		public SourceModel createFromParcel(Parcel in) {
			return new SourceModel(in);
		}

		@Override
		public SourceModel[] newArray(int size) {
			return new SourceModel[size];
		}

	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((importId == null) ? 0 : importId.hashCode());
		result = prime * result
				+ ((importUrl == null) ? 0 : importUrl.hashCode());
		result = prime * result
				+ ((originalUrl == null) ? 0 : originalUrl.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result
				+ ((sourceId == null) ? 0 : sourceId.hashCode());
		result = prime * result
				+ ((sourceUrl == null) ? 0 : sourceUrl.hashCode());
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
		SourceModel other = (SourceModel) obj;
		if (importId == null) {
			if (other.importId != null)
				return false;
		} else if (!importId.equals(other.importId))
			return false;
		if (importUrl == null) {
			if (other.importUrl != null)
				return false;
		} else if (!importUrl.equals(other.importUrl))
			return false;
		if (originalUrl == null) {
			if (other.originalUrl != null)
				return false;
		} else if (!originalUrl.equals(other.originalUrl))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (sourceId == null) {
			if (other.sourceId != null)
				return false;
		} else if (!sourceId.equals(other.sourceId))
			return false;
		if (sourceUrl == null) {
			if (other.sourceUrl != null)
				return false;
		} else if (!sourceUrl.equals(other.sourceUrl))
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
		builder.append("SourceModel [source=");
		builder.append(source);
		builder.append(", sourceId=");
		builder.append(sourceId);
		builder.append(", sourceUrl=");
		builder.append(sourceUrl);
		builder.append(", service=");
		builder.append(service);
		builder.append(", importId=");
		builder.append(importId);
		builder.append(", importUrl=");
		builder.append(importUrl);
		builder.append(", originalUrl=");
		builder.append(originalUrl);
		builder.append("]");
		return builder.toString();
	}

}
