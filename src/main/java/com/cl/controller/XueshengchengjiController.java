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

import com.cl.entity.XueshengchengjiEntity;
import com.cl.entity.view.XueshengchengjiView;

import com.cl.service.XueshengchengjiService;
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
 * 学生成绩
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
@RestController
@RequestMapping("/xueshengchengji")
public class XueshengchengjiController {
    @Autowired
    private XueshengchengjiService xueshengchengjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueshengchengjiEntity xueshengchengji,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xueshengchengji.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XueshengchengjiEntity> ew = new EntityWrapper<XueshengchengjiEntity>();

		PageUtils page = xueshengchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengchengji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XueshengchengjiEntity xueshengchengji, 
		HttpServletRequest request){
        EntityWrapper<XueshengchengjiEntity> ew = new EntityWrapper<XueshengchengjiEntity>();

		PageUtils page = xueshengchengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueshengchengji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueshengchengjiEntity xueshengchengji){
       	EntityWrapper<XueshengchengjiEntity> ew = new EntityWrapper<XueshengchengjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueshengchengji, "xueshengchengji")); 
        return R.ok().put("data", xueshengchengjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueshengchengjiEntity xueshengchengji){
        EntityWrapper< XueshengchengjiEntity> ew = new EntityWrapper< XueshengchengjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueshengchengji, "xueshengchengji")); 
		XueshengchengjiView xueshengchengjiView =  xueshengchengjiService.selectView(ew);
		return R.ok("查询学生成绩成功").put("data", xueshengchengjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueshengchengjiEntity xueshengchengji = xueshengchengjiService.selectById(id);
		xueshengchengji = xueshengchengjiService.selectView(new EntityWrapper<XueshengchengjiEntity>().eq("id", id));
        return R.ok().put("data", xueshengchengji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueshengchengjiEntity xueshengchengji = xueshengchengjiService.selectById(id);
		xueshengchengji = xueshengchengjiService.selectView(new EntityWrapper<XueshengchengjiEntity>().eq("id", id));
        return R.ok().put("data", xueshengchengji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueshengchengjiEntity xueshengchengji, HttpServletRequest request){
    	xueshengchengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengchengji);
        xueshengchengjiService.insert(xueshengchengji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueshengchengjiEntity xueshengchengji, HttpServletRequest request){
    	xueshengchengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xueshengchengji);
        xueshengchengjiService.insert(xueshengchengji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueshengchengjiEntity xueshengchengji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueshengchengji);
        xueshengchengjiService.updateById(xueshengchengji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueshengchengjiService.deleteBatchIds(Arrays.asList(ids));
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
                    XueshengchengjiEntity xueshengchengjiEntity =new XueshengchengjiEntity();
                    xueshengchengjiEntity.setId(new Date().getTime());
                     
                    //想数据库中添加新对象
                    xueshengchengjiService.insert(xueshengchengjiEntity);//方法
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
