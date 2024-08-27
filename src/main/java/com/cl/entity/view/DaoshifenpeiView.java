package com.cl.entity.view;

import com.cl.entity.DaoshifenpeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 导师分配
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-12 10:05:13
 */
@TableName("daoshifenpei")
public class DaoshifenpeiView  extends DaoshifenpeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DaoshifenpeiView(){
	}
 
 	public DaoshifenpeiView(DaoshifenpeiEntity daoshifenpeiEntity){
 	try {
			BeanUtils.copyProperties(this, daoshifenpeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
