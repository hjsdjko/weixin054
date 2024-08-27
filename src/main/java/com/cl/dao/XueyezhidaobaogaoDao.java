package com.cl.dao;

import com.cl.entity.XueyezhidaobaogaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueyezhidaobaogaoView;


/**
 * 学业指导报告
 * 
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
public interface XueyezhidaobaogaoDao extends BaseMapper<XueyezhidaobaogaoEntity> {
	
	List<XueyezhidaobaogaoView> selectListView(@Param("ew") Wrapper<XueyezhidaobaogaoEntity> wrapper);

	List<XueyezhidaobaogaoView> selectListView(Pagination page,@Param("ew") Wrapper<XueyezhidaobaogaoEntity> wrapper);
	
	XueyezhidaobaogaoView selectView(@Param("ew") Wrapper<XueyezhidaobaogaoEntity> wrapper);
	

}
