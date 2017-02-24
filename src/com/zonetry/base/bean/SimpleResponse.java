package com.zonetry.base.bean;

/**
 * 成功或者失败返回的数据类型解析类
 * @author sks
 *
 */
public class SimpleResponse implements IResponseSuccess,IResponseFail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7780555057926342076L;
 
	public boolean success() {
		return code==200;
	}
	
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
	@Override
	public String toString() {
		return "SimpleResponse [code=" + code + ", status=" + status + ", token=" + token + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
