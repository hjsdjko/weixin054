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

import com.cl.entity.XueyedaoshiEntity;
import com.cl.entity.view.XueyedaoshiView;

import com.cl.service.XueyedaoshiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学业导师
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
@RestController
@RequestMapping("/xueyedaoshi")
public class XueyedaoshiController {
    @Autowired
    private XueyedaoshiService xueyedaoshiService;



    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		XueyedaoshiEntity u = xueyedaoshiService.selectOne(new EntityWrapper<XueyedaoshiEntity>().eq("daoshigonghao", username));
        if(u==null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }
		String token = tokenService.generateToken(u.getId(), username,"xueyedaoshi",  "管理员" );
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody XueyedaoshiEntity xueyedaoshi){
    	//ValidatorUtils.validateEntity(xueyedaoshi);
    	XueyedaoshiEntity u = xueyedaoshiService.selectOne(new EntityWrapper<XueyedaoshiEntity>().eq("daoshigonghao", xueyedaoshi.getDaoshigonghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		xueyedaoshi.setId(uId);
        xueyedaoshiService.insert(xueyedaoshi);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        XueyedaoshiEntity u = xueyedaoshiService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	XueyedaoshiEntity u = xueyedaoshiService.selectOne(new EntityWrapper<XueyedaoshiEntity>().eq("daoshigonghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        xueyedaoshiService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueyedaoshiEntity xueyedaoshi,
		HttpServletRequest request){
        EntityWrapper<XueyedaoshiEntity> ew = new EntityWrapper<XueyedaoshiEntity>();

		PageUtils page = xueyedaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyedaoshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueyedaoshiEntity xueyedaoshi, 
		HttpServletRequest request){
        EntityWrapper<XueyedaoshiEntity> ew = new EntityWrapper<XueyedaoshiEntity>();

		PageUtils page = xueyedaoshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyedaoshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueyedaoshiEntity xueyedaoshi){
       	EntityWrapper<XueyedaoshiEntity> ew = new EntityWrapper<XueyedaoshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueyedaoshi, "xueyedaoshi")); 
        return R.ok().put("data", xueyedaoshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueyedaoshiEntity xueyedaoshi){
        EntityWrapper< XueyedaoshiEntity> ew = new EntityWrapper< XueyedaoshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueyedaoshi, "xueyedaoshi")); 
		XueyedaoshiView xueyedaoshiView =  xueyedaoshiService.selectView(ew);
		return R.ok("查询学业导师成功").put("data", xueyedaoshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueyedaoshiEntity xueyedaoshi = xueyedaoshiService.selectById(id);
		xueyedaoshi = xueyedaoshiService.selectView(new EntityWrapper<XueyedaoshiEntity>().eq("id", id));
        return R.ok().put("data", xueyedaoshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueyedaoshiEntity xueyedaoshi = xueyedaoshiService.selectById(id);
		xueyedaoshi = xueyedaoshiService.selectView(new EntityWrapper<XueyedaoshiEntity>().eq("id", id));
        return R.ok().put("data", xueyedaoshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueyedaoshiEntity xueyedaoshi, HttpServletRequest request){
    	xueyedaoshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyedaoshi);
    	XueyedaoshiEntity u = xueyedaoshiService.selectOne(new EntityWrapper<XueyedaoshiEntity>().eq("daoshigonghao", xueyedaoshi.getDaoshigonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xueyedaoshi.setId(new Date().getTime());
        xueyedaoshiService.insert(xueyedaoshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueyedaoshiEntity xueyedaoshi, HttpServletRequest request){
    	xueyedaoshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyedaoshi);
    	XueyedaoshiEntity u = xueyedaoshiService.selectOne(new EntityWrapper<XueyedaoshiEntity>().eq("daoshigonghao", xueyedaoshi.getDaoshigonghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		xueyedaoshi.setId(new Date().getTime());
        xueyedaoshiService.insert(xueyedaoshi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueyedaoshiEntity xueyedaoshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueyedaoshi);
        xueyedaoshiService.updateById(xueyedaoshi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueyedaoshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
