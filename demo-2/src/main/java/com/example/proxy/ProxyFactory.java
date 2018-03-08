package com.example.proxy;

import java.util.HashMap;
import java.util.Map;
/**
 * @Description:TODO 
 * @author: cmk
 * @date:   2018年3月6日 下午5:18:34
 */
public class ProxyFactory {
	private static Map<String, TestProxy> apiClass = new HashMap<String, TestProxy>();
	
	public static TestProxy getInstance(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// 类名
		String name = "com.example.proxy.impl." + className + "Impl";
		TestProxy testProxy = apiClass.get(name);
		/**
		 * 判断该类是否已实例化，是则返回实例化的对象，否则实例化该对象
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
			ClassLoader classLoader = ProxyFactory.class.getClassLoader();
			Class<?> impl = classLoader.loadClass(name);
			TestProxy proxy = (TestProxy) impl.newInstance();
			apiClass.put(name, proxy);
			return proxy;
		}
	}
}
