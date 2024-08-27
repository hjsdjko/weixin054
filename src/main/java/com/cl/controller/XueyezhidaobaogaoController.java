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

import com.cl.entity.XueyezhidaobaogaoEntity;
import com.cl.entity.view.XueyezhidaobaogaoView;

import com.cl.service.XueyezhidaobaogaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 学业指导报告
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
@RestController
@RequestMapping("/xueyezhidaobaogao")
public class XueyezhidaobaogaoController {
    @Autowired
    private XueyezhidaobaogaoService xueyezhidaobaogaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueyezhidaobaogaoEntity xueyezhidaobaogao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueyezhidaobaogao.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xueyedaoshi")) {
			xueyezhidaobaogao.setDaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueyezhidaobaogaoEntity> ew = new EntityWrapper<XueyezhidaobaogaoEntity>();

		PageUtils page = xueyezhidaobaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyezhidaobaogao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueyezhidaobaogaoEntity xueyezhidaobaogao, 
		HttpServletRequest request){
        EntityWrapper<XueyezhidaobaogaoEntity> ew = new EntityWrapper<XueyezhidaobaogaoEntity>();

		PageUtils page = xueyezhidaobaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyezhidaobaogao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueyezhidaobaogaoEntity xueyezhidaobaogao){
       	EntityWrapper<XueyezhidaobaogaoEntity> ew = new EntityWrapper<XueyezhidaobaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueyezhidaobaogao, "xueyezhidaobaogao")); 
        return R.ok().put("data", xueyezhidaobaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueyezhidaobaogaoEntity xueyezhidaobaogao){
        EntityWrapper< XueyezhidaobaogaoEntity> ew = new EntityWrapper< XueyezhidaobaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueyezhidaobaogao, "xueyezhidaobaogao")); 
		XueyezhidaobaogaoView xueyezhidaobaogaoView =  xueyezhidaobaogaoService.selectView(ew);
		return R.ok("查询学业指导报告成功").put("data", xueyezhidaobaogaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueyezhidaobaogaoEntity xueyezhidaobaogao = xueyezhidaobaogaoService.selectById(id);
		xueyezhidaobaogao = xueyezhidaobaogaoService.selectView(new EntityWrapper<XueyezhidaobaogaoEntity>().eq("id", id));
        return R.ok().put("data", xueyezhidaobaogao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueyezhidaobaogaoEntity xueyezhidaobaogao = xueyezhidaobaogaoService.selectById(id);
		xueyezhidaobaogao = xueyezhidaobaogaoService.selectView(new EntityWrapper<XueyezhidaobaogaoEntity>().eq("id", id));
        return R.ok().put("data", xueyezhidaobaogao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueyezhidaobaogaoEntity xueyezhidaobaogao, HttpServletRequest request){
    	xueyezhidaobaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyezhidaobaogao);
        xueyezhidaobaogaoService.insert(xueyezhidaobaogao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueyezhidaobaogaoEntity xueyezhidaobaogao, HttpServletRequest request){
    	xueyezhidaobaogao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueyezhidaobaogao);
        xueyezhidaobaogaoService.insert(xueyezhidaobaogao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueyezhidaobaogaoEntity xueyezhidaobaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueyezhidaobaogao);
        xueyezhidaobaogaoService.updateById(xueyezhidaobaogao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueyezhidaobaogaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    XueyezhidaobaogaoEntity xueyezhidaobaogaoEntity =new XueyezhidaobaogaoEntity();
                    xueyezhidaobaogaoEntity.setId(new Date().getTime());
                     
                    //想数据库中添加新对象
                    xueyezhidaobaogaoService.insert(xueyezhidaobaogaoEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }




}
