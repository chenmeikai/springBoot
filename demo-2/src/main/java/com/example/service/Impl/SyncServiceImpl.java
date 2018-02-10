/**
 * 
 */
package com.example.service.Impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.service.SyncService;

/**
 * @author meikai
 *
 */
@Service
public class SyncServiceImpl implements SyncService {

  public	String one() {
		System.out.println("如果同步的话我是第1个输出信息的");
		return "1";
	}
	
  public String two() {
		System.out.println("如果同步的话我是第2个输出信息的");
		return "2";
	}
	
  public String three() {
		System.out.println("如果同步的话我是第3个输出信息的");
		return "3";
	}
	
  public	String four() {
		System.out.println("如果同步的话我是第4个输出信息的");
		return "4";
	}

}
