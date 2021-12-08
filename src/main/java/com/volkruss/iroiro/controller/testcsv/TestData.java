package com.volkruss.iroiro.controller.testcsv;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TestData {
	
	@JsonProperty("タイトル")
	public String title;
	
	@JsonProperty("主人公")
	public String protagonist;
}
