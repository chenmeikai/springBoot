/**
 * 
 */
package com.example.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.SyncService;

/**
 * @author meikai
 *
 */
@RestController
public class AsyncController {
	
	@Resource
	private SyncService syncService;
	
	@RequestMapping("Async")
	public String test() {
	String one=	syncService.one();
	String two=	syncService.two();
	String threee=	syncService.three();
	String four=syncService.four();
	String result =one+two+threee+four;
	System.out.println("asdfasdf");
	return result;
	}
	

}
