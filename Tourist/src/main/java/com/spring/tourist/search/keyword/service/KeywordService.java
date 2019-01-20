package com.spring.tourist.search.keyword.service;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface KeywordService   {
	public JSONArray getArea(int areaPage) throws Exception;
	public JSONArray getAreaGu(int code,int areaPage) throws Exception;
	public JSONArray getType() throws Exception;
	public Map<String,Object> searchList(String areaCode,String sigunguCode,String cart1,int pageNo) throws Exception;
	public JSONObject getDatail(int contentId) throws Exception;
	
}
