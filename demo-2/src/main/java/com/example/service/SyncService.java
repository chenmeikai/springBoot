/**
 * 
 */
package com.example.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;

/**
 * @author meikai
 *
 */
public interface SyncService {
	@Async
	Future<String> one() ;
	@Async
	Future<String> two() ;
	@Async
	Future<String> three();
	@Async
	Future<String> four() ;
	@Async
	Future<String> five() ;
	@Async
	Future<String> six() ;
	@Async
	Future<String> seven();
	@Async
	Future<String> eight() ;
	@Async
	Future<String> nine() ;

}
