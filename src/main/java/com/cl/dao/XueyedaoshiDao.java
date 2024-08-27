package com.cl.dao;

import com.cl.entity.XueyedaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueyedaoshiView;


/**
 * 学业导师
 * 
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
public interface XueyedaoshiDao extends BaseMapper<XueyedaoshiEntity> {
	
	List<XueyedaoshiView> selectListView(@Param("ew") Wrapper<XueyedaoshiEntity> wrapper);

	List<XueyedaoshiView> selectListView(Pagination page,@Param("ew") Wrapper<XueyedaoshiEntity> wrapper);
	
	XueyedaoshiView selectView(@Param("ew") Wrapper<XueyedaoshiEntity> wrapper);
	

}
