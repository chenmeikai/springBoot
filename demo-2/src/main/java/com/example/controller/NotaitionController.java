/**   
 * Copyright © 2018  
 * @Package: com.example.controller   
 * @date: 2018年4月3日 上午11:09:41 
 */
package com.example.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.service.AnotationService;

/**    
 * @Description:TODO 
 * @author: cmk
 * @date:   2018年4月3日 上午11:09:41      
 */
@Controller
public class NotaitionController {
	
	@Resource
	private AnotationService anotationService;
	
	@RequestMapping("anotation")
	@ResponseBody
	public String test() {
		
		anotationService.test();
		return "hello";
		
	}

}
