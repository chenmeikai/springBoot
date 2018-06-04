/**   
 * Copyright © 2018 
 * @Package: QuartzConfig.java 
 * @author: Administrator   
 * @date: 2018年6月1日 上午10:52:57 
 */
package com.example.model;

/**      
 * @Description:定时器配置  
 * @author: cmk 
 * @date:   2018年6月1日 上午10:52:57     
 */
public class QuartzConfig {
	
	private Long id;
	
	private String cron;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}
	
	

}
