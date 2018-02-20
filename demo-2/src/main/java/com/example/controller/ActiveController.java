/**
 * 
 */
package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activeMq.Sender;

/**
 * @author Admin
 *
 */
@Controller
public class ActiveController {
	
	@Autowired
    private Sender alarmProducer;
    
    @RequestMapping(value="/active",method=RequestMethod.GET)
    @ResponseBody
    public String chufabaojing(String devicename){
        
        List<String> alarmStrList = new ArrayList<>();
        alarmStrList.add(devicename+"out fence01");
        alarmStrList.add(devicename+"out fence02");
        alarmStrList.add(devicename+"in fence01");
        alarmStrList.add(devicename+"in fence02");
        
        // 写入消息队列
        Destination destination = new ActiveMQQueue("mytest.queue");
        for (String alarmStr : alarmStrList) {
            alarmProducer.sendMessage(destination, alarmStr);
        }
        
        
        return "success";
    }

}
