package com.example.proxy;

import java.util.HashMap;
import java.util.Map;

import com.example.config.SpringUtil;
/**
 * @Description:TODO 
 * @author: cmk
 * @date:   2018年3月6日 下午5:18:34
 */
public class ProxyFactory {
	
	private static Map<String, TestProxy> apiClass = new HashMap<String, TestProxy>();
	
	public static TestProxy getInstance(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		//bean名
		String name = className.toUpperCase().intern();
		TestProxy testProxy = apiClass.get(name);
		/**
		 * 判断该实现类是否已经从上下文获得过了
		 */
		if (testProxy != null) {
			return testProxy;
		}
		//根据类名，加锁
		synchronized (name) {
			testProxy = apiClass.get(name);
			if (testProxy != null) {
				return testProxy;
			}
			TestProxy proxy = (TestProxy) SpringUtil.getBean(name);
			apiClass.put(name, proxy);
			return proxy;
		}
	}
}
