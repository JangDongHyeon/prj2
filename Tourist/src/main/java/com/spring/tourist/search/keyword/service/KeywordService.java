package com.spring.tourist.search.keyword.service;

import org.json.simple.JSONArray;

public interface KeywordService   {
	public JSONArray getArea(int areaPage) throws Exception;
	public JSONArray getAreaGu(int code,int areaPage) throws Exception;
	public JSONArray getType() throws Exception;
	public JSONArray searchList(String areaCode,String sigunguCode,String cart1,String keyword ) throws Exception;
}
