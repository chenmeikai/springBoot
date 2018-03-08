/**   
 * Copyright © 2018 
 * @Package: PageHelper.java 
 * @author: Administrator   
 * @date: 2018年3月6日 下午10:52:04 
 */
package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.User;

/**      
 * @Description:TODO  
 * @author: cmk 
 * @date:   2018年3月6日 下午10:52:04     
 */


@Controller
public class PageHelperController {
	
	@RequestMapping("show")
	public String show() {
		return"demo/BootStrapTable"; 
	}
	
	
	@RequestMapping("getShow")
	@ResponseBody
	public Map<String,Object> getShow(String userName,Integer pageNumber,Integer pageSize) {
		
		Map<String,Object> map=new HashMap<>();
		
		List<User> users =new ArrayList<>();
		for(int i=0;i<10;i++) {
			User user =new User();
			user.setId((long)i);
			user.setUserName("美凯"+i);
			user.setPassword("123456");
			users.add(user);
		}
		map.put("rows", users);
		Integer count =30;
		map.put("total", count);
		
		return map; 
	}

}
