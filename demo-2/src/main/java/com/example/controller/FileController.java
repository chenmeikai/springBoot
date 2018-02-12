/**
 * 
 */
package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author meikai
 *
 */
@Controller
public class FileController {
	
	private static final Logger log =LoggerFactory.getLogger(FileController.class);
	
	
	
	@RequestMapping(value="file",method=RequestMethod.GET)
	public String file(String name,MultipartFile file) {
		
		log.info("名字是："+name);
		return "demo/uploadFile";
		
	}
	
	@RequestMapping(value="upload",method=RequestMethod.POST)
	@ResponseBody
	public String upload(HttpServletRequest request, String name,MultipartFile file) {
		
		log.info("名字是："+name);
		return name;
		
	}

}
