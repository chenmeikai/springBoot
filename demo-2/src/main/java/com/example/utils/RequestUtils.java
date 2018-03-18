/**
 * 
 */
package com.example.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author meikai
 * 
 */
public class RequestUtils {
	
	private static final Logger log =LoggerFactory.getLogger(RequestUtils.class);
	
	/**
	 * 将键值对格式的请求参数封装为map集合
	 * @param request
	 * @return
	 */
	public static Map<String, Object> toMap(HttpServletRequest request) {
		
		if(request ==null) {
			log.error("fail to convert to Map ,HttpServletRequest is null !");
			return null;
		}
		Enumeration<String> paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		while ((paramNames != null) && (paramNames.hasMoreElements())) {
			String paramName = (String) paramNames.nextElement();
			String[] values = request.getParameterValues(paramName);
			if ((values != null) && (values.length != 0)) {
				if (values.length > 1)
					params.put(paramName, values);
				else {
					params.put(paramName, (values[0] == null) ? null : values[0].trim());
				}
			}
		}
		return params;
	}
	
	  
    /** 
     * 将request流中的数据转换成String,会截流 
     * @param request 
     * @return 
     */  
	public static String readJson(HttpServletRequest request){  
        BufferedReader reader = null;  
        StringBuilder sb = new StringBuilder();  
        try{  
            reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));  
            String line = null;  
            while ((line = reader.readLine()) != null){  
                sb.append(line);  
            }  
        } catch (IOException e){  
            e.printStackTrace();  
        } finally {  
            try{  
                if (null != reader){ reader.close();}  
            } catch (IOException e){  
                e.printStackTrace();  
            }  
        }  
        return sb.toString();  
    }  


}
