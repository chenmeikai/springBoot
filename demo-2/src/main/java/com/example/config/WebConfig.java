/**
 * 
 */
package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.interceptors.DataInterceptor;
import com.example.interceptors.LoggerInterceptor;

/**
 * @author meikai
 *
 */
@Configuration
public class WebConfig 
        extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new DataInterceptor()).addPathPatterns("/**");
        
        //log日志记录
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
    
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        
    	registry.addMapping("/**") //配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径
        .allowedMethods("*")       //允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等
        .allowedOrigins("*")       //允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源
        .allowedHeaders("*");      //允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
    }
    

}