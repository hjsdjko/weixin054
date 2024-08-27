package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussliuyanbanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussliuyanbanView;


/**
 * 留言板评论表
 *
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
public interface DiscussliuyanbanService extends IService<DiscussliuyanbanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussliuyanbanView> selectListView(Wrapper<DiscussliuyanbanEntity> wrapper);
   	
   	DiscussliuyanbanView selectView(@Param("ew") Wrapper<DiscussliuyanbanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussliuyanbanEntity> wrapper);
   	

}

