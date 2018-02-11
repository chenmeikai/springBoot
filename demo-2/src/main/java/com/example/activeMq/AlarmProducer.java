/**
 * 
 */
package com.example.activeMq;

/**
 * @author Admin
 *
 */

import java.util.Map;

import javax.jms.Destination;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 报警消息Producer
 * @author ko
 *
 */
@Component
//@EnableScheduling
public class AlarmProducer{
	
	 // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
   
	 @Autowired
	    private JmsTemplate jmsTemplate;
//	    private JmsMessagingTemplate jmsTemplate;
	    
//	    @Autowired
//	    private Queue queue;
	    
//	    @Scheduled(fixedDelay=5000) // 5s执行一次   只有无参的方法才能用该注解
	    public void sendMessage(Destination destination, String message){
	    	//        jmsTemplate.convertAndSend(destinationName, payload, messagePostProcessor);
	        this.jmsTemplate.convertAndSend(destination, message);
	    }
	    
	    
//	    //双向队列
//	    @JmsListener(destination="out.queue")
//	    public void consumerMessage(String text){
//	    	System.out.println("从out.queue队列收到的回复报文为:"+text);
//	    }
	    
   
}