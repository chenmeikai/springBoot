/**
 * 
 */
package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.interceptors.LoggerInterceptor;

/**
 * @author Admin
 *
 */
@RestController
public class LogController {
	
	@RequestMapping("logTest")
	public Map<String,Object> test(HttpServletRequest request,String name,Integer age) {
		
		Map<String,Object> result =new HashMap<>();
		result.put("result", "success");
		result.put("year", 2018);
		//要记录的返回数据
		request.setAttribute(LoggerInterceptor.LOGGER_RETURN_PARAMS, result);
		return result;
		
	}

}
