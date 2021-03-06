package com.spring.tourist.search.keyword.controller;

import java.util.Map;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.tourist.search.keyword.service.KeywordService;

@Controller
@RequestMapping("/keyword/*")
public class KeywordController {
	
	@Autowired
	private KeywordService keywordService;
	
	@RequestMapping(value="/area/{areaPage}")
	@ResponseBody
	public JSONArray getArea(@PathVariable("areaPage")int preaPage) throws Exception {
		
		return keywordService.getArea(preaPage);
	}
	
	@RequestMapping(value="/area/{code}/{areaPage}")
	@ResponseBody
	public JSONArray getAreaGu(@PathVariable("code")int code,@PathVariable("areaPage")int areaPage) throws Exception{
		return keywordService.getAreaGu(code, areaPage);
	}
	
	@RequestMapping("/typeSelect")
	@ResponseBody
	public JSONArray getTypeSelect() throws Exception{
		return keywordService.getType();
	}
	
	@RequestMapping("/search")
	public String searchList(@RequestParam(value="areaSelect",required=false,defaultValue="sel")String areaCode,
			@RequestParam(value="districtSelect",required=false,defaultValue="sel")String sigunguCode,
			@RequestParam(value="typeSelect",required=false,defaultValue="sel")String cart1,
			Model model,@RequestParam(value="pageNo",required=false,defaultValue="1")int pageNo
			) throws Exception{
		Map<String, Object> map=keywordService.searchList(areaCode,sigunguCode,cart1,pageNo);
		map.put("areaSelect",areaCode);
		map.put("districtSelect", sigunguCode);
		map.put("typeSelect",cart1);
		model.addAttribute("map",map);
		return "search/list";
		
	}
	
	@RequestMapping("/getDetail")
	public String getDetail (@RequestParam(value="contentId")int contentId,Model model) throws Exception{
	model.addAttribute("detailObj",keywordService.getDatail(contentId));
	return "search/detail";
	}
}

