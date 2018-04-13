/**
 * 
 */
package com.example.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.AnotationService;

/**
 * @author admin
 *
 */
@Controller
public class AnotationController {
	
	@Resource
	private AnotationService anotationService;
    
    @RequestMapping(value="/anotation",method=RequestMethod.GET)
    @ResponseBody
    public String chufabaojing(String devicename){
        
    	anotationService.test();
        
        return "success";
    }

}
