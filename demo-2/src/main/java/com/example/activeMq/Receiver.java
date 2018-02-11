/**
 * 
 */
package com.example.activeMq;

/**
 * @author Admin
 *
 */
import org.apache.commons.lang.StringUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * receiver
 * @author meikai
 *
 */
@Component
public class Receiver {

    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息  
    @JmsListener(destination = "mytest.queue")  
    @SendTo("out.queue") /* 将返回信息发送到该队列*/
    public String receiveQueue(String text) {  
        if(StringUtils.isNotBlank(text)){
            System.out.println("收到的报文为:"+text);  
            return "返回的消息";
        }
		return "返回的消息";
    } 
    
    @JmsListener(destination="out.queue")
    public void consumerMessage(String text){
    	System.out.println("从out.queue队列收到的回复报文为:"+text);
    }
    
}