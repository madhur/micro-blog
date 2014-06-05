package com.axp.amexmicroblog.api;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "message", "createdDate", "retrievalDate", "age" })
public class Content {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("message")
	private String message;
	@JsonProperty("createdDate")
	private Long createdDate;
	@JsonProperty("retrievalDate")
	private Long retrievalDate;
	@JsonProperty("age")
	private String age;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("createdDate")
	public Long getCreatedDate() {
		return createdDate;
	}

	@JsonProperty("createdDate")
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	@JsonProperty("retrievalDate")
	public Long getRetrievalDate() {
		return retrievalDate;
	}

	@JsonProperty("retrievalDate")
	public void setRetrievalDate(Long retrievalDate) {
		this.retrievalDate = retrievalDate;
	}

	@JsonProperty("age")
	public String getAge() {
		return age;
	}

	@JsonProperty("age")
	public void setAge(String age) {
		this.age = age;
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
