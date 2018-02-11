/**
 * 
 */
package com.example.service.Impl;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.example.service.SyncService;

/**
 * @author meikai
 *
 */
@Service
public class SyncServiceImpl implements SyncService {

  public Future<String> one() {
		System.out.println("如果同步的话我是第1个输出信息的");
		return new AsyncResult<String>("1");
  }
	
  public Future<String> two() {
		System.out.println("如果同步的话我是第2个输出信息的");
		return new AsyncResult<String>("2");
  }
	
  public Future<String> three() {
		System.out.println("如果同步的话我是第3个输出信息的");
		return new AsyncResult<String>("3");
  }
	
  public Future<String> four() {
		System.out.println("如果同步的话我是第4个输出信息的");
		return new AsyncResult<String>("4");
  }
  public Future<String> five() {
	  System.out.println("如果同步的话我是第5个输出信息的");
	  return new AsyncResult<String>("5");
  }
  
  public Future<String> six() {
	  System.out.println("如果同步的话我是第6个输出信息的");
	  return new AsyncResult<String>("6");
  }
  
  public Future<String> seven() {
	  System.out.println("如果同步的话我是第7个输出信息的");
	  return new AsyncResult<String>("7");
  }
  
  public Future<String> eight() {
	  System.out.println("如果同步的话我是第8个输出信息的");
	  return new AsyncResult<String>("8");
  }
  public Future<String> nine() {
	  System.out.println("如果同步的话我是第9个输出信息的");
	  return new AsyncResult<String>("9");
  }

}
