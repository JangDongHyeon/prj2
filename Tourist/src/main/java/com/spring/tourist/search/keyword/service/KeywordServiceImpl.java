package com.spring.tourist.search.keyword.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Override
	public JSONArray getArea(int areaPage) throws Exception {
		BufferedInputStream reader = null;
		try {
			URL url = new URL(
					"http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?"
		+ "ServiceKey=IXBlJg7qk96wYkcCFZRMtNVWvUKb11PwWfZIKMJXtoOB5a0VWe9%2BziRYfhlJzuR6Myr1x6KBbFYF8CuRkUJSWQ%3D%3D&" + "&ta"
				+ "&MobileOS=ETC&MobileApp=AppTesting"+"&pageNo="+areaPage
		+"&_type=json");
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}

			JSONParser jsonparser = new JSONParser();
			JSONObject jsonobject = (JSONObject) jsonparser.parse(buffer.toString());
			JSONObject json = (JSONObject) jsonobject.get("response");
			JSONObject json1 = (JSONObject) json.get("body");
			JSONObject json2 = (JSONObject) json1.get("items");
			JSONArray array = (JSONArray) json2.get("item");

			return array;

		} finally {
			if (reader != null)
				reader.close();
		}
	
	}

	@Override
	public JSONArray getAreaGu(int code, int areaPage) throws Exception {
		BufferedInputStream reader = null;
		try {
			URL url = new URL(
					"http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?"
		+ "ServiceKey=IXBlJg7qk96wYkcCFZRMtNVWvUKb11PwWfZIKMJXtoOB5a0VWe9%2BziRYfhlJzuR6Myr1x6KBbFYF8CuRkUJSWQ%3D%3D"
				+ "&MobileOS=ETC&MobileApp=AppTesting"+"&pageNo="+areaPage+"&areaCode="+code
		+"&numOfRows=11"+"&_type=json");
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}

			JSONParser jsonparser = new JSONParser();
			JSONObject jsonobject = (JSONObject) jsonparser.parse(buffer.toString());
			JSONObject json = (JSONObject) jsonobject.get("response");
			JSONObject json1 = (JSONObject) json.get("body");
			JSONObject json2 = (JSONObject) json1.get("items");
			JSONArray array = (JSONArray) json2.get("item");

			return array;

		} finally {
			if (reader != null)
				reader.close();
		}
	}

	@Override
	public JSONArray getType() throws Exception {
		BufferedInputStream reader = null;
		try {
			URL url = new URL(
					"http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode?"
		+ "ServiceKey=IXBlJg7qk96wYkcCFZRMtNVWvUKb11PwWfZIKMJXtoOB5a0VWe9%2BziRYfhlJzuR6Myr1x6KBbFYF8CuRkUJSWQ%3D%3D"
				+ "&MobileOS=ETC&MobileApp=AppTesting"
		+"&_type=json");
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}

			JSONParser jsonparser = new JSONParser();
			JSONObject jsonobject = (JSONObject) jsonparser.parse(buffer.toString());
			JSONObject json = (JSONObject) jsonobject.get("response");
			JSONObject json1 = (JSONObject) json.get("body");
			JSONObject json2 = (JSONObject) json1.get("items");
			JSONArray array = (JSONArray) json2.get("item");

			return array;

		} finally {
			if (reader != null)
				reader.close();
		}
	
}

	@Override
	public JSONArray searchList(String areaCode, String sigunguCode, String cart1, String keyword) throws Exception {
		BufferedInputStream reader = null;
	 String str="http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode?";
		str+="ServiceKey=IXBlJg7qk96wYkcCFZRMtNVWvUKb11PwWfZIKMJXtoOB5a0VWe9%2BziRYfhlJzuR6Myr1x6KBbFYF8CuRkUJSWQ%3D%3D";
		str+="&MobileOS=ETC&MobileApp=AppTesting&keyword="+keyword;
		if(!areaCode.equals("sel")) str+="&areaCode="+areaCode;
		if(!sigunguCode.equals("sel")) str+="&sigunguCode="+sigunguCode;
		if(!cart1.equals("sel")) str+="&cart1="+cart1;
				
		try {
			URL url = new URL(str
					);
			reader = new BufferedInputStream(url.openStream());
			StringBuffer buffer = new StringBuffer();
			int i;
			byte[] b = new byte[4096];
			while ((i = reader.read(b)) != -1) {
				buffer.append(new String(b, 0, i));
			}

			JSONParser jsonparser = new JSONParser();
			JSONObject jsonobject = (JSONObject) jsonparser.parse(buffer.toString());
			JSONObject json = (JSONObject) jsonobject.get("response");
			JSONObject json1 = (JSONObject) json.get("body");
			JSONObject json2 = (JSONObject) json1.get("items");
			JSONArray array = (JSONArray) json2.get("item");

			return array;

		} finally {
			if (reader != null)
				reader.close();
		}
	}

	
}
