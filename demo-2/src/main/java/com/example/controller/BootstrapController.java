/**
 * 
 */
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author meikai
 *
 */
@Controller
public class BootstrapController {
	
	@RequestMapping("bootstrap1")
	public String test() {
		
		return "/demo/BootStrap";
	}

}
