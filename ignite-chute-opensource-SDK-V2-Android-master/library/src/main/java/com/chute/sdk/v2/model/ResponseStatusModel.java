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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link ResponseStatusModel} class represents the status of the response.
 * <p>
 * It holds info regarding error messages, error codes, protocol version, href
 * and API limitations.
 * 
 */
public class ResponseStatusModel {

	public static final String TAG = ResponseStatusModel.class.getSimpleName();

	/**
	 * Response title.
	 */
	@JsonProperty("title")
	private String title;

	/**
	 * Error message.
	 */
	@JsonProperty("error")
	private String error;

	/**
	 * Protocol version.
	 */
	@JsonProperty("version")
	private int version;

	/**
	 * Error code.
	 */
	@JsonProperty("code")
	private int code;

	/**
	 * Href info.
	 */
	@JsonProperty("href")
	private String href;

	/**
	 * API calls limits.
	 */
	@JsonProperty("api_limits")
	private ApiLimitsModel apiLimits;

	/**
	 * Getters and setters.
	 */
	public String getError() {
		return error;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public ApiLimitsModel getApiLimits() {
		return apiLimits;
	}

	public void setApiLimits(ApiLimitsModel apiLimits) {
		this.apiLimits = apiLimits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((apiLimits == null) ? 0 : apiLimits.hashCode());
		result = prime * result + code;
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		result = prime * result + ((href == null) ? 0 : href.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + version;
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
		ResponseStatusModel other = (ResponseStatusModel) obj;
		if (apiLimits == null) {
			if (other.apiLimits != null)
				return false;
		} else if (!apiLimits.equals(other.apiLimits))
			return false;
		if (code != other.code)
			return false;
		if (error == null) {
			if (other.error != null)
				return false;
		} else if (!error.equals(other.error))
			return false;
		if (href == null) {
			if (other.href != null)
				return false;
		} else if (!href.equals(other.href))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (version != other.version)
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
		builder.append("ResponseStatusModel [title=");
		builder.append(title);
		builder.append(", error=");
		builder.append(error);
		builder.append(", version=");
		builder.append(version);
		builder.append(", code=");
		builder.append(code);
		builder.append(", href=");
		builder.append(href);
		builder.append(", apiLimits=");
		builder.append(apiLimits);
		builder.append("]");
		return builder.toString();
	}

}
