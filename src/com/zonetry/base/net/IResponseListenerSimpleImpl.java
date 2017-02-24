package com.zonetry.base.net;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.xml.crypto.dsig.TransformException;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.zonetry.base.bean.IResponseFail;
import com.zonetry.base.bean.SimpleResponse;
import com.zonetry.base.exception.NetException;
import com.zonetry.base.exception.ServiceException;
import com.zonetry.base.util.Log;

public class IResponseListenerSimpleImpl<T extends Serializable> implements IResponseListener<T>{
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void onResponse(String response) {
		Log.v(getClass().getName()+".onResponse", response);
		try {
			boolean success=isSuccess(response);
			Log.v(getClass().getName()+".onResponse.success", success);
			if (success) {
				T successBean=null;
				try {
					successBean=getBeanFromJson(response, getTClass());
					Log.v(getClass().getName()+".onResponse.successBean", successBean);
				} catch (Exception e) {
					throw new TransformException(e);
				}
				try {
					onResponseSuccess(successBean);
				} catch (Exception e) {
					Log.e(getClass().getName()+".onResponse.onResponseSuccess", "处理onResponseSuccess时发生异常");
					throw new Exception(e);
				}
		 

			}else{
				IResponseFail failBean=null;
				try {
					 failBean=(IResponseFail) getBeanFromJson(response,getResponseFailClass());
				} catch (ClassCastException e) {
					Log.e(getClass().getName()+".onResponse", "类型转换失败");
					Log.e(getClass().getName()+".onResponse", "getResponseFailClass()"+getResponseFailClass().getClass().getName());
					Log.e(getClass().getName()+".onResponse", "response"+response);
					Log.e(getClass().getName()+".onResponse", "Bean"+getBeanFromJson(response,getResponseFailClass()));
					throw new TransformException(e);
				}
				catch (Exception e) {
					throw new TransformException(e);
				}
				try {
					onResponseFail(failBean);
				} catch (Exception e) {
					Log.e(getClass().getName()+".onResponse.onResponseFail", "处理onResponseFail时发生异常");
					throw new ServiceException(e);
				}
			 
				
			}
		} catch (NetException e) {
			Log.e(getClass().getName()+".onResponse", "网络异常");
			e.printStackTrace();
		} catch (ServiceException e) {
			Log.e(getClass().getName()+".onResponse", "服务器端返回失败");
			e.printStackTrace();
		} 
		catch (TransformException e) {
			Log.e(getClass().getName()+".onResponse", "类型转换失败");
			e.printStackTrace();
		}
		
		catch (Throwable e) {
			Log.e(getClass().getName()+".onResponse", "出现异常了");
			e.printStackTrace();
			
		}
 
	}
	
 

	public void onResponseSuccess(T bean) {
		Log.v(getClass().getName()+".onResponseSuccess", bean);
	
	}

	@Override
	public void onResponseFail(Serializable result) {
		Log.e(getClass().getName()+".onResponseFail", result);
	}


	public void onError(Throwable e) {
	 
		Log.e(getClass()+".onError", e);
			if(e!=null)
			e.printStackTrace();
			try {
				throw new NetException(e);
			} catch (NetException e1) {
				e1.printStackTrace();
			}
			
	 
		 
	}

	@Override
	public boolean isSuccess(String response) throws NetException, ServiceException, TransformException {
		try {
			JSONObject jsonObject = new JSONObject(response);
			return jsonObject.getInt(INet.CODE)==200;
		} catch (Exception e) {
			throw new TransformException(e);
		}
	}
	protected T getBeanFromJson(String response, Class<T> tClass) {
		return	new Gson().fromJson(response, tClass);
	}

 
	@SuppressWarnings("rawtypes")
	protected  Class getResponseFailClass(){
		return SimpleResponse.class;
	}
	private Class<T> persistentClass;
	@SuppressWarnings("unchecked")
	public Class<T> getTClass(){
//		if(persistentClass==null){
			persistentClass=(Class<T>)getSuperClassGenricType(getClass(), 0); 
//		}
//		Log.v("getTClass", persistentClass);
		return persistentClass;
	}
	/**
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     * 
     *@param clazz
     *            clazz The class to introspect
     * @param index
     *            the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be
     *         determined
     */
 
    @SuppressWarnings("rawtypes")
    protected  static Class getSuperClassGenricType(final Class clazz, final int index) {
    	
    	Class defaultTClass=null;
    	
    	//返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();

//    	Log.v("genType", genType);
        if (!(genType instanceof ParameterizedType)) {
           return defaultTClass;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//    	Log.v("params", params);
//      	Log.v("index", index);
        if (index >= params.length || index < 0) {
             return defaultTClass;
        }
        if (!(params[index] instanceof Class)) {
             return defaultTClass;
        }
 
//      	Log.e("params[index]", params[index]);
        return (Class) params[index];
      	
    }
 
	

}
