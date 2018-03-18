package com.example.proxy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.proxy.TestProxy;

@Service("B")
public class BImpl implements TestProxy {
	
	@Autowired
	UserMapper userMapper ;

	@Override
	public void test() {
		System.out.println("我是动态代理b实现");

	}
	
	@Override
	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public void updateUser() throws Exception {
		User user =new User();
		user.setId((long)1);
		user.setUserName("动态代理回滚");
		int result =  userMapper.update(user);
		System.out.println("修改结果--"+result);
		throw new Exception("抛出");
	}

}
