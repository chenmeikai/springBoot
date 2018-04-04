/**   
 * Copyright © 2018  
 * @Package: com.example.service.Impl   
 * @date: 2018年4月3日 上午11:12:17 
 */
package com.example.service.Impl;

import org.springframework.stereotype.Service;

import com.example.anotation.tag.AlarmLog;
import com.example.service.AnotationService;

/**    
 * @Description:TODO 
 * @author: cmk
 * @date:   2018年4月3日 上午11:12:17      
 */
@Service
public class AnotationServiceImpl implements AnotationService {

	@Override
	@AlarmLog(alarmTime=3,isEmail=true)
	public String test() {
		return null;

	}

}
