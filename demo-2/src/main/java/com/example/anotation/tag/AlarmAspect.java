/**   
 * Copyright © 2018  
 * @Package: com.example.anotation   
 * @date: 2018年4月3日 上午8:56:01 
 */
package com.example.anotation.tag;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.anotation.mapper.AlarmMapper;
import com.example.anotation.model.Alarm;

import java.util.Date;

/**
 * @Description:警告注解
 * @author: cmk
 * @date: 2018年4月3日 上午8:56:01
 */
@Aspect // AOP 切面
@Component
public class AlarmAspect {
	
	
	@Autowired
	private AlarmMapper alarmMapper;
	

	// 声明个切面，切到 com.inesv.service.* 这个目录下，以save开头的方法，方法参数(..)和返回类型(*)不限
	@Pointcut("execution(* com.*.service.*.*.*(..))")
	private void pointcut() {
	}

	/**
	 * 在方法执行前后 环绕式
	 * 
	 * @param point
	 * @param myLog
	 * @return
	 */
	@Around(value = "(execution(* com.*.*..*(..))) && @annotation(alarmLog)")
	public Object around(ProceedingJoinPoint joinPoint, AlarmLog alarmLog) {

		long alarmTime = alarmLog.alarmTime();
		
		boolean isEmail =alarmLog.isEmail();
		
		System.out.println("---进入注解---");

		// 开始时间
		Date startDate = new Date();
		
		// 目标组件的类名
		String className = joinPoint.getTarget().getClass().getName();
		// 调用的方法名
		String method = joinPoint.getSignature().getName();

		try {
			
			// 执行程序
			Object obj = joinPoint.proceed();

			/**
			 * 在调用目标组件业务方法后业务处理
			 */
			
			// 结束时间
			Date endDate = new Date();
			long useTime =endDate.getTime()-startDate.getTime();
			//耗时达到告警时间
			/*if(useTime>=alarmTime*1000) {
				
				
			}*/
			Alarm alarm =new Alarm();
			alarm.setType(1);
			alarm.setGrade(1);
			alarm.setDetail("adfas");
			alarm.setEvent("asdgasg");
			alarm.setUseTime(5);
			alarm.setCreateTime(new Date());
			alarmMapper.save(alarm);
			
			return obj;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
			return throwable.getMessage();
		}
	}

	/**
	 * 方法执行后 并抛出异常
	 *
	 * @param joinPoint
	 * @param myLog
	 * @param ex
	 */
	@AfterThrowing(value = "pointcut() && @annotation(alarmLog)", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, AlarmLog alarmLog, Exception ex) {
		StackTraceElement[] elems = ex.getStackTrace();
		// 将异常信息记录
		System.out.println("-->" + elems[0].toString());
	}

}
