/**
 * 
 */
package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.example.utils.HttpClientUtil;

/**
 * @author meikai
 * HttpClient测试
 */
public class HttpClientTest {
	
	/**
	 * json post测试
	 */
	@Test
	public void test() {
		String data = "{'userName':'zhangsan','password':123456}";
		String result =HttpClientUtil.sendJsonPost("http://localhost:7070/postTest", data, 3000, 3000);
		System.out.println(result);
	}
	
	/**
	 * key-value post测试
	 */
	@Test
	public void test2() {
		String data = "userName=zhangsan&password=123456";
		String result =HttpClientUtil.sendKeyValuePost("http://localhost:7070/postTest2", data, 3000, 3000);
		System.out.println(result);
	}
	
	/**
	 * key-value get测试
	 */
	@Test
	public void test3() {
		Map<String,String> data =new HashMap<>();
		data.put("userName", "zhangsan");
		data.put("password", "123456");
		String result =HttpClientUtil.sendGet("http://localhost:7070/postTest2", data, 3000, 3000);
		System.out.println(result);
	}
	
	/**
	 * key-value get测试
	 */
	@Test
	public void test4() {
		Map<String,String> data =new HashMap<>();
		data.put("userName", "zhangsan");
		data.put("password", "123456");
		String result =HttpClientUtil.sendGet("http://localhost:7070/postTest2?userName=chenmeikai&password=1234545",3000, 3000);
		System.out.println(result);
	}
	
	/**
	 * 重定向
	 */
	@Test
	public void test5() {
		Map<String,String> data =new HashMap<>();
		data.put("userName", "zhangsan");
		data.put("password", "123456");
		String result =HttpClientUtil.sendKeyValuePost("http://localhost:7070/redirect", data, 3000, 3000);
		System.out.println(result);
	}

}
