/**
 * 
 */
package com.example.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.City;
import com.example.service.CityService;
import com.example.utils.RedisUtils;

/**
 * @author meikai
 *
 */
@RestController
public class HelloWorldController {
	
	@Resource
	private CityService cityService;
	
	@Resource
	private RedisUtils redisUtils;
	
	@RequestMapping("/hello")
	public City helloWorld() {
		
		
	City city = cityService.getCityById(1);
		
		return city;
	}
	
	@RequestMapping("/hello2")
	public String helloWorld2() {
		
	List<City> citys= cityService.getCitys(1, 3);
		
		return "hello world";
	}
	
	
	@RequestMapping("/redis")
	public String redis() {
		
		String animal =redisUtils.get("animal");
		
		System.out.println(animal);
		
		return "hello world";
	}
	
}
