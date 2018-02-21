/**
 * 
 */
package com.example.mapper;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @ClassName:  BaseMapper   
 * @Description:基类 
 * @author: cmk 
 * @date:   2018年2月20日 下午9:40:08   
 * @param <T> 
 * @Copyright: 2018 www.chenmeikai.com
 */
public interface BaseMapper<T>  {
    
	/**
	 * 通过ID查询
	 * @param id
	 * @return
	 */
	T selectById(Serializable id);
	
	/**
	 * 查询单条记录
	 * @param entity
	 * @return
	 */
	T selectOne(Object obj);

	/**
	 * 查询记录集合
	 * @param entity
	 * @return
	 */
	List<?> selectList(Object obj);
	

	/**
	 * 通用的保存方法
	 * @param <T>
	 * @param entity
	 */
	void save(Object obj);
	
	/**
	 * 批量保存
	 * @param list
	 */
	int batchSave(List<?> list);

	/**
	 * 通用的修改方法
	 * @param <T>
	 * @param entity
	 */
	int update(Object obj);
	
	/**
	 * 批量更新
	 * @param list
	 * @return
	 */
	int batchUpdate(List<?> list);

	/**
	 * 删除方法
	 * @param id
	 */
	int delById(Serializable id);
	
	/**
	 * 批量删除
	 * @param list
	 * @return
	 */
	int delList(List<?> list);

	/**
	 * 批量删除方法
	 * @param ids
	 */
	int delArray(int[] ids);

	/**
	 * 统计查询
	 * @param <T>
	 * @param params 查询参数
	 * @return 总记录条数
	 */
	int count(Object obj);

}