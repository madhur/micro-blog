package com.axp.amexmicroblog.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "content", "lastPage", "firstPage", "totalElements",
		"totalPages", "numberOfElements", "sort", "size", "number" })
public class LoginResponse extends BaseResponse{

	@JsonProperty("content")
	private List<Content> content = new ArrayList<Content>();
	@JsonProperty("lastPage")
	private Boolean lastPage;
	@JsonProperty("firstPage")
	private Boolean firstPage;
	@JsonProperty("totalElements")
	private Integer totalElements;
	@JsonProperty("totalPages")
	private Integer totalPages;
	@JsonProperty("numberOfElements")
	private Integer numberOfElements;
	@JsonProperty("sort")
	private Object sort;
	@JsonProperty("size")
	private Integer size;
	@JsonProperty("number")
	private Integer number;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("content")
	public List<Content> getContent() {
		return content;
	}

	@JsonProperty("content")
	public void setContent(List<Content> content) {
		this.content = content;
	}

	@JsonProperty("lastPage")
	public Boolean getLastPage() {
		return lastPage;
	}

	@JsonProperty("lastPage")
	public void setLastPage(Boolean lastPage) {
		this.lastPage = lastPage;
	}

	@JsonProperty("firstPage")
	public Boolean getFirstPage() {
		return firstPage;
	}

	@JsonProperty("firstPage")
	public void setFirstPage(Boolean firstPage) {
		this.firstPage = firstPage;
	}

	@JsonProperty("totalElements")
	public Integer getTotalElements() {
		return totalElements;
	}

	@JsonProperty("totalElements")
	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}

	@JsonProperty("totalPages")
	public Integer getTotalPages() {
		return totalPages;
	}

	@JsonProperty("totalPages")
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@JsonProperty("numberOfElements")
	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	@JsonProperty("numberOfElements")
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	@JsonProperty("sort")
	public Object getSort() {
		return sort;
	}

	@JsonProperty("sort")
	public void setSort(Object sort) {
		this.sort = sort;
	}

	@JsonProperty("size")
	public Integer getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(Integer size) {
		this.size = size;
	}

	@JsonProperty("number")
	public Integer getNumber() {
		return number;
	}

	@JsonProperty("number")
	public void setNumber(Integer number) {
		this.number = number;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
