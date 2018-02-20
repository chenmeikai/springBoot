/**
 * 
 */
package com.example.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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


	@Override
    @Transactional(rollbackFor = {Exception.class,RuntimeException.class},isolation =Isolation.REPEATABLE_READ)
	public  String updateName(Integer id,String cityName) throws Exception {
		
		log.info("开始查询");
		City city =cityMapper.getCityById(id);
		log.info("获得结果");
		city.setName(cityName);
		
		Integer resultCode = cityMapper.updateName(city);
		
		if(resultCode==1) {
			return "sucess";
		}
		return "faile";
		
	}

    
	/**
	 * 锁
	 */
	@Override
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class},isolation =Isolation.REPEATABLE_READ)
	public String updateNameLocked(Integer id, String cityName) throws Exception {
        City city =cityMapper.getCityLocked(id);
		
		city.setName(cityName);
		
		Integer resultCode = cityMapper.updateName(city);
		
		//休眠
		Thread.sleep(20000);
		
		if(resultCode==1) {
			return "sucess";
		}
		return "faile";
	}
     
	
	
	@Override
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public String updateDistrictLocked(String cityName, String district) throws InterruptedException {
		
		City city =cityMapper.getCityByName(cityName);
		city.setDistrict(district);
		Integer resultCode = cityMapper.updateDistrict(city);
		
		//休眠
		Thread.sleep(20000);
		
		if(resultCode==1) {
			return "sucess";
		}
		return "faile";
		
	}

	@Override
	@Transactional(rollbackFor = {Exception.class,RuntimeException.class})
	public String updateDistrict(String cityName, String district) {
		
		City city =cityMapper.getCityByName(cityName);
		System.out.println("查询出数据");
		city.setDistrict(district);
		Integer resultCode = cityMapper.updateDistrict(city);
		if(resultCode==1) {
			return "sucess";
		}
		return "faile";
	}

}
