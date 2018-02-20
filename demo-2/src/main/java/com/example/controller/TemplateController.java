/**
 * 
 */
package com.example.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.City;
import com.example.service.CityService;

/**
 * @author meikai
 * 模板
 */

@Controller
public class TemplateController {
	
	@Resource
	private CityService cityService;
	
	@RequestMapping("/helloHtml")  
    public String helloHtml(Map<String,Object> map){  
  
       map.put("hello","from TemplateController.helloHtml");  
       return"demo/helloWorld";  
    }  
	
	
	@RequestMapping("/list")  
    public String list(Map<String,Object> map){  
		
	   List<City> citys =cityService.getCitys(1, 2)	;
  
       map.put("citys",citys);  
       return"demo/helloWorld2";  
    }  

}
