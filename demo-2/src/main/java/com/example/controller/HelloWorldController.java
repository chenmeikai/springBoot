/**
 * 
 */
package com.example.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.City;
import com.example.service.CityService;

/**
 * @author meikai
 *
 */
@RestController
public class HelloWorldController {
	
	@Resource
	private CityService cityService;
	
	
	@RequestMapping("/hello")
	public String helloWorld() {
		
		
	 cityService.getCityById(1);
		
		return "hello world";
	}
	
	@RequestMapping("/hello2")
	public String helloWorld2() {
		
	List<City> citys= cityService.getCitys(1, 3);
		
		return "hello world";
	}


}