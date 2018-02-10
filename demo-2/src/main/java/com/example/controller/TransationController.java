/**
 * 
 */
package com.example.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CityService;

/**
 * @author meikai
 * 事物test
 */
@RestController
public class TransationController {
	
	@Resource
	private CityService cityService;
	
	//根据id查询城市，修改城市名，休眠
	@RequestMapping("/processLock")
	public String processLock(Integer id,String cityName) throws Exception {
		
		String result =cityService.updateNameLocked(id, cityName);
		
		return result;
	}
	
	//根据id查询城市，修改城市名，在/processLock请求时发起请求，观察是否等待cityService.updateNameLocked(id, cityName)完成时才执行
	@RequestMapping("/process")
	public String process(Integer id,String cityName) throws Exception {
		
		String result =cityService.updateName(id, cityName);
		
		return result;
	}
	
	//根据城市名查询城市，修改district，休眠
	@RequestMapping("/processLock2")
	public String processLock2(String cityName,String district) throws Exception {
		
		String result =cityService.updateDistrictLocked(cityName,district);
		
		return result;
	}
	
	//根据城市名查询城市，修改district，在/processLock2请求时发起请求，观察是否等待/processLock2完成时才执行
	@RequestMapping("/process2")
	public String process2(String cityName,String district) throws Exception {
		
		String result =cityService.updateDistrict(cityName,district);
		
		return result;
	}
	
	
	

}
