package com.zonetry.base.exception;
/**
 * 网络异常
 * @author sks
 *
 */
public class NetException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3573753894280646549L;

	public NetException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NetException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

	public NetException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public NetException(Throwable throwable) {
		super(throwable);
	}

 

}
