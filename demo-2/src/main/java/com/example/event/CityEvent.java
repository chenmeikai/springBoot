package com.example.event;

import org.springframework.context.ApplicationEvent;

import com.example.model.City;


public class CityEvent extends ApplicationEvent{
	
   
	private static final long serialVersionUID = 1L;
	
	
	//注册城市对象
    private City city;

    
    /**
     * 重写构造函数
     * @param source 发生事件的对象
     * @param user 注册用户对象
     */
    public CityEvent(Object source,City city) {
        super(source);
        this.city = city;
    }


	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
    
    
}
