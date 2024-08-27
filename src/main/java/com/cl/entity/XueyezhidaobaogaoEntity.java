package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 学业指导报告
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
@TableName("xueyezhidaobaogao")
public class XueyezhidaobaogaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XueyezhidaobaogaoEntity() {
		
	}
	
	public XueyezhidaobaogaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 学号
	 */
					
	private String xuehao;
	
	/**
	 * 学生姓名
	 */
					
	private String xueshengxingming;
	
	/**
	 * 指导时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date zhidaoshijian;
	
	/**
	 * 指导学生情况
	 */
					
	private String zhidaoxueshengqingkuang;
	
	/**
	 * 导师工号
	 */
					
	private String daoshigonghao;
	
	/**
	 * 导师姓名
	 */
					
	private String daoshixingming;
	
	/**
	 * 学业导师评价
	 */
					
	private String xueyedaoshipingjia;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：学号
	 */
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
	/**
	 * 设置：学生姓名
	 */
	public void setXueshengxingming(String xueshengxingming) {
		this.xueshengxingming = xueshengxingming;
	}
	/**
	 * 获取：学生姓名
	 */
	public String getXueshengxingming() {
		return xueshengxingming;
	}
	/**
	 * 设置：指导时间
	 */
	public void setZhidaoshijian(Date zhidaoshijian) {
		this.zhidaoshijian = zhidaoshijian;
	}
	/**
	 * 获取：指导时间
	 */
	public Date getZhidaoshijian() {
		return zhidaoshijian;
	}
	/**
	 * 设置：指导学生情况
	 */
	public void setZhidaoxueshengqingkuang(String zhidaoxueshengqingkuang) {
		this.zhidaoxueshengqingkuang = zhidaoxueshengqingkuang;
	}
	/**
	 * 获取：指导学生情况
	 */
	public String getZhidaoxueshengqingkuang() {
		return zhidaoxueshengqingkuang;
	}
	/**
	 * 设置：导师工号
	 */
	public void setDaoshigonghao(String daoshigonghao) {
		this.daoshigonghao = daoshigonghao;
	}
	/**
	 * 获取：导师工号
	 */
	public String getDaoshigonghao() {
		return daoshigonghao;
	}
	/**
	 * 设置：导师姓名
	 */
	public void setDaoshixingming(String daoshixingming) {
		this.daoshixingming = daoshixingming;
	}
	/**
	 * 获取：导师姓名
	 */
	public String getDaoshixingming() {
		return daoshixingming;
	}
	/**
	 * 设置：学业导师评价
	 */
	public void setXueyedaoshipingjia(String xueyedaoshipingjia) {
		this.xueyedaoshipingjia = xueyedaoshipingjia;
	}
	/**
	 * 获取：学业导师评价
	 */
	public String getXueyedaoshipingjia() {
		return xueyedaoshipingjia;
	}

}
