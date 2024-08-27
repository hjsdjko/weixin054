package com.cl.entity.view;

import com.cl.entity.XueyezhidaobaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 学业指导报告
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
@TableName("xueyezhidaobaogao")
public class XueyezhidaobaogaoView  extends XueyezhidaobaogaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueyezhidaobaogaoView(){
	}
 
 	public XueyezhidaobaogaoView(XueyezhidaobaogaoEntity xueyezhidaobaogaoEntity){
 	try {
			BeanUtils.copyProperties(this, xueyezhidaobaogaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
