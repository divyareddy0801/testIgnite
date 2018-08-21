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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link UserCountModel} wraps information concerning number of uploaded or
 * imported assets by a specific user.
 * 
 */
public class UserCountModel {

	public static final String TAG = UserCountModel.class.getSimpleName();

	/**
	 * Number of uploaded assets.
	 */
	@JsonProperty("via_upload")
	private int viaUpload;

	/**
	 * Number of imported assets.
	 */
	@JsonProperty("via_import")
	private int viaImport;

	/**
	 * Getters and setters.
	 */
	public int getViaUpload() {
		return viaUpload;
	}

	public void setViaUpload(int viaUpload) {
		this.viaUpload = viaUpload;
	}

	public int getViaImport() {
		return viaImport;
	}

	public void setViaImport(int viaImport) {
		this.viaImport = viaImport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + viaImport;
		result = prime * result + viaUpload;
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
		UserCountModel other = (UserCountModel) obj;
		if (viaImport != other.viaImport)
			return false;
		if (viaUpload != other.viaUpload)
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
		builder.append("UserCountModel [viaUpload=");
		builder.append(viaUpload);
		builder.append(", viaImport=");
		builder.append(viaImport);
		builder.append("]");
		return builder.toString();
	}

}
