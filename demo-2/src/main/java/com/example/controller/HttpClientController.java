/**
 * 
 */
package com.example.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.example.utils.HttpClientUtil;
import com.example.utils.RequestUtils;
import com.google.gson.JsonObject;

/**
 * @author meikai
 *
 */
@Controller
public class HttpClientController {
	
	private static final Logger log =LoggerFactory.getLogger(HttpClientUtil.class);
	
	/**
	 * json测试
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="postTest",method=RequestMethod.POST)
	@ResponseBody
	public String test(HttpServletRequest request) throws IOException {
		//将请求参数转化为字符串
		String data =RequestUtils.toString(request);
		log.info("测试HttpClient post请求"
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		log.info("post请求参数:" + data);
		if(StringUtils.isBlank(data)) {
			log.info("数据为空");
			return "data is null";
		}
		JSONObject jsonObject = JSONObject.parseObject(data);
		String name =jsonObject.getString("userName");
		return data;
	}
	
	
	/**
	 * key-value测试
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="postTest2",method=RequestMethod.GET)
	@ResponseBody
	public Map test2(HttpServletRequest request,@RequestParam("userName")String userName,String password) throws IOException {
		
		Map<String,Object> data =RequestUtils.toMap(request);
		log.info("测试HttpClient post请求"
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		log.info("post请求参数:" + data);
		if(data ==null) {
			log.info("数据为空");
			return   (Map) new HashMap<String,Object>().put("data", "is null");
		}
		log.info(userName+"-"+password);
		return data;
	}
	
	
	@RequestMapping(value="redirect",method=RequestMethod.POST)
	@ResponseBody
	public void redirect(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.sendRedirect("/redirect2");
	}
	
	
	@RequestMapping(value="redirect2",method=RequestMethod.GET)
	@ResponseBody
	public String redirect2(HttpServletRequest request,String userName,String password) throws IOException {
		return "success";
	}
	

}
