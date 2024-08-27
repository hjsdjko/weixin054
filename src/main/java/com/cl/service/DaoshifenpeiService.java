package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DaoshifenpeiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DaoshifenpeiView;


/**
 * 导师分配
 *
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
public interface DaoshifenpeiService extends IService<DaoshifenpeiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaoshifenpeiView> selectListView(Wrapper<DaoshifenpeiEntity> wrapper);
   	
   	DaoshifenpeiView selectView(@Param("ew") Wrapper<DaoshifenpeiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaoshifenpeiEntity> wrapper);
   	

}

