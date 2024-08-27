package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueyezhidaobaogaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueyezhidaobaogaoView;


/**
 * 学业指导报告
 *
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
public interface XueyezhidaobaogaoService extends IService<XueyezhidaobaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueyezhidaobaogaoView> selectListView(Wrapper<XueyezhidaobaogaoEntity> wrapper);
   	
   	XueyezhidaobaogaoView selectView(@Param("ew") Wrapper<XueyezhidaobaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueyezhidaobaogaoEntity> wrapper);
   	

}

