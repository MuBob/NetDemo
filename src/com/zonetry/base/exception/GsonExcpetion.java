package com.zonetry.base.exception;
/**
 * gosn解析异常
 * @author sks
 *
 */
public class GsonExcpetion extends TransformException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1354387165576156695L;

	public GsonExcpetion() {
		super();
	}

	public GsonExcpetion(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public GsonExcpetion(String detailMessage) {
		super(detailMessage);
	}

	public GsonExcpetion(Throwable throwable) {
		super(throwable);
	}

}
