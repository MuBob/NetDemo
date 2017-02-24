package com.zonetry.base.exception;
/**
 * 服务器异常
 * @author sks
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3664293350912772834L;

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String detailMessage) {
		super(detailMessage);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

}
