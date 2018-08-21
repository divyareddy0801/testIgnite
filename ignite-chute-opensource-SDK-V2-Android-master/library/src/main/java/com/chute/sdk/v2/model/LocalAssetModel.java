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
package com.chute.sdk.v2.model;

import java.io.File;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.chute.sdk.v2.utils.MD5;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link LocalAssetModel} class represents a concept of a local asset.
 * <p>
 * Each local asset contains status, file, priority.
 * 
 */
@JsonFilter("localAssetModelFilter")
public class LocalAssetModel implements Parcelable {

	private static final String TAG = LocalAssetModel.class.getSimpleName();

	/**
	 * Enumeration for the status of the local asset. It can be one of the
	 * following types: UNVERIFIED, NEW, INITIALIZED, COMPLETE or SKIP.
	 */
	public enum AssetStatus {
		UNVERIFIED("unverified"), NEW("new"), INITIALIZED("initialized"), COMPLETE(
				"complete"), SKIP("skip");

		/**
		 * Method used for getting the status of the local asset.
		 * 
		 * @param name
		 */
		private AssetStatus(String name) {
			this.name = name;
		}

		/**
		 * Name of the status.
		 */
		private final String name;

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return name;
		}

	}

	/**
	 * The unique identifier of the local asset.
	 */
	@JsonProperty("id")
	private String assetId;

	/**
	 * The File type of the local asset.
	 */
	private File file;

	/**
	 * The priority of the local asset.
	 */
	private int priority;

	/**
	 * Status of the local asset.
	 */
	@JsonProperty("status")
	private AssetStatus assetStatus;

	/**
	 * The md5 of the file.
	 */
	@JsonProperty("md5")
	private String fileMD5;

	/**
	 * File type.
	 */
	@JsonProperty("type")
	private String identifier;

	/**
	 * Constructor.
	 */
	public LocalAssetModel() {
		super();
		this.assetStatus = AssetStatus.UNVERIFIED;
		this.priority = 1;
	}

	/**
	 * Getter and setter methods.
	 */
	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File localImageFile) {
		this.file = localImageFile;
	}

	public void setFile(String path) {
		this.file = new File(path);
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public AssetStatus getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(AssetStatus assetStatus) {
		this.assetStatus = assetStatus;
	}

	public String getFileMD5() {
		return fileMD5;
	}

	public void setFileMD5(String fileMD5) {
		this.fileMD5 = fileMD5;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getSize() {
		return String.valueOf(file.length());
	}

	/**
	 * Method used for getting MD5 checksum
	 * 
	 */
	public String calculateFileMD5() {
		try {
			this.fileMD5 = MD5.getMD5Checksum(this.file.getPath());
			return this.fileMD5;
		} catch (Exception e) {
			Log.w(TAG, "", e);
		}
		return "";
	}

	public LocalAssetModel(Parcel in) {
		assetId = in.readString();
		file = (File) in.readSerializable();
		priority = in.readInt();
		assetStatus = AssetStatus.values()[in.readInt()];
		fileMD5 = in.readString();
		identifier = in.readString();
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

	/**
	 * Method used for resolving the asset status.
	 * 
	 * @param assetStatus
	 *            String variable which represents the asset status.
	 * @return {@link AssetStatus#name}.
	 */
	public static AssetStatus resolveAssetStatus(String assetStatus) {
		if (assetStatus.contentEquals(AssetStatus.NEW.toString())) {
			return AssetStatus.NEW;
		} else if (assetStatus
				.contentEquals(AssetStatus.INITIALIZED.toString())) {
			return AssetStatus.INITIALIZED;
		} else if (assetStatus.contentEquals(AssetStatus.COMPLETE.toString())) {
			return AssetStatus.COMPLETE;
		} else if (assetStatus.contentEquals(AssetStatus.SKIP.toString())) {
			return AssetStatus.SKIP;
		}
		return AssetStatus.UNVERIFIED;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(assetId);
		dest.writeSerializable(file);
		dest.writeInt(priority);
		dest.writeInt(assetStatus.ordinal());
		dest.writeString(fileMD5);
		dest.writeString(identifier);

	}

	public static final Creator<LocalAssetModel> CREATOR = new Creator<LocalAssetModel>() {

		@Override
		public LocalAssetModel createFromParcel(Parcel in) {
			return new LocalAssetModel(in);
		}

		@Override
		public LocalAssetModel[] newArray(int size) {
			return new LocalAssetModel[size];
		}

	};

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result
				+ ((assetStatus == null) ? 0 : assetStatus.hashCode());
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		result = prime * result + ((fileMD5 == null) ? 0 : fileMD5.hashCode());
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + priority;
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
		LocalAssetModel other = (LocalAssetModel) obj;
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (assetStatus != other.assetStatus)
			return false;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		if (fileMD5 == null) {
			if (other.fileMD5 != null)
				return false;
		} else if (!fileMD5.equals(other.fileMD5))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (priority != other.priority)
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
		builder.append("GCLocalAssetModel [assetId=");
		builder.append(assetId);
		builder.append(", file=");
		builder.append(file);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", assetStatus=");
		builder.append(assetStatus);
		builder.append(", fileMD5=");
		builder.append(fileMD5);
		builder.append(", identifier=");
		builder.append(identifier);
		builder.append("]");
		return builder.toString();
	}

}