/**
 * 
 */
package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.model.City;

/**
 * @author meikai
 *
 */
public interface CityMapper {
	
	public City getCityById(@Param("id") Integer id);
	
	public List<City>  getCitys();

}
