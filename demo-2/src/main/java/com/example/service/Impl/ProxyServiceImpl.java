/**   
 * Copyright © 2018 
 * @Package: ProxyServiceImpl.java 
 * @author: Administrator   
 * @date: 2018年3月18日 上午11:16:56 
 */
package com.example.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.proxy.ProxyFactory;
import com.example.proxy.TestProxy;
import com.example.service.ProxyService;

/**      
 * @Description:TODO  
 * @author: cmk 
 * @date:   2018年3月18日 上午11:16:56     
 */
@Service("proxyServiceImpl")
public class ProxyServiceImpl implements ProxyService {
	

	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public void test() throws Exception {
		
		TestProxy testProxy =ProxyFactory.getInstance("B");
		testProxy.updateUser();

	}

}
