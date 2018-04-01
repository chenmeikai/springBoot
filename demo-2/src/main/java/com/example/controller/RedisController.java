/**   
 * Copyright © 2018 
 * @Package: RedisController.java 
 * @author: Administrator   
 * @date: 2018年3月31日 上午10:27:07 
 */
package com.example.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.utils.RedisUtils;

/**      
 * @Description:TODO  
 * @author: cmk 
 * @date:   2018年3月31日 上午10:27:07     
 */
@Controller
public class RedisController {
	
	
	@Resource
	private RedisUtils redisUtils;
	
	@RequestMapping("/redis")
	@ResponseBody
	public String redis() {
		
		String animal =redisUtils.get("animal");
		
		System.out.println(animal);
		
		return animal;
	}

}
