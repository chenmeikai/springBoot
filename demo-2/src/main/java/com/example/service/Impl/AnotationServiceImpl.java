/**   
 * Copyright © 2018  
 * @Package: com.example.service.Impl   
 * @date: 2018年4月3日 上午11:12:17 
 */
package com.example.service.Impl;

import org.springframework.stereotype.Service;
import com.example.service.AnotationService;
import com.inesv.alarm.anotation.AlarmLog;

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
		String text =null;
		text.equals("");
		return null;
	}

}
