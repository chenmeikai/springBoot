/**   
 * Copyright © 2018 www.chenmeikai.com
 * @Package: DemoTest.java 
 * @author: Administrator   
 * @date: 2018年2月20日 上午11:15:30 
 */
package com.example.demo;

import static org.junit.Assert.*;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.example.model.City;
import com.example.run.runApplication;
import com.example.service.CityService;

/**   
 * @ClassName:  DemoTest   
 * @Description:TODO  
 * @author: cmk 
 * @date:   2018年2月20日 上午11:15:30    
 * @Copyright: 2018 www.chenmeikai.com 
 */

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=runApplication.class)// 指定spring-boot的启动类   
//@SpringApplicationConfiguration(classes = Application.class)// 1.4.0 前版本  
public class DemoTest {
	
	@Resource
	private CityService cityService;
	
	@Test
	public void test() {
		Integer id = 1;
		City city =cityService.getCityById(id);
		String name= city.getName();
		System.out.println("城市名是："+name);
		assertEquals(name, "广州d");//断言
	}
	
	
	@Test
	@Transactional //添加事务，自动回滚
	//@Rollback(false)，不想事务自动回滚，则添加此注解，默认为true
	public void test2() throws Exception {
		Integer id = 1;
		City city =cityService.getCityById(id);
		city.setName("hello");
		cityService.updateName(id, city.getName());
	}

}
