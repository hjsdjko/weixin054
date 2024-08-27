package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DaoshifenpeiEntity;
import com.cl.entity.view.DaoshifenpeiView;

import com.cl.service.DaoshifenpeiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 导师分配
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
@RestController
@RequestMapping("/daoshifenpei")
public class DaoshifenpeiController {
    @Autowired
    private DaoshifenpeiService daoshifenpeiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaoshifenpeiEntity daoshifenpei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			daoshifenpei.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xueyedaoshi")) {
			daoshifenpei.setDaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DaoshifenpeiEntity> ew = new EntityWrapper<DaoshifenpeiEntity>();

		PageUtils page = daoshifenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoshifenpei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaoshifenpeiEntity daoshifenpei, 
		HttpServletRequest request){
        EntityWrapper<DaoshifenpeiEntity> ew = new EntityWrapper<DaoshifenpeiEntity>();

		PageUtils page = daoshifenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoshifenpei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaoshifenpeiEntity daoshifenpei){
       	EntityWrapper<DaoshifenpeiEntity> ew = new EntityWrapper<DaoshifenpeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daoshifenpei, "daoshifenpei")); 
        return R.ok().put("data", daoshifenpeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaoshifenpeiEntity daoshifenpei){
        EntityWrapper< DaoshifenpeiEntity> ew = new EntityWrapper< DaoshifenpeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daoshifenpei, "daoshifenpei")); 
		DaoshifenpeiView daoshifenpeiView =  daoshifenpeiService.selectView(ew);
		return R.ok("查询导师分配成功").put("data", daoshifenpeiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaoshifenpeiEntity daoshifenpei = daoshifenpeiService.selectById(id);
		daoshifenpei = daoshifenpeiService.selectView(new EntityWrapper<DaoshifenpeiEntity>().eq("id", id));
        return R.ok().put("data", daoshifenpei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaoshifenpeiEntity daoshifenpei = daoshifenpeiService.selectById(id);
		daoshifenpei = daoshifenpeiService.selectView(new EntityWrapper<DaoshifenpeiEntity>().eq("id", id));
        return R.ok().put("data", daoshifenpei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaoshifenpeiEntity daoshifenpei, HttpServletRequest request){
    	daoshifenpei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoshifenpei);
        daoshifenpeiService.insert(daoshifenpei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaoshifenpeiEntity daoshifenpei, HttpServletRequest request){
    	daoshifenpei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoshifenpei);
        daoshifenpeiService.insert(daoshifenpei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DaoshifenpeiEntity daoshifenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daoshifenpei);
        daoshifenpeiService.updateById(daoshifenpei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daoshifenpeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
