/**   
 * Copyright © 2018 
 * @Package: BackGroundController.java 
 * @author: Administrator   
 * @date: 2018年3月19日 下午8:30:38 
 */
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**      
 * @Description:  后台 管理
 * @author: cmk 
 * @date:   2018年3月19日 下午8:30:38     
 */

@Controller
public class BackGroundController {
	
	
	@RequestMapping("back")
	public String index() {
		return "/back/index";
	}
	
	
	@RequestMapping("show")
	public String show() {
		return "/demo/BootStrapTable2";
	}

}
