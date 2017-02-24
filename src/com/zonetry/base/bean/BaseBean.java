package com.zonetry.base.bean;

import java.io.Serializable;

import com.zonetry.base.constant.Info;
import com.zonetry.base.util.StringUtil;

public abstract class BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1291400904268688384L;
	@Override
	public String toString() {
		if (Info.DEBUG) {
			return StringUtil.getClassToString(this);
		}else{
			return super.toString();
		}
	}
	
	
	
	
	
}
