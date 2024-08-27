package com.cl.entity.view;

import com.cl.entity.XueyedaoshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 学业导师
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
@TableName("xueyedaoshi")
public class XueyedaoshiView  extends XueyedaoshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XueyedaoshiView(){
	}
 
 	public XueyedaoshiView(XueyedaoshiEntity xueyedaoshiEntity){
 	try {
			BeanUtils.copyProperties(this, xueyedaoshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
