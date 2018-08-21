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

import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The {@link PaginationModel} class wraps up information about pagination of
 * the response.
 * <p>
 * The response can show total pages, current page, previous page, first page,
 * last page and number of responses per page.
 * 
 */
public class PaginationModel {

	public static final int DEFAULT_PER_PAGE = 50;

	/**
	 * Number of total response pages.
	 */
	@JsonProperty("total_pages")
	private long totalPages;

	/**
	 * The current page of the response.
	 */
	@JsonProperty("current_page")
	private long currentPage;

	/**
	 * The next page of the response.
	 */
	@JsonProperty("next_page")
	private String nextPage;

	/**
	 * The previous page of the response.
	 */
	@JsonProperty("previous_page")
	private String previousPage;

	/**
	 * The first page of the response.
	 */
	@JsonProperty("first_page")
	private String firstPage;

	/**
	 * The last page of the response.
	 */
	@JsonProperty("last_page")
	private String lastPage;

	/**
	 * Number of responses per page.
	 */
	@JsonProperty("per_page")
	private int perPage = DEFAULT_PER_PAGE;

	/**
	 * Getters and setters.
	 */
	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public boolean hasNextPage() {
		return TextUtils.isEmpty(nextPage) == false;
	}

	public String getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(String previousPage) {
		this.previousPage = previousPage;
	}

	public boolean hasPreviousPage() {
		return TextUtils.isEmpty(previousPage) == false;
	}

	public String getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}

	public String getLastPage() {
		return lastPage;
	}

	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public String getPerPageAsString() {
		return String.valueOf(perPage);
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (currentPage ^ (currentPage >>> 32));
		result = prime * result
				+ ((firstPage == null) ? 0 : firstPage.hashCode());
		result = prime * result
				+ ((lastPage == null) ? 0 : lastPage.hashCode());
		result = prime * result
				+ ((nextPage == null) ? 0 : nextPage.hashCode());
		result = prime * result + perPage;
		result = prime * result
				+ ((previousPage == null) ? 0 : previousPage.hashCode());
		result = prime * result + (int) (totalPages ^ (totalPages >>> 32));
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
		PaginationModel other = (PaginationModel) obj;
		if (currentPage != other.currentPage)
			return false;
		if (firstPage == null) {
			if (other.firstPage != null)
				return false;
		} else if (!firstPage.equals(other.firstPage))
			return false;
		if (lastPage == null) {
			if (other.lastPage != null)
				return false;
		} else if (!lastPage.equals(other.lastPage))
			return false;
		if (nextPage == null) {
			if (other.nextPage != null)
				return false;
		} else if (!nextPage.equals(other.nextPage))
			return false;
		if (perPage != other.perPage)
			return false;
		if (previousPage == null) {
			if (other.previousPage != null)
				return false;
		} else if (!previousPage.equals(other.previousPage))
			return false;
		if (totalPages != other.totalPages)
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
		builder.append("PaginationModel [totalPages=");
		builder.append(totalPages);
		builder.append(", currentPage=");
		builder.append(currentPage);
		builder.append(", nextPage=");
		builder.append(nextPage);
		builder.append(", previousPage=");
		builder.append(previousPage);
		builder.append(", firstPage=");
		builder.append(firstPage);
		builder.append(", lastPage=");
		builder.append(lastPage);
		builder.append(", perPage=");
		builder.append(perPage);
		builder.append("]");
		return builder.toString();
	}

}