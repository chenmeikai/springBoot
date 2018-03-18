/**
 * 
 */
package com.example.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CityService;
import com.example.service.SyncService;

/**
 * @author meikai
 *
 */
@RestController
public class AsyncController {
	
	@Resource
	private SyncService syncService;
	
	@Resource
	private CityService cityService;
	
	@RequestMapping("Async")
	public String test() throws InterruptedException, ExecutionException {
	Future<String>  one=syncService.one();
	Future<String> two=	syncService.two();
	Future<String> threee=syncService.three();
	Future<String> four=syncService.four();
	Future<String>  five=syncService.five();
	Future<String> six=	syncService.six();
	Future<String> seven=syncService.seven();
	Future<String> eight=syncService.eight();
	Future<String> nine=syncService.nine();
	String result =one.get()+two.get()+threee.get()+four.get()+five.get()+six.get()+seven.get()+eight.get()+nine.get();
	return result;
	}
	
	
	
	@RequestMapping("Async2")
	public String Async2() throws InterruptedException, ExecutionException {
		cityService.test();
		return "success";
	}
	
	
	@RequestMapping("Async3")
	public String ThreadController() {
		
		syncService.test3();
		
		return "threadUtils";
		
	}
	
	
	

}
