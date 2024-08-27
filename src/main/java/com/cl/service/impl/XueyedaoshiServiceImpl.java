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


import com.cl.dao.XueyedaoshiDao;
import com.cl.entity.XueyedaoshiEntity;
import com.cl.service.XueyedaoshiService;
import com.cl.entity.view.XueyedaoshiView;

@Service("xueyedaoshiService")
public class XueyedaoshiServiceImpl extends ServiceImpl<XueyedaoshiDao, XueyedaoshiEntity> implements XueyedaoshiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XueyedaoshiEntity> page = this.selectPage(
                new Query<XueyedaoshiEntity>(params).getPage(),
                new EntityWrapper<XueyedaoshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XueyedaoshiEntity> wrapper) {
		  Page<XueyedaoshiView> page =new Query<XueyedaoshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XueyedaoshiView> selectListView(Wrapper<XueyedaoshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XueyedaoshiView selectView(Wrapper<XueyedaoshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
