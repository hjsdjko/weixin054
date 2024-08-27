package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DaoshifenpeiDao;
import com.cl.entity.DaoshifenpeiEntity;
import com.cl.service.DaoshifenpeiService;
import com.cl.entity.view.DaoshifenpeiView;

@Service("daoshifenpeiService")
public class DaoshifenpeiServiceImpl extends ServiceImpl<DaoshifenpeiDao, DaoshifenpeiEntity> implements DaoshifenpeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaoshifenpeiEntity> page = this.selectPage(
                new Query<DaoshifenpeiEntity>(params).getPage(),
                new EntityWrapper<DaoshifenpeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaoshifenpeiEntity> wrapper) {
		  Page<DaoshifenpeiView> page =new Query<DaoshifenpeiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DaoshifenpeiView> selectListView(Wrapper<DaoshifenpeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaoshifenpeiView selectView(Wrapper<DaoshifenpeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
