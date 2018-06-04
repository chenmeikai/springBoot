package com.example.controller.webSocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.config.websocket.WebSocketServer;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {
	

    //页面请求
    @GetMapping("/socket/{cid}")
    public String socket(@PathVariable String cid,HttpServletRequest request) {
        request.setAttribute("cid", cid);
        return "/websocket/socket";
    }
    
    
    
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public Map<String,Object> pushToWeb(@PathVariable String cid,String message) {  
    	
    	Map<String,Object> result =new HashMap<>();
    	
        try {
            WebSocketServer.sendInfo(message,cid);
            result.put("code", 200);
            result.put("desc", "成功");
        } catch (IOException e) {
            e.printStackTrace();
            result.put("code", 100);
            result.put("desc", "失败");
        }  
        return result;
    } 
} 