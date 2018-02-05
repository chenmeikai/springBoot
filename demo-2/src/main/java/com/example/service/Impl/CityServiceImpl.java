/**
 * 
 */
package com.example.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mapper.CityMapper;
import com.example.model.City;
import com.example.service.CityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author meikai
 *
 */
@Service
public class CityServiceImpl implements CityService {
	
	private final static Logger log =LoggerFactory.getLogger(CityServiceImpl.class);
	
	@Autowired
	CityMapper cityMapper ;
	
	
	@Override
	public City getCityById(Integer id) {
		City city =cityMapper.getCityById(id);
		log.info("城市名"+city.getName());
		return city;
	}


	@Override
	public List<City> getCitys(Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<City> entitys = cityMapper.getCitys();
	    PageInfo<City> pageInfo = new PageInfo<City>(entitys);
		List<City> citys=pageInfo.getList();
		log.info("容量"+citys.size());
		log.info("信息");
		log.warn("警告");
		log.error("错误");
		return citys;
	}

}
