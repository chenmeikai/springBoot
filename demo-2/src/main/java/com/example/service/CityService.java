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
	
	String updateName(Integer id,String cityName) throws Exception;
	
	String updateNameLocked(Integer id,String cityName) throws Exception;
	
	String updateDistrict(String cityName,String district) throws Exception;
	
	public String updateDistrictLocked(String cityName, String district) throws Exception;

}
