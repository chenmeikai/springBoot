package com.example.proxy.impl;

import com.example.proxy.TestProxy;

public class BImpl implements TestProxy {

	@Override
	public void test() {
		System.out.println("我是动态代理b实现");

	}

}
