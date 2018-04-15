/**
 * 
 */
package com.example.service.Impl;

import org.springframework.stereotype.Service;

import com.example.service.AnotationService;
import com.inesv.alarm.anotation.AlarmLog;

/**
 * @author meikai
 *
 */
@Service
public class AnotationServiceImpl implements AnotationService {

	
	@Override
	@AlarmLog(alarmTime=3,isEmail=true)
	public void test() {
		String wrong=null;
		wrong.equals("asdf");
		System.out.println("hello world");
	}
	
	

}
