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


import com.cl.dao.XueyezhidaobaogaoDao;
import com.cl.entity.XueyezhidaobaogaoEntity;
import com.cl.service.XueyezhidaobaogaoService;
import com.cl.entity.view.XueyezhidaobaogaoView;

@Service("xueyezhidaobaogaoService")
public class XueyezhidaobaogaoServiceImpl extends ServiceImpl<XueyezhidaobaogaoDao, XueyezhidaobaogaoEntity> implements XueyezhidaobaogaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueyezhidaobaogaoEntity> page = this.selectPage(
                new Query<XueyezhidaobaogaoEntity>(params).getPage(),
                new EntityWrapper<XueyezhidaobaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueyezhidaobaogaoEntity> wrapper) {
		  Page<XueyezhidaobaogaoView> page =new Query<XueyezhidaobaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XueyezhidaobaogaoView> selectListView(Wrapper<XueyezhidaobaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueyezhidaobaogaoView selectView(Wrapper<XueyezhidaobaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
