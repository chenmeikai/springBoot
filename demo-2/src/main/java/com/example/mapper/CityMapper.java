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
public interface CityMapper extends BaseMapper<City> {
	
	public City getCityById(@Param("id") Integer id);
	
	public City getCityLocked(@Param("id") Integer id);
	
	public City getCityByName(@Param("cityName") String cityName);
	
	public List<City>  getCitys();
	
	public Integer updateName(City city);
	
	public Integer updateDistrict(City city);

}
