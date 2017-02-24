package com.zonetry.base.bean;

import com.zonetry.base.constant.Info;
import com.zonetry.base.util.StringUtil;

public abstract class BaseResponse  implements IResponseSuccess  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6483673447708821880L;
	 

	
	int code;
	int status;
	String token;

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean success() {
		return true;
	}
//	public String toString() {
//		if (Info.DEBUG) {
//			return StringUtil.getClassToString(this);
//		}else{
//			return super.toString();
//		}
//	}
	
}
