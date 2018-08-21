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
package com.chute.sdk.v2.model.response;

import java.util.List;

import com.chute.sdk.v2.model.PaginationModel;
import com.chute.sdk.v2.model.ResponseStatusModel;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link ListResponseModel} class represents a concept of the JSON list
 * response received from the server. It consists of {@link PaginationModel},
 * {@link ResponseStatusModel} and data object.
 * 
 * @param <T>
 *            The response received can be of any kind.
 */
public class ListResponseModel<T> {

	public static final String TAG = ListResponseModel.class.getSimpleName();

	/**
	 * Data object
	 */
	@JsonProperty("data")
	private List<T> data;

	/**
	 * Pagination
	 */
	@JsonProperty("pagination")
	private PaginationModel pagination;

	/**
	 * Response status
	 */
	@JsonProperty("response")
	private ResponseStatusModel response;

	/**
	 * Getters and setters
	 */
	public PaginationModel getPagination() {
		return pagination;
	}

	public void setPagination(PaginationModel pagination) {
		this.pagination = pagination;
	}

	public ResponseStatusModel getResponse() {
		return response;
	}

	public void setResponse(ResponseStatusModel response) {
		this.response = response;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((pagination == null) ? 0 : pagination.hashCode());
		result = prime * result
				+ ((response == null) ? 0 : response.hashCode());
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
		ListResponseModel other = (ListResponseModel) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (pagination == null) {
			if (other.pagination != null)
				return false;
		} else if (!pagination.equals(other.pagination))
			return false;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
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
		builder.append("ListResponseModel [data=");
		builder.append(data);
		builder.append(", pagination=");
		builder.append(pagination);
		builder.append(", response=");
		builder.append(response);
		builder.append("]");
		return builder.toString();
	}

}
