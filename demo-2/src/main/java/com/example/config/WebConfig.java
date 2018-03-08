/**
 * 
 */
package com.example.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.interceptors.DataInterceptor;
import com.example.interceptors.LoggerInterceptor;

/**
 * @author meikai
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	// 默认首页
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/html/index.html");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}
	
	
    //错误页面	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	   return new EmbeddedServletContainerCustomizer() {
	      @Override
	      public void customize(ConfigurableEmbeddedServletContainer container) {
	         ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/html/error/401.html");
	         ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN,"/html/error/403.html");
	         ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/html/error/404.html");
	         ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/html/500.html");
	         container.addErrorPages(error401Page,error403Page, error404Page, error500Page);
	      }
	   };
	}
	

	// 拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new DataInterceptor()).addPathPatterns("/**");

		// log日志记录
		registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	// 跨域
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**") // 配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径
				.allowedMethods("*") // 允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等
				.allowedOrigins("*") // 允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源
				.allowedHeaders("*"); // 允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
	}

	// 虚拟路径映射
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 将所有/static/** 访问都映射到classpath:/static/ 目录下
		// registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		// 将所有file/** 访问都映射到file:F:/pictures/ 目录下
		registry.addResourceHandler("/file/**").addResourceLocations("file:F:/pictures/");
	}

}