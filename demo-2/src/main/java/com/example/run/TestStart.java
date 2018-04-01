/**   
 * Copyright © 2018 
 * @Package: TestStart.java 
 * @author: Administrator   
 * @date: 2018年4月1日 下午9:22:37 
 */
package com.example.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.mapper.UserMapper;
import com.example.model.User;

/**      
 * @Description:项目启动时运行  
 * @author: cmk 
 * @date:   2018年4月1日 下午9:22:37     
 */

@Component  
@Order(value=1)//执行顺序，value值越小优先级越高
public class TestStart  implements CommandLineRunner{
    
	private static Logger logger =LoggerFactory.getLogger(TestStart.class);
	
	@Autowired
	private UserMapper userMapper;
	
	//项目启动时，运行该代码
	@Override
	public void run(String... arg0) throws Exception {
		
		logger.info("跟随项目启动时运行....");
		User user =userMapper.selectById(1);
		System.out.println("用户名是："+user.getUserName());
		
		
	}

}
