/**   
 * Copyright © 2018  
 * @Package: com.example.demo   
 * @date: 2018年3月6日 下午4:11:55 
 */
package com.example.demo;

import com.example.proxy.ProxyFactory;
import com.example.proxy.TestProxy;

/**    
 * @Description:TODO 
 * @author: cmk
 * @date:   2018年3月6日 下午4:11:55      
 */
public class ProxyTest {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws Exception {
		
		TestProxy proxy =ProxyFactory.getInstance("B");
		proxy.test();

	}

}
