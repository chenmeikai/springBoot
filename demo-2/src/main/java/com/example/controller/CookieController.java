/**
 * 
 */
package com.example.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author Administrator
 * 
 */

@Controller
@RequestMapping("cookie")
public class CookieController {
	
	/**
	 * 设置并返回cookie
	 * @param response
	 * @param flag
	 * @param userName
	 * @param password
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	public  void addCookie(HttpServletResponse response,boolean flag,String userName,String password) {
		
		//前台如果同意保留cookie
		if(flag==true) {
			String info =userName+","+password;
			//设置cookie
			Cookie cookie =new Cookie("loginInfo", info);
			//设置过期时间
			cookie.setMaxAge(30*24*60*60); //存活期为一个月 30*24*60*60
			//设置同一应用服务器内共享cookie
			cookie.setPath("/");
			//返回cookie
			response.addCookie(cookie);
		}
		
		
	}

}
