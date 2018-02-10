/**
 * 
 */
package com.example.service;

import org.springframework.scheduling.annotation.Async;

/**
 * @author meikai
 *
 */
public interface SyncService {
	@Async
	String one() ;
	@Async
	String two() ;
	@Async
	String three();
	@Async
	String four() ;

}
