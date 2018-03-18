/**   
 * Copyright © 2018 
 * @Package: ProxyController.java 
 * @author: Administrator   
 * @date: 2018年3月18日 上午11:06:21 
 */
package com.example.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proxy.TestProxy;
import com.example.service.ProxyService;

/**      
 * @Description:TODO  
 * @author: cmk 
 * @date:   2018年3月18日 上午11:06:21     
 */

@RestController
public class ProxyController {
	
	
	@Resource
	ProxyService proxyService;
	
	@RequestMapping("proxyTest")
	public String rollBack() {
		
		try {
			proxyService.test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "asf";
	};

}
