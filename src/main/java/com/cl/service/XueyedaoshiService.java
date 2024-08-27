package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XueyedaoshiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XueyedaoshiView;


/**
 * 学业导师
 *
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
public interface XueyedaoshiService extends IService<XueyedaoshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XueyedaoshiView> selectListView(Wrapper<XueyedaoshiEntity> wrapper);
   	
   	XueyedaoshiView selectView(@Param("ew") Wrapper<XueyedaoshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XueyedaoshiEntity> wrapper);
   	

}

