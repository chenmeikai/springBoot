/**
 * 
 */
package com.example.service;

import java.util.List;

import com.example.model.City;

/**
 * @author meikai
 *
 */

public interface CityService {
	
	City getCityById(Integer id);
	
	List<City> getCitys(Integer pageNum,Integer pageSize);

}
