/**
 * 
 */
package com.example.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author meikai
 * springboot 内置定时器
 */

@Component
public class SpringJob {
	
	 private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    
	   /* @Scheduled(cron="0/5 * * * * *")
	    public void reportCurrentTime() {
	        System.out.println("现在时间：" + dateFormat.format(new Date()));
	    }*/
}

