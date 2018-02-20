package com.example.interceptors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.mapper.LogMapper;
import com.example.model.Log;
import com.example.utils.HttpClientUtil;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *meikai
 */
public class LoggerInterceptor implements HandlerInterceptor
{
    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";
    //返回参数标识
    public  static final String LOGGER_RETURN_PARAMS ="_log_return_params";
    
    @Autowired
    private LogMapper logMapper;

    /**
     * 进入SpringMVC的Controller之前开始记录日志实体
     * @param request 请求对象
     * @param response 响应对象
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //创建日志实体
        Log logger = new Log();
        //获取请求sessionId
        String sessionId = request.getRequestedSessionId();
        //请求路径
        String url = request.getRequestURI();
        //获取请求参数信息
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        logger.setClientIp(HttpClientUtil.getCliectIp(request));
        //设置请求方法
        logger.setMethod(request.getMethod());
        //设置请求类型（json|普通请求）
        String type =HttpClientUtil.getRequestType(request);
        logger.setType(type);
        //设置请求参数内容json字符串
        logger.setParamData(paramData);
        //设置请求地址
        logger.setUri(url);
        //设置sessionId
        logger.setSessionId(sessionId);
        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME,new Date());
        //设置请求实体到request内，方面afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY,logger);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        //获取请求错误码
        int status = response.getStatus();
        //当前时间
        Date endTime =new Date();
        long currentTime = endTime.getTime();
        //请求开始时间
        Date startTime =(Date) request.getAttribute(LOGGER_SEND_TIME);
        long time =startTime.getTime();
        //获取本次请求日志实体
        Log log = (Log) request.getAttribute(LOGGER_ENTITY);
        //设置请求开始时间
        log.setReqeustTime(startTime);
        //设置请求时间差
        log.setTimeConsuming(Integer.valueOf((currentTime - time)+""));
        //设置返回时间
        log.setReturnTime(endTime);
        //设置返回错误码
        log.setStatuCode(status+"");
        //设置返回参数
        log.setReturnData(JSON.toJSONString(request.getAttribute(LOGGER_RETURN_PARAMS),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //解决无法注入问题
        if (logMapper == null) { 
            BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
            logMapper = (LogMapper) factory.getBean("logMapper"); 
         } 
        //执行将日志写入数据库
        logMapper.save(log);
       
    }
}
