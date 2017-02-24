package com.zonetry.base.bean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.zonetry.base.adapter.IGetList;

import android.util.Log;

public class BaseListResponse<T> extends BaseResponse implements IGetList<T>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9107689774049745336L;
 
	private List<T> data;
	
	
	
	
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@SuppressWarnings("unused")
	@Override
	public List<T> getList() {
		if (true) {
			List<T> list=new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				try {
					list.add(getTClass().newInstance());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return list;
		}else{
			return getData();
		}

	}
 
	
	
	 private Class<T> persistentClass;
	@SuppressWarnings("unchecked")
	public Class<T> getTClass(){
		if(persistentClass==null){
			persistentClass=(Class<T>)getSuperClassGenricType(getClass(), 0); 
		}
//		Log.v("getTClass",persistentClass);
		return persistentClass;
	}
	
  @SuppressWarnings("rawtypes")
  protected static Class getSuperClassGenricType(final Class clazz, final int index) {
  	
  	Class defaultTClass=SimpleResponse.class;
  	
  	//返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
      Type genType = clazz.getGenericSuperclass();

      if (!(genType instanceof ParameterizedType)) {
         return defaultTClass;
      }
      //返回表示此类型实际类型参数的 Type 对象的数组。
      Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

      if (index >= params.length || index < 0) {
           return defaultTClass;
      }
      if (!(params[index] instanceof Class)) {
           return defaultTClass;
      }

      return (Class) params[index];
  }

}
