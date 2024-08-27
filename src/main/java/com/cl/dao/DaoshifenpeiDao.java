package com.cl.dao;

import com.cl.entity.DaoshifenpeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoshifenpeiView;


/**
 * 导师分配
 * 
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
public interface DaoshifenpeiDao extends BaseMapper<DaoshifenpeiEntity> {
	
	List<DaoshifenpeiView> selectListView(@Param("ew") Wrapper<DaoshifenpeiEntity> wrapper);

	List<DaoshifenpeiView> selectListView(Pagination page,@Param("ew") Wrapper<DaoshifenpeiEntity> wrapper);
	
	DaoshifenpeiView selectView(@Param("ew") Wrapper<DaoshifenpeiEntity> wrapper);
	

}
