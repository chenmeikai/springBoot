/**
 * 
 */
package com.example.activeMq;

/**
 * @author Admin
 *
 */

import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * 报警消息Producer
 * @author ko
 *
 */
@Component
public class Sender{
	
	 // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
   
	 @Autowired
	    private JmsTemplate jmsTemplate;
//	    private JmsMessagingTemplate jmsTemplate;
	    
//	    @Autowired
//	    private Queue queue;
	    
	    public void sendMessage(Destination destination, String message){
	    	//        jmsTemplate.convertAndSend(destinationName, payload, messagePostProcessor);
	        this.jmsTemplate.convertAndSend(destination, message);
	    }
	    
}