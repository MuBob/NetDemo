package com.zonetry.base.exception;
/**
 * 类型转换异常
 * @author sks
 *
 */
public class TransformException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7510031995350184503L;

	public TransformException() {
		super();
	}

	public TransformException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public TransformException(String detailMessage) {
		super(detailMessage);
	}

	public TransformException(Throwable throwable) {
		super(throwable);
	}

}
