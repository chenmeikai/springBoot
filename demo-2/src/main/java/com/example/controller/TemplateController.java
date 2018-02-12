/**
 * 
 */
package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author meikai
 * 模板
 */

@Controller
public class TemplateController {
	
	@RequestMapping("/helloHtml")  
    public String helloHtml(Map<String,Object> map){  
  
       map.put("hello","from TemplateController.helloHtml");  
       return"demo/helloWorld";  
    }  

}
