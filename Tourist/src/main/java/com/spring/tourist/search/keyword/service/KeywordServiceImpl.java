package com.spring.tourist.search.keyword.service;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.spring.tourist.util.dvo.Critia;
import com.spring.tourist.util.dvo.PageMaker;


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
	public Map<String,Object> searchList(String areaCode, String sigunguCode, String cart1,int pageNo) throws Exception {
		Map<String, Object> map=new HashMap<>();
		
		BufferedInputStream reader = null;
	 String str="http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?";
		str+="ServiceKey=IXBlJg7qk96wYkcCFZRMtNVWvUKb11PwWfZIKMJXtoOB5a0VWe9%2BziRYfhlJzuR6Myr1x6KBbFYF8CuRkUJSWQ%3D%3D";
		str+="&MobileOS=ETC&MobileApp=AppTesting&_type=json";
		if(!areaCode.equals("sel")) str+="&areaCode="+areaCode;
		if(!sigunguCode.equals("sel")) str+="&sigunguCode="+sigunguCode;
		if(!cart1.equals("sel")) str+="&cart1="+cart1;
		if(pageNo>1) {
			str+="&pageNo="+pageNo;
		}else pageNo=1;
		try {
			URL url = new URL(str);
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
			//totalcount 현재페이지 가져오기
			map.put("body",json1);
			String count=json1.get("totalCount").toString();
			String numPage=json1.get("numOfRows").toString();
			Critia critia=new Critia(pageNo, Integer.parseInt(numPage));
			PageMaker pageMaker=new PageMaker(critia, Integer.parseInt(count));
			map.put("pageMaker", pageMaker);
			
			JSONObject json2 = (JSONObject) json1.get("items");
			JSONArray array = (JSONArray) json2.get("item");
			map.put("list",array);
			return map;

		} finally {
			if (reader != null)
				reader.close();
		}
	}

	@Override
	public JSONObject getDatail(int contentId) throws Exception {
		BufferedInputStream reader = null;
		try {
			URL url = new URL(
					"http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?"
		+ "ServiceKey=IXBlJg7qk96wYkcCFZRMtNVWvUKb11PwWfZIKMJXtoOB5a0VWe9%2BziRYfhlJzuR6Myr1x6KBbFYF8CuRkUJSWQ%3D%3D"
				+ "&MobileOS=ETC&MobileApp=AppTesting&contentId="+contentId+"&firstImageYN=Y&addrinfoYN=Y&defaultYN=Y"+
		"&mapinfoYN=Y"
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
			JSONObject array = (JSONObject) json2.get("item");

			return array;

		} finally {
			if (reader != null)
				reader.close();
		}
	
}
}
