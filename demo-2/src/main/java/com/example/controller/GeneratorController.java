/**   
 * Copyright © 2018 www.chenmeikai.com
 * @Package: GeneratorController.java 
 * @author: Administrator   
 * @date: 2018年2月20日 下午9:59:24 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.UserMapper;
import com.example.model.User;

/**   
 * @ClassName:  GeneratorController   
 * @Description:TODO  
 * @author: cmk 
 * @date:   2018年2月20日 下午9:59:24    
 * @Copyright: 2018 www.chenmeikai.com 
 */
@RestController
public class GeneratorController {
	
	@Autowired
	private UserMapper userMapper ;
	
	@RequestMapping("generate")
	public String test() {
		
		Long id =(long) 1;
		User user  = userMapper.selectById(id);
		return user.getUserName();
		
		
	}

}
